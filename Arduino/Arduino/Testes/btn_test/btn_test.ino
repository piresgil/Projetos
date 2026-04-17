int botao = 2;
int ultimoEstado = HIGH;

void setup() {
  Serial.begin(115200);
  pinMode(botao, INPUT_PULLUP);
}

void loop() {
  int estado = digitalRead(botao);

  if (estado != ultimoEstado) {
    if (estado == LOW) {
      Serial.println("Botao PRESSIONADO");
    } else {
      Serial.println("Botao SOLTO");
    }
    ultimoEstado = estado;
  }

  delay(5);
}
