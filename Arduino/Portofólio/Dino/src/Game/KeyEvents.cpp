#include "Game.h"

/*
============================================================
  LEITURA DE BOTÕES
  - Botões usam pull-up → pressionado = LOW
============================================================
*/
bool Game::pressed(int pin)
{
    return digitalRead(pin) == LOW;
}

/*
============================================================
  SISTEMA DE NAVEGAÇÃO PRINCIPAL
  - Controla toda a UI com 3 botões
  - Usa detecção de borda (wasX → XNow)
  - Usa inputLock para anti-spam global
============================================================
*/
void Game::handleNavigation()
{
    // Anti-spam global
    if (millis() < inputLock)
        return;

    // Leitura dos botões
    bool upNow = pressed(25);     // Botão 1 → UP
    bool backNow = pressed(14);   // Botão 2 → BACK
    bool selectNow = pressed(27); // Botão 3 → SELECT

    /*
    ============================================================
      UI_HOME (Ecrã principal)
      - UP → STATUS
      - BACK → HUMOR / AÇÕES
      - SELECT → INTERNET
    ============================================================
    */
    if (currentUI == UI_HOME)
    {
        if (upNow && !wasUp)
        {
            beepUp();
            currentUI = UI_PROGRAMADOR;
            menuIndex = 0;
        }

        if (backNow && !wasBack)
        {
            beepOK();
            currentUI = UI_HUMOR;
            menuIndex = 0;
        }

        if (selectNow && !wasSelect)
        {
            beepOK();
            currentUI = UI_INTERNET;
            menuIndex = 0;
        }
    }

    /*
    ============================================================
      UI_STATUS (Lista de atributos)
      - UP → navegar
      - SELECT → editar atributo
      - BACK → voltar ao HOME
    ============================================================
    */
    else if (currentUI == UI_PROGRAMADOR)
    {
        if (upNow && !wasUp)
        {
            beepMove();
            menuIndex = (menuIndex + 1) % totalStatus;
        }

        if (selectNow && !wasSelect)
        {
            beepOK();
            currentUI = UI_EDIT_VALUE;
        }

        if (backNow && !wasBack)
        {
            beepBack();
            currentUI = UI_HOME;
        }
    }

    /*
    ============================================================
      UI_EDIT_VALUE (Editar atributo)
      - UP → diminuir
      - SELECT → aumentar
      - BACK → voltar ao STATUS
    ============================================================
    */
    else if (currentUI == UI_EDIT_VALUE)
    {
        if (upNow && !wasUp)
        {
            beepIncrease();
            applyDecrease(menuIndex);
        }

        if (selectNow && !wasSelect)
        {
            beepDecrease();
            applyIncrease(menuIndex);
        }

        if (backNow && !wasBack)
        {
            beepOK();
            currentUI = UI_PROGRAMADOR;
        }
    }

    /*
    ============================================================
      UI_HUMOR (Ações do Dino)
      - UP → navegar
      - SELECT → executar ação
      - BACK → HOME
    ============================================================
    */
    else if (currentUI == UI_HUMOR)
    {
        if (upNow && !wasUp)
        {
            beepMove();
            menuIndex = (menuIndex + 1) % 4;
        }

        if (selectNow && !wasSelect)
        {
            beepOK();

            currentUI = UI_ACTIONS;
        }

        if (backNow && !wasBack)
        {
            beepBack();
            currentUI = UI_HOME;
        }
    }
    else if (currentUI == UI_ACTIONS)
    {
        if (upNow && !wasUp)
        {
            beepMove();
            menuIndex = (menuIndex + 1) % 4;
        }

        if (selectNow && !wasSelect)
        {
            beepOK();

            switch (menuIndex)
            {
            case 0:
                feed();
                break;
            case 1:
                cleanDino();
                break;
            case 2:
                play();
                break;
            case 3:
                train();
                break;
            }

            currentUI = UI_ACTIONS;
        }

        if (backNow && !wasBack)
        {
            beepBack();
            currentUI = UI_HOME;
        }
    }

    /*
    ============================================================
      UI_INTERNET (Menu Wi-Fi)
      - UP → navegar
      - SELECT → executar
      - BACK → HOME
    ============================================================
    */
    else if (currentUI == UI_INTERNET)
    {
        if (upNow && !wasUp)
        {
            beepMove();
            menuIndex = (menuIndex + 1) % 3;
        }

        if (selectNow && !wasSelect)
        {
            beepOK();

            if (menuIndex == 0)
                connectWiFi();
            if (menuIndex == 1)
                disconnectWiFi();
            if (menuIndex == 2)
                showWiFiStatus();

            currentUI = UI_WIFI_RESULT;
        }

        if (backNow && !wasBack)
        {
            beepBack();
            currentUI = UI_HOME;
        }
    }

    /*
    ============================================================
      UI_WIFI_RESULT
      - Mostra resultado (ligado / desligado / falha)
      - BACK → HOME
    ============================================================
    */
    else if (currentUI == UI_WIFI_RESULT)
    {
        if (backNow && !wasBack)
        {
            beepBack();
            currentUI = UI_HOME;
        }
    }

    // Atualizar estados anteriores (detecção de borda)
    wasUp = upNow;
    wasBack = backNow;
    wasSelect = selectNow;
}

/*
============================================================
  FUNÇÕES DE ALTERAÇÃO DE ATRIBUTOS
============================================================
*/
void Game::applyIncrease(int index)
{
    switch (index)
    {
    case 0:
        feed();
        break;
    case 1:
        cleanDino();
        break;
    case 2:
        play();
        break;
    case 3:
        train();
        break;
    case 4:
        humor += 5;
        break;
    case 5:
        saude += 5;
        break;
    }
}

void Game::applyDecrease(int index)
{
    switch (index)
    {
    case 0:
        fome -= 5;
        break;
    case 1:
        limpeza -= 5;
        break;
    case 2:
        felicidade -= 5;
        break;
    case 3:
        disciplina -= 5;
        break;
    case 4:
        humor -= 5;
        break;
    case 5:
        saude -= 5;
        break;
    }

    // Limites
    fome = constrain(fome, 0, 100);
    limpeza = constrain(limpeza, 0, 100);
    felicidade = constrain(felicidade, 0, 100);
    disciplina = constrain(disciplina, 0, 100);
}
