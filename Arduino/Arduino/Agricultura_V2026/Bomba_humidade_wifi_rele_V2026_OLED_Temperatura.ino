#include <WiFi.h>
#include <Wire.h>
#include <Adafruit_GFX.h>
#include <Adafruit_SSD1306.h>
#include <Adafruit_AHTX0.h>

// ===== OLED =====
#define SCREEN_WIDTH 128
#define SCREEN_HEIGHT 64
Adafruit_SSD1306 display(SCREEN_WIDTH, SCREEN_HEIGHT, &Wire, -1);

// ===== AHT10 =====
Adafruit_AHTX0 aht;

// ===== CONFIGURAÇÃO DO WIFI =====
const char* ssid = "MEO-4F9B70";
const char* password = "1c3ee143d8";

WiFiServer server(80);

// ===== PINOS =====
const int sensorPin = 34;   // Sensor de humidade do solo
const int relePin   = 27;   // Relé

// ===== CALIBRAÇÃO DO SENSOR =====
const int valorSeco    = 3200;
const int valorMolhado = 1000;

// ===== ESTADO DA BOMBA =====
bool bombaLigada = false;

void setup() {
  Serial.begin(115200);

  // I2C
  Wire.begin(21, 22);

  // OLED
  if (!display.begin(SSD1306_SWITCHCAPVCC, 0x3C)) {
    Serial.println("Falha ao iniciar OLED");
    while(1);
  }
  display.clearDisplay();
  display.setTextSize(1);
  display.setTextColor(SSD1306_WHITE);

  // AHT10
  if (!aht.begin()) {
    Serial.println("Falha ao iniciar AHT10!");
    while(1);
  }
  Serial.println("AHT10 OK!");

  // RELÉ
  pinMode(relePin, OUTPUT);
  digitalWrite(relePin, LOW);

  // WIFI
  WiFi.begin(ssid, password);
  Serial.print("A ligar ao WiFi");
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  Serial.println("\nWiFi ligado!");
  Serial.println(WiFi.localIP());

  server.begin();
}

void loop() {

  // ===== LEITURA DO SENSOR DE SOLO =====
  int leitura = analogRead(sensorPin);
  int percentagem = map(leitura, valorSeco, valorMolhado, 0, 100);
  percentagem = constrain(percentagem, 0, 100);

  // ===== LEITURA DO AHT10 =====
  sensors_event_t humAHT, tempAHT;
  aht.getEvent(&humAHT, &tempAHT);

  float temperatura = tempAHT.temperature;
  float humidadeAr = humAHT.relative_humidity;

  // ===== CONTROLO DO RELÉ =====
  bool novaBombaLigada = percentagem < 50;
  digitalWrite(relePin, novaBombaLigada ? HIGH : LOW);
  bombaLigada = novaBombaLigada;

  // ===== OLED =====
  display.clearDisplay();
  display.setCursor(0, 0);

  display.println("Sistema de Rega");
  display.println("---------------------");

  display.print("Humidade do Solo: ");
  display.print(percentagem);
  display.println("%");

  display.print("Humidade do Ar: ");
  display.print(humidadeAr, 1);
  display.println("%");

  display.print("Temp: ");
  display.print(temperatura, 1);
  display.println("C");

  display.print("Bomba: ");
  display.println(bombaLigada ? "Ligada" : "Desligada");

  display.display();

  // ===== SERVIDOR WEB =====
  WiFiClient client = server.available();
  if (client) {
    String request = client.readStringUntil('\r');
    client.flush();

    String html = "<!DOCTYPE html><html><head><meta charset='UTF-8'>";
    html += "<meta http-equiv='refresh' content='5'>";
    html += "<title>Sistema de Rega</title></head><body>";
    html += "<h1>Sistema de Rega</h1>";

    html += "<p><b>Humidade do Solo:</b> " + String(percentagem) + "%</p>";
    html += "<p><b>Humidade do Ar:</b> " + String(humidadeAr, 1) + "%</p>";
    html += "<p><b>Temperatura:</b> " + String(temperatura, 1) + " C</p>";
    html += "<p><b>Bomba:</b> " + String(bombaLigada ? "Ligada" : "Desligada") + "</p>";

    html += "</body></html>";

    client.println("HTTP/1.1 200 OK");
    client.println("Content-type: text/html");
    client.println();
    client.println(html);
    client.stop();
  }

  delay(500);
}
