/*
* @ Daniel Gil
*/
int pinVermelho = 10;
int pinAmarelo = 9;
int pinVerde = 8;
int pinBotao = 7;

int pinRed = 3;
int pinGreen = 2;

int faseSemaforo;
int botao;
int estadoBotao;

int tempo;
int estadoTempo;

void setup() {
  pinMode(pinVerde, OUTPUT);
  pinMode(pinAmarelo, OUTPUT);
  pinMode(pinVermelho, OUTPUT);
  pinMode(pinBotao, INPUT);

  pinMode(pinRed, OUTPUT);
  pinMode(pinGreen, OUTPUT);
  
  faseSemaforo =1;

  estadoBotao = digitalRead(pinBotao);

tempo = 0;
estadoTempo = HIGH;
}


void loop() {

  botao = digitalRead(pinBotao);

  if((botao == HIGH )&& (estadoBotao == LOW)){

    if(faseSemaforo < 4){
      faseSemaforo = faseSemaforo + 1;
    }else{
      faseSemaforo = 1;
    }
  }
  estadoBotao = botao;

   if (faseSemaforo == 1){
      digitalWrite(pinVerde, HIGH);
      digitalWrite(pinAmarelo, LOW);
      digitalWrite(pinVermelho, LOW);

      digitalWrite(pinRed, HIGH);
      digitalWrite(pinGreen, LOW);
   }
   
   if(faseSemaforo == 2){
      digitalWrite(pinVerde, LOW);
      digitalWrite(pinAmarelo, HIGH);
      digitalWrite(pinVermelho, LOW);
      
      digitalWrite(pinRed, HIGH);
      digitalWrite(pinGreen, LOW);
   }

   if(faseSemaforo == 3){
      digitalWrite(pinVerde, LOW);
      digitalWrite(pinAmarelo, LOW);
      digitalWrite(pinVermelho, HIGH);
      
      digitalWrite(pinRed, LOW);
      digitalWrite(pinGreen, HIGH);
   }

     if(faseSemaforo == 4){   //Pedesttre piscando
      digitalWrite(pinVerde, LOW);
      digitalWrite(pinAmarelo, LOW);
      digitalWrite(pinVermelho, HIGH);

      tempo = tempo + 1;

      if(tempo == 400){
        estadoTempo = !estadoTempo;
        tempo = 0;
      }
      
      digitalWrite(pinRed, LOW);
      digitalWrite(pinGreen, estadoTempo);
   }
   delay(1);
}
