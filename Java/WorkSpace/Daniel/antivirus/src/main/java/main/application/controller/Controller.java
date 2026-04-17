package main.application.controller;


import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import main.application.anti.MalwareBazaarAPI;
import main.application.phishing.OpenPhish;
import main.application.utils.HashUtil;

import java.io.File;
import java.util.List;


public class Controller {
    @FXML
    private TextField urlTextField;
    @FXML
    private TextArea consoleTextArea;  // A TextArea onde a saída será mostrada

    @FXML
    public void escolherDiretorioEAnalisar(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Seleciona o diretório para analisar");
        File diretorioSelecionado = directoryChooser.showDialog(null);

        if (diretorioSelecionado != null) {
            consoleTextArea.appendText("📂 Diretório selecionado: " + diretorioSelecionado.getAbsolutePath() + "\n");

            // Obtém a lista de hashes maliciosos
            List<String> maliciosasHash = MalwareBazaarAPI.obterHashMaliciosos();

            // Criação da tarefa para execução em thread separada
            Task<Void> task = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    verificarFicheirosRecursivamente(diretorioSelecionado, maliciosasHash);
                    return null;
                }
            };

            // Atualiza a interface quando a tarefa for concluída
            task.setOnSucceeded(e -> consoleTextArea.appendText("✅ Análise Completa!\n"));

            // Executa a tarefa
            new Thread(task).start();
        } else {
            consoleTextArea.appendText("❌ Nenhum diretório selecionado.\n");
        }
    }


    // Método para realizar a verificação de arquivos
    public void verificarFicheirosRecursivamente(File file, List<String> maliciosasHash) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    verificarFicheirosRecursivamente(f, maliciosasHash);
                }
            }
        } else {
            String hash = HashUtil.calcularHash(file);

            // Atualiza a TextArea em tempo real
            Platform.runLater(() -> {
                consoleTextArea.appendText("Verificando: " + file.getAbsolutePath() + "\n");
            });

            // Chama a API do MalwareBazaar
            boolean malicioso = MalwareBazaarAPI.consultarHash(hash);

            if (malicioso) {
                Platform.runLater(() -> {
                    consoleTextArea.appendText("💀 Ficheiro malicioso DETECTADO: " + file.getAbsolutePath() + "\n");
                });
            } else {
                Platform.runLater(() -> {
                    consoleTextArea.appendText("✅ Ficheiro seguro: " + file.getAbsolutePath() + "\n");
                });
            }
        }
    }



    // Método para buscar base de dados a partir do URL inserido
    public void buscarBaseDeDados(ActionEvent event) {
        String url = urlTextField.getText().trim();

        if (url.isEmpty()) {
            showAlertError("Erro", "Por favor, insira um URL válido!");
            return;
        }

        // Verificar se o URL está na lista de phishing
        boolean phishingEncontrado = OpenPhish.pesquisarUrl(url);

        // Exibir alertas com base no resultado da pesquisa
        if (phishingEncontrado) {
            showAlertError("💀 Alerta de Phishing", "O URL inserido é um phishing!");
        } else {
            showAlert("💀 Segurança", "O URL inserido não é um phishing.");
        }

    }

    // Método para mostrar um alerta
    public static void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    // Método para mostrar um alerta
    public static void showAlertError(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

