#include "Game.h"
#include <Arduino.h>

/*
============================================================
  formatLifeTime()
------------------------------------------------------------
  Converte um tempo em milissegundos para texto legível.

  Exemplo:
      172800000 ms → "2d 00h 00m 00s"

  - ms: tempo total em milissegundos
  - buffer: destino do texto formatado
  - len: tamanho máximo do buffer
============================================================
*/
void Game::formatLifeTime(unsigned long ms, char* buffer, size_t len) 
{
    unsigned long totalSeg = ms / 1000;

    unsigned long dias     = totalSeg / 86400;            // 1 dia = 86400s
    unsigned long horas    = (totalSeg % 86400) / 3600;   // resto do dia → horas
    unsigned long minutos  = (totalSeg % 3600) / 60;      // resto da hora → minutos
    unsigned long segundos = totalSeg % 60;               // resto do minuto

    snprintf(buffer, len, "%lud %02luh %02lum %02lus",
             dias, horas, minutos, segundos);
}

/*
============================================================
  splitLifeTime()
------------------------------------------------------------
  Divide um tempo em milissegundos nos seus componentes:

      dias, horas, minutos, segundos

  Útil quando queres mostrar cada parte separadamente
  ou fazer cálculos com elas.

  Exemplo:
      90061000 ms → d=1, h=1, m=1, s=1
============================================================
*/
void Game::splitLifeTime(unsigned long ms, int &d, int &h, int &m, int &s) 
{
    unsigned long total = ms / 1000;

    d = total / 86400;
    h = (total % 86400) / 3600;
    m = (total % 3600) / 60;
    s = total % 60;
}


int Game::getStart(int total)
{
    int s = menuIndex - 1;
    if (s < 0) s = 0;
    if (s > total - linhasVisiveis)
        s = total - linhasVisiveis;
    return s;
}
