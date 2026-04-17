#include "Game.h"

/*
============================================================
ECRÃ DE LOADING
============================================================
*/
void Game::drawLoadScreen()
{
  display.clearDisplay();
  display.setTextColor(SSD1306_WHITE);

  display.setTextSize(2);
  display.setCursor(5, 0);
  display.print("Dino");

  display.setTextSize(1);
  display.setCursor(70, 5);
  display.print("Welcome");

  display.setTextSize(2);
  display.setCursor(10, 40);
  display.print("Loading...");

  display.display();
}

/*
============================================================
  BARRA DE STATUS (GENÉRICA)
============================================================
*/
void Game::drawBar(int x, int y, int value)
{
  int width = 40;
  int filled = (value * width) / 100;

  display.drawRect(x, y, width, 6, WHITE);
  display.fillRect(x + 1, y + 1, filled - 2, 4, WHITE);
}

void Game::drawMenuList(
    const char *items[],
    int values[],
    int total,
    int startY,
    bool showBars)
{
  int start = getStart(total);

  for (int i = 0; i < linhasVisiveis; i++)
  {
    int idx = start + i;
    int y = startY + i * 11;

    // Cursor
    display.setCursor(0, y);
    display.print(idx == menuIndex ? ">" : " ");

    // Nome do item
    display.setCursor(10, y);
    display.print(items[idx]);

    // Se showBars == true → desenha barras e valores
    if (showBars)
    {
      drawBar(55, y - 1, values[idx]);

      display.setCursor(115, y);
      display.print(values[idx]);
    }
  }
}

/*
============================================================
  ECRÃ PRINCIPAL (HOME)
============================================================
*/
void Game::drawHomeScreen()
{
  display.clearDisplay();
  display.setTextColor(SSD1306_WHITE);

  // Título
  display.setTextSize(2);
  display.setCursor(0, 0);
  display.print("Dino");

  // Barra de vida global
  display.setTextSize(1);
  display.setCursor(98, 0);
  display.print("Life:");
  drawBar(88, 10, *statusVars[4]);

  // Tempo de vida
  int d, h, m, s;
  splitLifeTime(millis() - lifeStart, d, h, m, s);

  // Dias
  display.setTextSize(2);
  display.setCursor(0, 20);
  display.printf("%d", d);

  display.setCursor(10, 25);
  display.setTextSize(1);
  display.print(" Days");

  // Horas + Minutos
  display.setTextSize(2);
  display.setCursor(20, 40);
  display.printf("%02dh %02dm", h, m);

  // Segundos
  display.setTextSize(1);
  display.setCursor(105, 56);
  display.printf("%02ds", s);

  display.display();
}

/*
============================================================
  MODO PROGRAMADOR (LISTA DE STATUS)
============================================================
*/
void Game::drawModoProgramador()
{
  display.clearDisplay();
  display.setTextColor(SSD1306_WHITE);

  // Título
  display.setTextSize(2);
  display.setCursor(0, 0);
  display.print("Status");

  // Vida
  display.setTextSize(1);
  display.setCursor(100, 0);
  display.print(*statusVars[4]);
  display.print("hp");
  drawBar(88, 10, *statusVars[4]);

  // Criar arrays temporários para o menu
  const char *items[totalStatus];
  int valores[totalStatus];

  for (int i = 0; i < totalStatus; i++)
  {
    items[i] = statusNames[i];
    valores[i] = *statusVars[i];
  }

  // Desenhar lista
  drawMenuList(items, valores, totalStatus, 20);

  display.display();
}

/*
============================================================
  ECRÃ DE EDIÇÃO DE VALORES
============================================================
*/
void Game::drawValuesScreen(int index)
{
  display.clearDisplay();
  display.setTextColor(SSD1306_WHITE);

  display.setTextSize(2);
  display.setCursor(5, 0);
  display.print(statusNames[index]);

  display.setCursor(80, 40);
  display.print(*statusVars[index]);

  display.display();
}

/*
============================================================
  ECRÃ DE HUMOR
============================================================
*/
void Game::drawHumorScreen()
{
  int humor = getHumor();
  int hs = getHumorState();

  display.clearDisplay();

  // Título
  display.setTextSize(2);
  display.setCursor(0, 0);
  display.print("Humor");

  // Barra de vida
  drawBar(88, 10, *statusVars[4]);

  display.setCursor(92, 0);
  display.setTextSize(1);
  display.print(humor);
  display.print("%");

  // Estado emocional
  display.setTextSize(2);
  display.setCursor(0, 20);

  switch (hs)
  {
  case 4:
    display.print("Feliz");
    break;
  case 3:
    display.print("Normal");
    break;
  case 2:
    display.print("Aborrecido");
    break;
  case 1:
    display.print("Triste");
    break;
  case 0:
    display.print("Furioso");
    break;
  }

  display.display();
}

