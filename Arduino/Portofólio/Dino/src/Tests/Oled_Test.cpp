#include "../Game/Game.h"

/*
============================================================
  TESTE DO OLED 
------------------------------------------------------------
  - Usa o display REAL da classe Game
  - Não precisa de extern
  - Não cria outro display
============================================================
*/
void Game::oledTest()
{
    // Inicializa I2C e OLED apenas para o teste
    Wire.begin(21, 22);

    if (!display.begin(SSD1306_SWITCHCAPVCC, 0x3C)) {
        Serial.println("ERRO: OLED nao encontrado!");
        return;
    }

    display.clearDisplay();
    display.setTextSize(2);
    display.setTextColor(SSD1306_WHITE);
    display.setCursor(0, 0);
    display.println("OLED OK!");
    display.display();
}


