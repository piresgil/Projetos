#pragma once
#include <Arduino.h>
#include <Wire.h>
#include <Adafruit_SSD1306.h>
#include <Preferences.h>
#include <WiFi.h>

/*
============================================================
  ESTADOS DA INTERFACE (UI)
============================================================
*/
enum UIState
{
  UI_LOADING,
  UI_HOME,
  UI_EDIT_VALUE,
  UI_HUMOR,
  UI_ACTIONS, // Menu de ações do Dino
  UI_INTERNET,
  UI_WIFI_RESULT, // Menu de WiFi
  UI_PROGRAMADOR,
  UI_GAME_OVER,
  UI_CONFIRM_RESTART,
  UI_STARTUP_PROMPT
};

/*
============================================================
  CLASSE PRINCIPAL DO JOGO
============================================================
*/
class Game
{
public:
  Game();
  void begin();
  void update();
  void oledTest();
  static const int linhasVisiveis = 4;
  int getStart(int total);
  
void drawMenuList(
    const char* items[],
    int values[],
    int total,
    int startY,
    bool showBars = true
);

private:
  /*
  ============================================================
    ESTADO DO JOGO
  ============================================================
  */
  UIState currentUI;

  int fome;
  int limpeza;
  int felicidade;
  int disciplina;
  int humor;
  int saude;

  // -----------------------------
  // evolução
  // -----------------------------
  float evolution = 0;
  int evolutionStage = 0;

  unsigned long lifeStart;
  unsigned long lastLife;
  unsigned long topScores[3];

  /*
  ============================================================
    INPUT (BOTÕES)
    - wasUp / wasBack / wasSelect → detecção de borda
    - inputLock → anti-spam
  ============================================================
  */
  bool wasUp;
  bool wasBack;
  bool wasSelect = false;
  unsigned long inputLock;

  /*
  ============================================================
    MENUS E STATUS
  ============================================================
  */
  int menuIndex;
  int *statusVars[6];
  const char *statusNames[6];
  static constexpr int totalStatus = 6;

  /*
  ============================================================
    WiFi
  ============================================================
  */
  String wifiMessage;
  bool wifiConnected;
  const char *ssid;
  const char *password;

  void connectWiFi();
  void disconnectWiFi();
  void showWiFiStatus();

  /*
  ============================================================
    SISTEMA DE GUARDAR / CARREGAR
  ============================================================
  */
  Preferences prefs;

  void saveGame();
  void loadGame();
  void clearSave();

  /*
  ============================================================
    FUNÇÕES DE TEMPO DE VIDA
  ============================================================
  */
  void formatLifeTime(unsigned long ms, char *buffer, size_t len);
  void splitLifeTime(unsigned long ms, int &d, int &h, int &m, int &s);

  /*
  ============================================================
    INPUT E NAVEGAÇÃO
  ============================================================
  */
  bool pressed(int pin);
  void handleNavigation();

  /*
  ============================================================
    BUZZER E SONS
  ============================================================
  */
  static const int BUZZER_PIN = 26;

  void beepUp();
  void beepMove();
  void beepOK();
  void beepBack();
  void beepIncrease();
  void beepDecrease();
  void beepAlert();

  void melodyStart();
  void melodyDeath();
  void melodyExit();

  /*
  ============================================================
    LÓGICA DO JOGO
  ============================================================
  */
  void updateStats();
  void saveScore(unsigned long score);

  // Ações do jogador
  void feed();
  void cleanDino();
  void play();
  void train();

  // Ajuste manual (UI_EDIT_VALUE)
  void applyIncrease(int index);
  void applyDecrease(int index);

  void applyHumorEffects();
  void updateEvolution();
  int getHumor();
  int getHumorState();

  void resetDino();
  void resetGame();

  /*
  ============================================================
    DESENHO DE TELAS (UI)
  ============================================================
  */

  void drawLoadScreen();
  void drawBar(int x, int y, int value);
  void drawHomeScreen();
  void drawValuesScreen(int index);
  // void drawStartQuestion();
  void updateWiFiState();

  void drawWiFiPulseAnimation(int frame);
  void drawWiFiResult(bool wifiConnected);
  void drawHumorScreen();
  void drawInternetMenu();
  void drawActionsMenu();
  void drawModoProgramador();
  void drawActionAnimation(String message, int frames);
  void drawGameOver();
  void uiRender();

  /*
  ============================================================
    DISPLAY OLED
  ============================================================
  */
  Adafruit_SSD1306 display;
};
