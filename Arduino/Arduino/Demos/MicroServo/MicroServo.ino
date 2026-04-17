#include <Servo.h>

Servo motor;
int pos = 25;

void setup() {
  // put your setup code here, to run once:

  motor.attach(12);

}

void loop() {
  // put your main code here, to run repeatedly:

  for(pos = 25; pos < 180; pos += 25){
  motor.write(pos);
  delay(2000);
  }

  for(pos = 180; pos > 25; pos -= 25){
  motor.write(pos);
  delay(2000);
  }


}
