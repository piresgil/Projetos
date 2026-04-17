#include "Game.h"

/*
============================================================
  UPDATE AUTOMÁTICO DO DINO
------------------------------------------------------------
  - Corre a cada 50 segundos
  - Reduz atributos naturalmente
  - Ajusta saúde com base nos outros valores
  - Verifica morte e regista score
============================================================
*/
void Game::updateStats()
{
    static unsigned long last = 0;

    // Se já morreu, não atualiza mais nada
    if (currentUI == UI_GAME_OVER)
        return;

    // Atualiza a cada 50 segundos
    if (millis() - last >= 50000)
    {
        last = millis();

        // Decaimento natural dos atributos
        fome--;
        limpeza--;
        felicidade--;
        disciplina--;
        humor--;
        saude--;

        // Perda normal de saúde se algum atributo estiver baixo
        int penalidade = 0;

        if (fome < 40)
            penalidade++;
        if (limpeza < 40)
            penalidade++;
        if (felicidade < 30)
            penalidade++;
        if (disciplina < 30)
            penalidade++;
        if (humor < 50)
            penalidade++;

        saude -= penalidade;

        // Perda severa se TODOS estiverem críticos
        bool todosCriticos =
            (fome < 50) &&
            (limpeza < 50) &&
            (felicidade < 25) &&
            (disciplina < 25);

        if (todosCriticos)
            saude -= 10;

        // Limitar valores entre 0 e 100 (RECOMENDADO)
        fome = constrain(fome, 0, 100);
        limpeza = constrain(limpeza, 0, 100);
        felicidade = constrain(felicidade, 0, 100);
        disciplina = constrain(disciplina, 0, 100);
        saude = constrain(saude, 0, 100);
    }

    // Lógica de morte
    if (saude == 0)
    {
        currentUI = UI_GAME_OVER;

        melodyDeath();
        lastLife = millis() - lifeStart;

        saveScore(lastLife);
        clearSave();
    }
}

/*
============================================================
  AÇÕES DO JOGADOR
------------------------------------------------------------
  - Cada ação aumenta um atributo
  - Também recupera saúde
  - Tudo limitado entre 0 e 100
============================================================
*/

// Comer
void Game::feed()
{

    drawActionAnimation("EAT", 8);

    fome += 20; // comer aumenta fome
    humor += 2.5; 
    saude += 5; // comer melhora saúde

    fome = constrain(fome, 0, 100);
    saude = constrain(saude, 0, 100);
}

// Limpar
void Game::cleanDino()
{

    drawActionAnimation("CLEAN", 8);

    limpeza += 25;
    humor -= 2.5;
    saude += 5;

    limpeza = constrain(limpeza, 0, 100);
    saude = constrain(saude, 0, 100);
}

// Brincar
void Game::play()
{

    drawActionAnimation("PLAY", 8);

    felicidade += 20;
    humor += 3;
    saude -= 2;

    felicidade = constrain(felicidade, 0, 100);
    saude = constrain(saude, 0, 100);
}

// Treinar
void Game::train()
{

    drawActionAnimation("TRAIN", 8);

    disciplina += 15;
    humor -= 2;
    saude += 3;

    disciplina = constrain(disciplina, 0, 100);
    saude = constrain(saude, 0, 100);
}

int Game::getHumor()
{
    return humor;
}

int Game::getHumorState()
{
    int h = getHumor();

    if (h > 80)
        return 4; // Feliz
    if (h > 60)
        return 3; // Normal
    if (h > 40)
        return 2; // Aborrecido
    if (h > 20)
        return 1; // Triste
    return 0;     // Furioso
}

/*
============================================================
  SISTEMA DE SCORES
------------------------------------------------------------
  - Guarda o novo score na última posição
  - Ordena os 3 melhores (maior → menor)
============================================================
*/
void Game::saveScore(unsigned long score)
{
    topScores[2] = score;

    for (int i = 2; i > 0; i--)
    {
        if (topScores[i] > topScores[i - 1])
        {
            unsigned long tmp = topScores[i];
            topScores[i] = topScores[i - 1];
            topScores[i - 1] = tmp;
        }
    }
}
