package main.aplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.aplication.controller.AppController;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Carregar o FXML e associar o controlador
        FXMLLoader loader = new FXMLLoader(getClass().getResource("app.fxml"));
        // Carregar o FXML e obter o controlador
        Scene cenaInicial = new Scene(loader.load());

        // Obter o controlador após carregar o FXML
        AppController controller = loader.getController();

        // Chamar o método para construir a cena (configurar elementos)
        controller.criarCena(); // Isso configura os dados e UI

        // Configurar a janela
        stage.setTitle("Aventura da Minnie");
        stage.setScene(cenaInicial);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}