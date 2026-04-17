int potA5 = A5;
float filtered = 0;
int lastOut = -1;

void setup() {
  Serial.begin(115200);
}

void loop() {
  int raw = analogRead(potA5);

  // Filtro EMA (alpha controla suavidade)
  float alpha = 0.1;  
  filtered = (alpha * raw) + ((1 - alpha) * filtered);

  int out = (int)filtered;

  if (abs(out - lastOut) > 2) {
    lastOut = out;
    Serial.print("P0=");
    Serial.println(out);
  }

  delay(2);
}
