package main.application.model;

import javafx.animation.Timeline;
import lombok.Data;

@Data
public class Jogador {
    private int x, y;
    private final int largura = 24;
    private final int altura = 32;

    private String direcaoJogador = "baixo"; // Direção inicial

    private Timeline animacao;

    public Jogador() {
        this.x = 0; // Posição inicial
        this.y = 0; // Posição inicial
    }

    public Jogador(int x, int y) {
        this.x = x;
        this.y = y;

    }

}
