int ultimo = HIGH;

void setup() {
  Serial.begin(115200);
  pinMode(4, INPUT_PULLUP);  // switch ligado ao D4
}

void loop() {
  int estado = digitalRead(4);

  if (estado != ultimo) {
    Serial.println(estado == LOW ? "ON" : "OFF");
    ultimo = estado;
  }

  delay(5);
}

