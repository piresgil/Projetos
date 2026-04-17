package main.application.utils;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import lombok.Getter;
import main.application.controller.LabirintoController;
import main.application.model.Jogador;
import main.application.model.Labirinto;

public class Cena {
    private Labirinto labirinto;
    private Jogador jogador;
    @Getter
    private GridPane grid;

    private LabirintoController controller;

    public Cena(Labirinto labirinto, Jogador jogador) {
        this.labirinto = labirinto;
        this.jogador = jogador;
        this.grid = new GridPane();
        this.controller = new LabirintoController(labirinto, jogador); // Criar o controller aqui
        this.controller.setGrid(grid);
        desenharLabirinto(grid); // Desenha o labirinto usando o Controller
    }

    private void desenharLabirinto(GridPane grid) {
        controller.desenharLabirinto(grid);
    }

    // Método para configurar os eventos de teclas
    public void configurarEventos(Scene cena) {
        // Configurar o KeyListener e desenhar o labirinto
        controller.desenharLabirinto(grid); // Desenha o labirinto inicialmente
        controller.configurarControloTeclado(cena); // Configura o listener de teclas

    }

}
