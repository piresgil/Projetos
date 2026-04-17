#include <Wire.h>
#include <Adafruit_GFX.h>
#include <Adafruit_SSD1306.h>
#include <VL53L0X.h>

#define SCREEN_WIDTH 128
#define SCREEN_HEIGHT 64

Adafruit_SSD1306 display(SCREEN_WIDTH, SCREEN_HEIGHT, &Wire, -1);
VL53L0X tof;

const int pot = A0;

// Filtro exponencial para o pot
float filtered = 0;
float alpha = 0.1;
int lastValue = -1;

void setup() {
  Serial.begin(115200);
  Wire.begin();  // Leonardo usa SDA=2, SCL=3 automaticamente

  // OLED
  if (!display.begin(SSD1306_SWITCHCAPVCC, 0x3C)) {
    Serial.println("Falha ao iniciar OLED!");
    while (true);
  }

  display.clearDisplay();
  display.setTextSize(1);
  display.setTextColor(SSD1306_WHITE);
  display.setCursor(0, 0);
  display.println("OLED + POT + ToF");
  display.println("A iniciar...");
  display.display();
  delay(1000);

  // ToF
  tof.init();
  tof.setTimeout(500);
  tof.startContinuous();
}

void loop() {
  // POT
  int raw = analogRead(pot);
  filtered = (alpha * raw) + ((1 - alpha) * filtered);
  int potValue = map(filtered, 0, 1023, 0, 127);

  if (abs(potValue - lastValue) < 2) {
    potValue = lastValue;
  } else {
    lastValue = potValue;
  }

  // ToF
  int dist = tof.readRangeContinuousMillimeters();
  if (tof.timeoutOccurred()) {
    dist = -1;
  }

  // OLED
  display.clearDisplay();
  display.setCursor(0, 0);
  display.print("Pot: ");
  display.println(potValue);

  display.setCursor(0, 20);
  display.print("Dist: ");
  if (dist < 0) {
    display.println("Erro");
  } else {
    display.print(dist);
    display.println(" mm");
  }

  display.display();

  // SERIAL
  Serial.print("Pot: ");
  Serial.print(potValue);
  Serial.print(" | Dist: ");
  Serial.println(dist);

  delay(20);
}

