#include "Game.h"
#include <Wire.h>

Game::Game()
    : display(128, 64, &Wire, -1)
{
  // -----------------------------
  // Atributos iniciais do Dino
  // -----------------------------
  fome = 80;
  limpeza = 60;
  felicidade = 90;
  disciplina = 40;
  humor = 50;
  saude = 80;

  // -----------------------------
  // Tempo de vida
  // -----------------------------
  lifeStart = 0;
  lastLife = 0;

  // -----------------------------
  // evolução
  // -----------------------------
  evolution = 0;
  
  // -----------------------------
  // Input
  // -----------------------------
  wasUp = wasBack = wasSelect = false;
  inputLock = 0;

  // -----------------------------
  // Menu
  // -----------------------------
  menuIndex = 0;

  statusVars[0] = &fome;
  statusVars[1] = &limpeza;
  statusVars[2] = &felicidade;
  statusVars[3] = &disciplina;
  statusVars[4] = &humor;
  statusVars[5] = &saude;

  statusNames[0] = "Fome";
  statusNames[1] = "Clean";
  statusNames[2] = "Feliz";
  statusNames[3] = "Disc";
  statusNames[4] = "humor";
  statusNames[5] = "Saude";

  // -----------------------------
  // Estado inicial da UI
  // -----------------------------
  currentUI = UI_LOADING;

  // -----------------------------
  // Wi-Fi
  // -----------------------------
  wifiConnected = false;
  ssid = "MEO-4F9B70";
  password = "1c3ee143d8";

  // -----------------------------
  // Scores
  // -----------------------------
  topScores[0] = topScores[1] = topScores[2] = 0;
}

void Game::begin()
{
  // ------------------------------------------------------------
  // Botões
  // ------------------------------------------------------------
  pinMode(25, INPUT_PULLUP);
  pinMode(27, INPUT_PULLUP);
  pinMode(14, INPUT_PULLUP);

  wasUp = wasSelect = wasBack = false;
  inputLock = 0;

  // ------------------------------------------------------------
  // Buzzer
  // ------------------------------------------------------------
  pinMode(BUZZER_PIN, OUTPUT);
  digitalWrite(BUZZER_PIN, LOW);

  // ------------------------------------------------------------
  // OLED
  // ------------------------------------------------------------
  Wire.begin(21, 22);

  if (!display.begin(SSD1306_SWITCHCAPVCC, 0x3C))
  {
    Serial.println("ERRO: OLED não encontrado!");
    while (true)
      delay(100);
  }

  melodyStart();
  uiRender();
  delay(2000);
  // ------------------------------------------------------------
  // Variáveis do jogo
  // ------------------------------------------------------------
  fome = 50;
  limpeza = 50;
  felicidade = 50;
  disciplina = 50;
  humor = 50;
  saude = 50;

  lifeStart = millis();
  lastLife = millis();

  statusVars[0] = &fome;
  statusVars[1] = &limpeza;
  statusVars[2] = &felicidade;
  statusVars[3] = &disciplina;
  statusVars[4] = &humor;
  statusVars[5] = &saude;

  statusNames[0] = "Fome";
  statusNames[1] = "Clean";
  statusNames[2] = "Feliz";
  statusNames[3] = "Disc";
  statusNames[4] = "humor";
  statusNames[5] = "Saude";

  menuIndex = 0;

  // ------------------------------------------------------------
  // Save
  // ------------------------------------------------------------
  prefs.begin("dino", false);
  loadGame();

  // ------------------------------------------------------------
  // UI inicial
  // ------------------------------------------------------------
  currentUI = UI_HOME;
}

void Game::update()
{
  updateStats();
  handleNavigation();
  uiRender();
}
