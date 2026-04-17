#include "Game.h"
#include <Arduino.h>

/*
============================================================
  MELODIA DE ARRANQUE
------------------------------------------------------------
  - Três notas descendentes
  - Curta e simpática
============================================================
*/
void Game::melodyStart() {
    int notes[] = { 1046, 988, 880 };
    int dur[]   = { 120, 120, 180 };

    for (int i = 0; i < 3; i++) {
        tone(BUZZER_PIN, notes[i], dur[i]);
        delay(dur[i] + 20);
    }
}

/*
============================================================
  MELODIA DE SAÍDA
------------------------------------------------------------
  - Igual à de arranque (podes mudar depois)
============================================================
*/
void Game::melodyExit() {
    int notes[] = { 1046, 988, 880 };
    int dur[]   = { 120, 120, 180 };

    for (int i = 0; i < 3; i++) {
        tone(BUZZER_PIN, notes[i], dur[i]);
        delay(dur[i] + 20);
    }
}

/*
============================================================
  MELODIA DE MORTE
------------------------------------------------------------
  - Sequência dramática descendente
  - Inspirada no estilo Mario
============================================================
*/
void Game::melodyDeath() {
    int notes[] = { 988, 932, 880, 784, 698, 659, 587, 523 };
    int dur[]   = { 200, 220, 250, 300, 350, 400, 450, 600 };

    for (int i = 0; i < 8; i++) {
        tone(BUZZER_PIN, notes[i], dur[i]);
        delay(dur[i] + 40);
    }

    // Golpe final
    tone(BUZZER_PIN, 196, 900);
    delay(950);
}
