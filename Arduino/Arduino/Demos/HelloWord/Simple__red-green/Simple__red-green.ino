/*
* @ Daniel Gil
*/
// the setup function runs once when you press reset or power the board
void setup() {
 pinMode (10, OUTPUT);
 pinMode (9, OUTPUT);
 pinMode(7,INPUT_PULLUP);
}

// the loop function runs over and over again forever
void loop() {

  int botao;
  botao = digitalRead(7);
  
  digitalWrite(10, botao);
  digitalWrite(9, botao);
}
