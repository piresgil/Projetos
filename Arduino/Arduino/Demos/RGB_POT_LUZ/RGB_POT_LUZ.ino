#include <Thermistor.h>

int pinR = 11;
int pinG = 10;
int pinB = 9 ;

boolean anodo_comum = true;

int pinPot = 0;

int luz = 0;
int pinLuz = 2;

Thermistor temp(A3);

void setup() {
  // put your setup code here, to run once:

  Serial.begin(9600);

  pinMode(pinR, OUTPUT);
  pinMode(pinG, OUTPUT);
  pinMode(pinB, OUTPUT);

  pinMode(pinLuz, OUTPUT);
}

void loop() {
  // put your main code here, to run repeatedly:

  pinPot = analogRead(A5);
  Serial.print("POT: ");
  Serial.println(pinPot);

  luz = analogRead(A4);
  luminosidade(luz);
  Serial.print("Luz: ");
  Serial.println(luz);

  int temperatura = temp.getTemp();
  Serial.print("Temperatura: ");
  Serial.println(luz);
  randomColor();
}

void luminosidade (int luz) {
  if (luz <= 90) {
    digitalWrite(pinLuz, HIGH);
  } else {
    digitalWrite(pinLuz, LOW);
  }
}


void setColor(int red, int green, int blue) {
  if (anodo_comum == true) {
    red = 255 - red;
    green = 255 - green;
    blue = 255 - blue;
  }
  analogWrite(pinR, red);
  analogWrite(pinG, green);
  analogWrite(pinB, blue);
}

void randomColor() {
  setColor(random(10 - 255), random(10 - 255), random(10 - 255));
  delay(pinPot);
}
