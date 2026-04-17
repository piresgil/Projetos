#include <Wire.h>
#include <Adafruit_GFX.h>
#include <Adafruit_SSD1306.h>
#include <Adafruit_AHTX0.h>

#define SCREEN_WIDTH 128
#define SCREEN_HEIGHT 64

Adafruit_SSD1306 display(SCREEN_WIDTH, SCREEN_HEIGHT, &Wire, -1);
Adafruit_AHTX0 aht;

void setup() {
  Serial.begin(115200);

  // I2C
  Wire.begin(21, 22);

  // OLED
  if (!display.begin(SSD1306_SWITCHCAPVCC, 0x3C)) {
    Serial.println("Falha ao iniciar OLED!");
    while (1);
  }
  display.clearDisplay();
  display.setTextSize(1);
  display.setTextColor(SSD1306_WHITE);

  // AHT10
  if (!aht.begin()) {
    Serial.println("Falha ao iniciar AHT10!");
    while (1);
  }
  Serial.println("AHT10 OK!");
}

void loop() {
  sensors_event_t hum, temp;
  aht.getEvent(&hum, &temp);

  float temperatura = temp.temperature;
  float humidadeAr = hum.relative_humidity;

  // Serial debug
  Serial.print("Temp: ");
  Serial.print(temperatura);
  Serial.print(" °C   Humidade: ");
  Serial.print(humidadeAr);
  Serial.println(" %");

  // OLED
  display.clearDisplay();
  display.setCursor(0, 0);

  display.println("AHT10 Teste");
  display.println("----------------");

  display.print("Temp: ");
  display.print(temperatura, 1);
  display.println(" C");

  display.print("Humidade: ");
  display.print(humidadeAr, 1);
  display.println(" %");

  display.display();

  delay(2000);
}
