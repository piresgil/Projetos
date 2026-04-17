int ledPin = 2;   // testar cor 1 no D2
int ledPin2 = 3; // descomenta se quiseres testar a outra cor

void setup() {
  pinMode(ledPin, OUTPUT);
  pinMode(ledPin2, OUTPUT);

  Serial.begin(115200);
}

void loop() {

  // Acende
  digitalWrite(ledPin, HIGH);
  Serial.println("LED ON");
  delay(500);

  // Apaga
  digitalWrite(ledPin, LOW);
  Serial.println("LED OFF");
  delay(500);


  // Se quiseres testar a outra cor:
  digitalWrite(ledPin2, HIGH);
  delay(500);
  digitalWrite(ledPin2, LOW);
  delay(500);
  
}
