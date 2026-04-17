#include <Thermistor.h>
#include <Servo.h>

Thermistor thermistor(A3);

Servo motor;
int pos = 0;

int pinR = 11;
int pinG = 10;
int pinB = 9 ;

boolean anodo_comum = true;

int pinPot = 0;

int luz = 0;
int pinLuz = 2;

void setup() {
  // put your setup code here, to run once:

  Serial.begin(9600);

  motor.attach(12);

  pinMode(pinR, OUTPUT);
  pinMode(pinG, OUTPUT);
  pinMode(pinB, OUTPUT);

  pinMode(pinLuz, OUTPUT);
}

void loop() {
  // put your main code here, to run repeatedly:



  int temp = thermistor.getTemp();
  Serial.print("Temperatura: ");
  Serial.println(temp);

  pinPot = analogRead(A5);
  Serial.print("POT: ");
  Serial.println(pinPot);

  luz = analogRead(A4);
  luminosidade(luz);

  randomColor();
}

void servoStart() {
  luminosidade(luz);
  
  motor.write(pos += 25);
}

void servoEnd() {
  luminosidade(luz);
  
  motor.write(pos -= 25);
}


void luminosidade (int luz) {
  if (luz <= 80) {
    digitalWrite(pinLuz, HIGH);
  } else {
    digitalWrite(pinLuz, LOW);
  }
  luz = analogRead(A4);
  Serial.print("Luz: ");
  Serial.println(luz);
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
  int color = random(6);

  if (color == 1) {
    setColor (255, 0, 0);
  }
  if (color == 2) {
    setColor (0, 255, 0);
  }
  if (color == 3) {
    setColor (0, 0, 255);
  }
  if (color == 4) { // Amarelo
    setColor (255, 255, 0);
  }
   if (color == 5) { // Lilás
    setColor (255, 0, 255);
  }
   if (color == 5) { // azul claro
    setColor (0, 255, 255);
  }
   if (color == 6) { // roxo
    setColor (102, 0, 51);
  }
  delay(pinPot);
}
