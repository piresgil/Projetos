#define buzzer_pin 13
int tempo = 1500;

#define l_G4  2
#define l_A   3
#define l_B   4
#define l_C   5
#define l_D   6
#define l_E   7
#define l_F   8
#define l_G5  9

int G4 =  392;
int A  =  440;
int B  =  493;
int C  =  523;
int D  =  587;
int E  =  659;
int F  =  698;
int G5 =  784;

void G4_func (float note_time);
void A_func  (float note_time);
void B_func  (float note_time);
void C_func  (float note_time);
void D_func  (float note_time);
void E_func  (float note_time);
void F_func  (float note_time);
void G5_func (float note_time);

void setup() {
  for(int i=2; i<=9; i++){
    pinMode(i,OUTPUT);
    digitalWrite(i,LOW);  
  }

}

void loop() {
  /*
         Colcheia -> 0.5 tempo -> 1/8 -> 0.125
         Semínima ->   1 tempo -> 1/4 ->  0.25
           Mínima ->  2 tempos -> 2/4 ->   0.5
  Mínima pontuada ->  3 tempos -> 3/4 ->  0.75
  */
  
  G4_func(0.125);
  G4_func(0.125);
  A_func(0.5);
  G4_func(0.25);
  C_func(0.25);
  B_func(0.75);

  G4_func(0.125);
  G4_func(0.125);
  A_func(0.5);
  G4_func(0.25);
  D_func(0.25);
  C_func(0.75);

  E_func(0.125);
  E_func(0.125);
  G5_func(0.5);
  E_func(0.25);
  C_func(0.25);
  B_func(0.25);

  A_func(0.5);
  F_func(0.125);
  F_func(0.125);
  E_func(0.5);
  C_func(0.25);
  D_func(0.25);
  C_func(0.75);
}

void G4_func(float note_time){
  tone(buzzer_pin,G4);
  digitalWrite(l_G4,HIGH);
  delay(tempo*note_time);
  noTone(buzzer_pin);
  digitalWrite(l_G4,LOW);
}

void A_func(float note_time){
  tone(buzzer_pin,A);
  digitalWrite(l_A,HIGH);
  delay(tempo*note_time);
  noTone(buzzer_pin);
  digitalWrite(l_A,LOW);
}

void B_func(float note_time){
  tone(buzzer_pin,B);
  digitalWrite(l_B,HIGH);
  delay(tempo*note_time);
  noTone(buzzer_pin);
  digitalWrite(l_B,LOW);
}

void C_func(float note_time){
  tone(buzzer_pin,C);
  digitalWrite(l_C,HIGH);
  delay(tempo*note_time);
  noTone(buzzer_pin);
  digitalWrite(l_C,LOW);
}

void D_func(float note_time){
  tone(buzzer_pin,D);
  digitalWrite(l_D,HIGH);
  delay(tempo*note_time);
  noTone(buzzer_pin);
  digitalWrite(l_D,LOW);
}

void E_func(float note_time){
  tone(buzzer_pin,E);
  digitalWrite(l_E,HIGH);
  delay(tempo*note_time);
  noTone(buzzer_pin);
  digitalWrite(l_E,LOW);
}

void F_func(float note_time){
  tone(buzzer_pin,F);
  digitalWrite(l_F,HIGH);
  delay(tempo*note_time);
  noTone(buzzer_pin);
  digitalWrite(l_F,LOW);
}

void G5_func(float note_time){
  tone(buzzer_pin,G5);
  digitalWrite(l_G5,HIGH);
  delay(tempo*note_time);
  noTone(buzzer_pin);
  digitalWrite(l_G5,LOW);
}
