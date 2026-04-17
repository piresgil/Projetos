/*
* @ Daniel Gil
*/
// the setup function runs once when you press reset or power the board
void setup() {
 pinMode (10, OUTPUT);
 pinMode (9, OUTPUT);
}

// the loop function runs over and over again forever
void loop() {

  int intervalo;
  intervalo = 200;
  
  digitalWrite(10, HIGH);
  digitalWrite(9, LOW);
  delay(intervalo);

  digitalWrite(10, LOW);
  digitalWrite(9, HIGH);
  delay(intervalo);
}
