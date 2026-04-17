package main.application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.application.model.Jogador;
import main.application.model.Labirinto;
import main.application.utils.Cena;

public class App extends Application {
    private Stage primaryStage;
    private Cena cenaAtual;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        // Inicializar o primeiro labirinto e o jogador
        Labirinto labirinto = new Labirinto(20, 20);
        Jogador jogador = new Jogador();

        // Inicializar a primeira cena
        cenaAtual = new Cena(labirinto, jogador);

        // Configurar a cena e os eventos
        Scene scene = new Scene(cenaAtual.getGrid(), 600, 600);
        cenaAtual.configurarEventos(scene);


        primaryStage.setTitle("Jogo de Labirinto");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}