#include "Game.h"
#include <WiFi.h>
#include <Arduino.h>

/*
============================================================
  ATUALIZA ESTADO DO Wi‑Fi
------------------------------------------------------------
  - Mantém wifiConnected sincronizado com o hardware
============================================================
*/
void Game::updateWiFiState()
{
  wifiConnected = (WiFi.status() == WL_CONNECTED);
}

/*
============================================================
  LIGAR AO Wi‑Fi
------------------------------------------------------------
  - Evita ligar duas vezes
  - Mostra animação enquanto tenta ligar
  - No fim mostra se conectou ou não
============================================================
*/
void Game::connectWiFi()
{
  updateWiFiState();

  if (wifiConnected)
  {
    wifiMessage = "Ja ligado!";
    return;
  }

  WiFi.mode(WIFI_STA);
  WiFi.begin(ssid, password);

  for (int i = 0; i < 10 && WiFi.status() != WL_CONNECTED; i++)
  {
    drawWiFiPulseAnimation(i);
    delay(500);
  }

  updateWiFiState();

  if (wifiConnected)
  {
    wifiMessage = "Ligado com sucesso!";
    drawWiFiResult(wifiConnected);

    delay(800);
  }
  else
  {
    wifiMessage = "Falha na ligacao!";
    drawWiFiResult(wifiConnected);

  }
}

/*
============================================================
  DESLIGAR Wi‑Fi
------------------------------------------------------------
  - Força desligar
  - Desliga rádio
  - Atualiza estado
============================================================
*/
void Game::disconnectWiFi()
{
  updateWiFiState();

  if (!wifiConnected)
  {
    wifiMessage = "Ja desligado!";
    return;
  }

  Serial.println("WiFi: a desligar...");

  for (int i = 0; i < 10 && WiFi.status() != WL_CONNECTED; i++)
  {
    drawWiFiPulseAnimation(i);
    delay(500);
  }

  WiFi.disconnect(true, true); // força desconexão e limpa credenciais
  delay(100);

  WiFi.mode(WIFI_OFF); // desliga rádio
  delay(100);

  WiFi.setSleep(true); // garante desligamento

  updateWiFiState(); // sincroniza estado
   if (wifiConnected)
  {
    wifiMessage = "Desligado com sucesso!";
    drawWiFiResult(wifiConnected);

    delay(800);
  }
  else
  {
    wifiMessage = "Falha na ligacao!";
    drawWiFiResult(wifiConnected);

  }
}

/*
============================================================
  ESTADO DO Wi‑Fi
------------------------------------------------------------
  - Mostra SSID se ligado
  - Mostra "desligado" se não estiver
============================================================
*/
void Game::showWiFiStatus()
{
  updateWiFiState();

  if (wifiConnected)
  {
    wifiMessage = "Ligado a: ";
    wifiMessage += WiFi.SSID();
  }
  else
  {
    wifiMessage = "WiFi desligado.";
  }
}
