#include <WiFi.h>

// WiFi
const char* ssid = "MEO-4F9B70";
const char* password = "1c3ee143d8";

// Sensor
const int sensorPin = 34; // Pino ADC

// Valores de calibração
const int valorSeco = 3200;
const int valorMolhado = 1000;

WiFiServer server(80);

void setup() {
  Serial.begin(115200);
  delay(1000);

  WiFi.begin(ssid, password);
  Serial.print("A conectar ao WiFi");
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }

  Serial.println("\nWiFi conectado!");
  Serial.print("Endereço IP: ");
  Serial.println(WiFi.localIP());

  server.begin();
}

void loop() {
  WiFiClient client = server.available();
  if (client) {
    Serial.println("Cliente conectado.");

    // Lê o pedido HTTP
    String request = client.readStringUntil('\r');
    client.flush();

    int leitura = analogRead(sensorPin);
    
    // Converte para percentagem
    int percentagem = map(leitura, valorSeco, valorMolhado, 0, 100);
    percentagem = constrain(percentagem, 0, 100); // Garante que está entre 0 e 100

    // Mostra no monitor
    Serial.print("Valor ADC: ");
    Serial.print(leitura);
    Serial.print(" -> Humidade: ");
    Serial.print(percentagem);
    Serial.println("%");

    // HTML
    String html = "<!DOCTYPE html><html><head><meta charset='UTF-8'><meta http-equiv='refresh' content='10'><title>Humidade</title></head><body>";

    html += "<h1>Humidade do Solo</h1>";
    html += "<p>" + String(percentagem) + "%</p>";
    html += "</body></html>";

    // Envia resposta
    client.println("HTTP/1.1 200 OK");
    client.println("Content-type: text/html");
    client.println();
    client.println(html);
    client.stop();
  }
    delay(10000); // Espera 10 segundos antes de nova leitura
}
