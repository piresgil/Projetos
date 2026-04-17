int encA = 11;
int encB = 12;

int lastA = HIGH;
int value = 0;

void setup() {
  Serial.begin(115200);
  pinMode(encA, INPUT_PULLUP);
  pinMode(encB, INPUT_PULLUP);
}

void loop() {
  int currentA = digitalRead(encA);

  if (currentA != lastA && currentA == LOW) {

    if (digitalRead(encB) == HIGH) value++;
    else value--;

    Serial.println(value);
  }

  lastA = currentA;
}

