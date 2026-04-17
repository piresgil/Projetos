#include <WiFi.h>
#include <ESP_Mail_Client.h>
#include <time.h>  // Para obter a hora via NTP

// WiFi
const char* ssid = "MEO-4F9B70";
const char* password = "1c3ee143d8";

// Sensor e relé
const int sensorPin = 34;
const int relePin = 27;
const int valorSeco = 3200;
const int valorMolhado = 1000;

WiFiServer server(80);

// Histórico
const int maxRegistos = 10;
int historicoHumidade[maxRegistos];
bool historicoBomba[maxRegistos];
String historicoHora[maxRegistos];
int idx = 0;
bool bombaLigada = false;

// Email
#define SMTP_HOST "smtp.gmail.com"
#define SMTP_PORT 465
#define AUTHOR_EMAIL "ruidanielgil@gmail.com"
#define AUTHOR_PASSWORD "durm biwi wdza pzzr"
#define RECIPIENT_EMAIL "ruidanielgil@gmail.com"

SMTPSession smtp;

// Setup da hora NTP
const char* ntpServer = "pool.ntp.org";
const long gmtOffset_sec = 0;         // Para Portugal: 0 no inverno, 3600 no verão
const int daylightOffset_sec = 3600;  // Horário de verão

String getHoraAtual() {
  struct tm timeinfo;
  if (!getLocalTime(&timeinfo)) return "N/A";
  char buffer[30];
  strftime(buffer, sizeof(buffer), "%Y-%m-%d %H:%M:%S", &timeinfo);
  return String(buffer);
}

void enviarEmail(String assunto, String corpo) {
  SMTP_Message message;

  message.sender.name = "ESP32 Sistema Rega";
  message.sender.email = AUTHOR_EMAIL;
  message.subject = assunto;
  message.addRecipient("Utilizador", RECIPIENT_EMAIL);
  message.text.content = corpo;
  message.text.charSet = "utf-8";
  message.text.transfer_encoding = Content_Transfer_Encoding::enc_7bit;

  // Nova configuração de sessão
  Session_Config config;
  config.server.host_name = SMTP_HOST;
  config.server.port = SMTP_PORT;
  config.login.email = AUTHOR_EMAIL;
  config.login.password = AUTHOR_PASSWORD;
  config.login.user_domain = "";

  if (!smtp.connect(&config)) {
    Serial.println("Falha ao conectar ao servidor SMTP.");
    return;
  }

  if (!MailClient.sendMail(&smtp, &message)) {
    Serial.print("Erro ao enviar email: ");
    Serial.println(smtp.errorReason());
  } else {
    Serial.println("Email enviado com sucesso!");
  }

  smtp.closeSession();  // fecha a sessão
}


void setup() {
  Serial.begin(115200);
  pinMode(relePin, OUTPUT);
  digitalWrite(relePin, LOW);

  WiFi.begin(ssid, password);
  Serial.print("A conectar ao WiFi");
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  Serial.println("\nWiFi conectado!");
  Serial.println(WiFi.localIP());

  // Sincroniza com o servidor de hora
  configTime(gmtOffset_sec, daylightOffset_sec, ntpServer);
  Serial.println("A obter hora NTP...");
  delay(2000);

  server.begin();

  for (int i = 0; i < maxRegistos; i++) {
    historicoHumidade[i] = -1;
    historicoBomba[i] = false;
    historicoHora[i] = "";
  }
}

void loop() {
  int leitura = analogRead(sensorPin);
  int percentagem = map(leitura, valorSeco, valorMolhado, 0, 100);
  percentagem = constrain(percentagem, 0, 100);

  bool novaBombaLigada = percentagem < 50;
  digitalWrite(relePin, novaBombaLigada ? HIGH : LOW);

  // Se houve mudança de estado na bomba, envia email
  if (novaBombaLigada != bombaLigada) {
    bombaLigada = novaBombaLigada;
    String assunto = bombaLigada ? "Bomba LIGADA" : "Bomba DESLIGADA";
    String corpo = "A bomba foi " + String(bombaLigada ? "ligada" : "desligada");
    corpo += "\nHora: " + getHoraAtual();
    corpo += "\nHumidade atual: " + String(percentagem) + "%";
    enviarEmail(assunto, corpo);
  }

  // Guarda no histórico
  historicoHumidade[idx] = percentagem;
  historicoBomba[idx] = bombaLigada;
  historicoHora[idx] = getHoraAtual();
  idx = (idx + 1) % maxRegistos;

  // Página HTML
  WiFiClient client = server.available();
  if (client) {
    Serial.println("Cliente conectado.");
    String request = client.readStringUntil('\r');
    client.flush();

    String html = "<!DOCTYPE html><html><head><meta charset='UTF-8'>";
    html += "<meta http-equiv='refresh' content='10'><title>Humidade</title></head><body>";
    html += "<h1>Registo de Humidade e Estado da Bomba</h1>";
    html += "<table border='1' cellpadding='5'><tr><th>Data/Hora</th><th>Humidade (%)</th><th>Bomba</th></tr>";

    for (int i = 0; i < maxRegistos; i++) {
      int pos = (idx + i) % maxRegistos;
      if (historicoHumidade[pos] == -1) continue;
      html += "<tr>";
      html += "<td>" + historicoHora[pos] + "</td>";
      html += "<td>" + String(historicoHumidade[pos]) + "</td>";
      html += String("<td>") + (historicoBomba[pos] ? "Ligada" : "Desligada") + "</td>";
      html += "</tr>";
    }

    html += "</table></body></html>";

    client.println("HTTP/1.1 200 OK");
    client.println("Content-type: text/html");
    client.println();
    client.println(html);
    client.stop();
  }

  delay(10000);  // Espera 10 segundos
}
