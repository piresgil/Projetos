package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import network.ApiClient;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DashboardController {

    @FXML
    private Button btnLigar;
    @FXML
    private Button btnDesligar;

    @FXML
    private Label lblEstado;   // Estado da bomba
    @FXML
    private TextArea txtJson;  // Log completo

    // Labels separadas para sensores
    @FXML
    private Label lblTemp;
    @FXML
    private Label lblHum;
    @FXML
    private Label lblSolo;
    @FXML
    private Label lbDistancia;

    private final String serverUrl = "http://192.168.1.11:8080";

    private final ScheduledExecutorService scheduler =
            Executors.newSingleThreadScheduledExecutor();

    private String ultimoJsonMostrado = "";

    @FXML
    public void initialize() {
        scheduler.scheduleAtFixedRate(this::atualizarUI, 0, 1, TimeUnit.SECONDS);
    }

    // BOTÃO: Ligar bomba
    @FXML
    private void ligarBomba() {
        ApiClient.post(serverUrl + "/relay", "{\"bomba\": true}");
        atualizarUI();
    }

    // BOTÃO: Desligar bomba
    @FXML
    private void desligarBomba() {
        ApiClient.post(serverUrl + "/relay", "{\"bomba\": false}");
        atualizarUI();
    }

    // ============================================================
    //  Atualiza UI: estado da bomba + sensores + log
    // ============================================================
    private void atualizarUI() {

        // 1. Estado da bomba
        new Thread(() -> {
            String jsonRelay = ApiClient.get(serverUrl + "/relay");

            Platform.runLater(() -> {
                lblEstado.setText(
                        jsonRelay.contains("true")
                                ? "Bomba: LIGADA"
                                : "Bomba: DESLIGADA"
                );
            });
        }).start();

        // 2. Sensores do ESP32
        new Thread(() -> {
            String jsonEsp = ApiClient.get(serverUrl + "/esp32/last");

            Platform.runLater(() -> {

                // LOG: só adiciona se for novo
                if (!jsonEsp.isBlank()
                        && !jsonEsp.equals("{Start LOG}")
                        && !jsonEsp.equals(ultimoJsonMostrado)) {
                    txtJson.appendText(jsonEsp + "\n");
                    ultimoJsonMostrado = jsonEsp;
                    guardarLog(jsonEsp);
                }

                // Extrair valores
                String temp = extrairValor(jsonEsp, "temp");
                String hum = extrairValor(jsonEsp, "hum");
                String solo = extrairValor(jsonEsp, "solo");
                String dist = extrairValor(jsonEsp, "dist");

                // Atualizar labels
                lblTemp.setText("Temp: " + temp + " ºC");
                lblHum.setText("Hum Ar: " + hum + " %");
                lblSolo.setText("Hum Solo: " + solo);
                lbDistancia.setText("Distância: " + dist);
            });

        }).start();
    }

    // ============================================================
    //  Extrair valores do JSON (sem bibliotecas externas)
    // ============================================================
    private String extrairValor(String json, String chave) {
        try {
            int i = json.indexOf(chave);
            if (i == -1) return "---";

            int start = json.indexOf(":", i) + 1;
            int end = json.indexOf(",", start);

            if (end == -1) end = json.indexOf("}", start);

            return json.substring(start, end).replace("\"", "").trim();

        } catch (Exception e) {
            return "---";
        }
    }

    // ============================================================
    //  Guardar log num ficheiro (para futura base de dados)
    // ============================================================
    private static void guardarLog(String json) {
        try {
            // Criar pasta logs se não existir
            java.nio.file.Path pasta = java.nio.file.Path.of("logs");
            java.nio.file.Files.createDirectories(pasta);

            // Caminho do ficheiro
            java.nio.file.Path ficheiro = pasta.resolve("esp32_log.txt");

            // Escrever linha no ficheiro
            java.nio.file.Files.writeString(
                    ficheiro,
                    json + System.lineSeparator(),
                    java.nio.file.StandardOpenOption.CREATE,
                    java.nio.file.StandardOpenOption.APPEND
            );

        } catch (Exception e) {
            System.out.println("Erro ao guardar log: " + e.getMessage());
        }
    }
}
