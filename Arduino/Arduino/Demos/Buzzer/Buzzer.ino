int pinR = 11;
int pinG = 10;
int pinB = 9 ;
boolean anodo_comum = true;

int pinButon = 8;

int pinBuzzer = 12;

void setup() {
  // put your setup code here, to run once:
pinMode(pinR, OUTPUT);
pinMode(pinG, OUTPUT);
pinMode(pinB, OUTPUT);

pinMode(pinButon, INPUT);

pinMode(pinBuzzer,OUTPUT);
}

void loop() {
  // put your main code here, to run repeatedly:

setColor(255,0,0);
delay(1000);
setColor(0,255,0);
delay(1000);
setColor(0,0,255);
delay(1000);
}

 void butonBuzzer(){
  int stats = digitalRead(pinButon);
      if(stats == HIGH){
      digitalWrite(pinBuzzer,1000);
      delay(50);
      digitalWrite(pinBuzzer,LOW);
    }else{      
      digitalWrite(pinBuzzer,LOW);
    }
 }
 
  void setColor(int red, int green, int blue){
  if(anodo_comum == true){
    red = 255 - red;
    green = 255 - green;
    blue = 255 - blue;
    }
    butonBuzzer();
    analogWrite(pinR, red);
    analogWrite(pinG, green);
    analogWrite(pinB, blue);
  }
