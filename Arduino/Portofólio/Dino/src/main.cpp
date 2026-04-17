#include <Arduino.h>
#include "Game/Game.h"

Game game;

void setup() {
    game.begin();
   // game.oledTest();
}

void loop() {
  game.update();
}