/*
============================================================
  MENU DE AÇÕES
============================================================
*/
void Game::drawActionsMenu()
{
  display.clearDisplay();
  display.setTextColor(SSD1306_WHITE);

  const char *items[4] = {"Comer", "Limpar", "Brincar", "Treinar"};
  int valores[4] = {fome, limpeza, felicidade, disciplina};

  display.setTextSize(2);
  display.setCursor(0, 0);
  display.print("Acoes");

  display.setTextSize(1);

  drawMenuList(items, valores, 4, 20, false);

  display.display();
}

/*
============================================================
  MENU DE INTERNET
============================================================
*/
void Game::drawInternetMenu()
{
  display.clearDisplay();
  display.setTextColor(SSD1306_WHITE);

  // Título
  display.setTextSize(2);
  display.setCursor(0, 0);
  display.print("WiFi");

  // Itens do menu WiFi
  display.setTextSize(1);
  const char *items[4] = {
      "Ligar",
      "Desligar",
      "Estado",
      "Modo Programador"};

  // Criar arrays temporários para o menu

  int valores[totalStatus];
  for (int i = 0; i < totalStatus; i++)
  {
    // Desenhar lista simples sem barras
    drawMenuList(items, valores, 5, 20, false);
  }

  display.display();
}

/*
============================================================
  ANIMAÇÃO DE PULSO Wi-Fi
============================================================
*/
void Game::drawWiFiPulseAnimation(int frame)
{
  display.clearDisplay();

  int x = 64;
  int y = 32;

  display.fillCircle(x, y, 2, WHITE);

  int r = 4 + (frame % 4) * 3;

  display.drawCircle(x, y, r, WHITE);
  display.drawCircle(x, y, r + 4, WHITE);

  display.display();
}

/*
============================================================
  RESULTADO DO Wi-Fi
============================================================
*/
void Game::drawWiFiResult(bool wifiConnected)
{
  display.clearDisplay();
  display.setTextSize(2);
  display.setCursor(0, 0);
  display.print("WiFi");

  display.setTextSize(1);
  display.setCursor(0, 20);

  display.print("Estado: ");
  display.print(wifiConnected ? "Conectado" : "Desconectado");

  display.display();
}

/*
============================================================
  ANIMAÇÃO DE AÇÃO
============================================================
*/
void Game::drawActionAnimation(String message, int frames)
{
  for (int i = 0; i < frames; i++)
  {
    display.clearDisplay();

    display.setTextSize(2);
    display.setCursor(0, 0);
    display.print(message);

    int r = 4 + (i % 4) * 3;
    display.fillCircle(64, 40, r, WHITE);

    display.display();

    tone(BUZZER_PIN, 400 + i * 30, 80);
    delay(150);
  }
}

/*
============================================================
  GAME OVER
============================================================
*/
void Game::drawGameOver()
{
  display.clearDisplay();
  display.setTextColor(SSD1306_WHITE);

  display.setCursor(0, 0);
  display.setTextSize(2);
  display.print("GAME OVER");

  display.display();
}

/*
============================================================
  RENDERIZAÇÃO PRINCIPAL DA UI
============================================================
*/
void Game::uiRender()
{
  switch (currentUI)
  {
  case UI_LOADING:
    drawLoadScreen();
    break;
  case UI_HOME:
    drawHomeScreen();
    break;
  case UI_PROGRAMADOR:
    drawModoProgramador();
    break;
  case UI_EDIT_VALUE:
    drawValuesScreen(menuIndex);
    break;
  case UI_HUMOR:
    drawHumorScreen();
    break;
  case UI_ACTIONS:
    drawActionsMenu();
    break;
  case UI_INTERNET:
    drawInternetMenu();
    break;
  case UI_WIFI_RESULT:
    drawWiFiResult(wifiConnected);
    break;
  case UI_GAME_OVER:
    drawGameOver();
    break;

  // Estados ainda não usados → evitar warnings
  case UI_CONFIRM_RESTART:
    break;
  case UI_STARTUP_PROMPT:
    break;
  }
}