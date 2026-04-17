#include <WiFi.h>
#include <WebServer.h>

const char* ssid = "MEO-4F9B70";
const char* password = "1c3ee143d8";

WebServer server(80);  // Porta 80 por defeito

void handleRoot() {
  server.send(200, "text/html", "<h1>ESP32 Online!</h1><p>Servidor HTTP esta a funcionar</p>");
}

void setup() {
  Serial.begin(115200);
  delay(1000);
  Serial.println();
  Serial.println("A conectar ao WiFi...");

  WiFi.begin(ssid, password);

  int tentativas = 0;
  while (WiFi.status() != WL_CONNECTED && tentativas < 20) {
    delay(500);
    Serial.print(".");
    tentativas++;
  }

  if (WiFi.status() == WL_CONNECTED) {
    Serial.println();
    Serial.println("WiFi conectado!");
    Serial.print("Endereço IP: ");
    Serial.println(WiFi.localIP());

    server.on("/", handleRoot);
    server.begin();
    Serial.println("Servidor HTTP iniciado");
  } else {
    Serial.println("Falha ao conectar à WiFi.");
  }
}

void loop() {
  server.handleClient();  // Essencial para responder aos pedidos
}
