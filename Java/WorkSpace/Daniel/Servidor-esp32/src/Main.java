import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import network.MainServer;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        // Carregar o FXML (quando o tiveres)
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/dashboard.fxml"));
        Scene scene = new Scene(loader.load());

        stage.setTitle("Painel ESP32");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        // Iniciar servidor numa thread separada
        new Thread(() -> {
            try {
                MainServer.iniciarServidor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        // Iniciar JavaFX
        launch();
    }
}
