int pinR = 11;
int pinG = 10;
int pinB = 9 ;

int pinPot = 0;

int luz = 0;

boolean anodo_comum = true;

void setup() {
  // put your setup code here, to run once:

Serial.begin(9600);
  
pinMode(pinR, OUTPUT);
pinMode(pinG, OUTPUT);
pinMode(pinB, OUTPUT);
}

void loop() {
  // put your main code here, to run repeatedly:

pinPot = analogRead(A5);

luz = analogRead(A4);

Serial.print("Luz: ");
Serial.print(luz);

setColor(255,0,0);
delay(pinPot);
setColor(0,255,0);
delay(pinPot);
setColor(0,0,255);
delay(pinPot);

// Serial.println(pinPot);
 }

 
  void setColor(int red, int green, int blue){
  if(anodo_comum == true){
    red = 255 - red;
    green = 255 - green;
    blue = 255 - blue;
    }
    analogWrite(pinR, red);
    analogWrite(pinG, green);
    analogWrite(pinB, blue);
  }
