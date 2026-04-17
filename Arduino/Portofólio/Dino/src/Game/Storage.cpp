#include "Game.h"
#include <Preferences.h>

/*
============================================================
  GUARDA O PROGRESSO DO DINO
------------------------------------------------------------
  - Usa a namespace "dino" na flash do ESP32
  - Guarda todos os atributos importantes
  - Guarda evolução, tempo de vida e top scores
  - prefs.begin("dino", false) → modo escrita
============================================================
*/
void Game::saveGame()
{
  prefs.begin("dino", false); // abre para escrita

  // Atributos principais
  prefs.putInt("fome", fome);
  prefs.putInt("limpeza", limpeza);
  prefs.putInt("felicidade", felicidade);
  prefs.putInt("disciplina", disciplina);
  prefs.putInt("saude", saude);

  // evolução
  prefs.putFloat("evolution", evolution);
  prefs.putInt("evo", evolutionStage);

  // Tempo de vida
  prefs.putULong("lifeStart", lifeStart);

  // Scores
  prefs.putULong("score1", topScores[0]);
  prefs.putULong("score2", topScores[1]);
  prefs.putULong("score3", topScores[2]);

  prefs.end(); // fecha a sessão
}

/*
============================================================
  CARREGA O PROGRESSO DO DINO
------------------------------------------------------------
  - prefs.begin("dino", true) → modo leitura
  - Se não existir valor guardado, usa defaults seguros
  - Restaura atributos, evolução, tempo e scores
============================================================
*/
void Game::loadGame()
{
  prefs.begin("dino", true); // abre para leitura

  // Atributos principais (com valores default)
  fome = prefs.getInt("fome", fome);
  limpeza = prefs.getInt("limpeza", limpeza);
  felicidade = prefs.getInt("felicidade", felicidade);
  disciplina = prefs.getInt("disciplina", disciplina);
  saude = prefs.getInt("saude", saude);

  // evolução
  evolution = prefs.getFloat("evolution", 100);
  evolutionStage = prefs.getInt("evo", 0);

  // Tempo de vida (se não existir, começa agora)
  lifeStart = prefs.getULong("lifeStart", millis());

  // Scores
  topScores[0] = prefs.getULong("score1", 0);
  topScores[1] = prefs.getULong("score2", 0);
  topScores[2] = prefs.getULong("score3", 0);

  prefs.end();
}

/*
============================================================
  APAGA TODO O PROGRESSO
------------------------------------------------------------
  - Usado quando o Dino MORRE
  - prefs.clear() remove todas as chaves da namespace
============================================================
*/
void Game::clearSave()
{
  prefs.begin("dino", false); // abre para escrita
  prefs.clear();              // apaga tudo
  prefs.end();
}
