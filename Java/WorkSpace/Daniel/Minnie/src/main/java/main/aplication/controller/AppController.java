package main.aplication.controller;

import javafx.animation.Animation;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;
import main.aplication.model.Cena;
import main.aplication.model.StoryManager;
import main.aplication.util.SpriteAnimation;

public class AppController {
    private StoryManager storyManager = new StoryManager();

    @FXML
    private VBox layout;
    @FXML
    private ImageView imagemView;
    @FXML
    private Text texto;
    @FXML
    private Button opcao1;
    @FXML
    private Button opcao2;

    // Método para configurar a cena inicial (chamado no start)
    public void criarCena() {
        Cena cena = storyManager.getCenaAtual();

        // Atualizar o texto
        texto.setText(cena.getTexto());

        // Atualizar a imagem (com ou sem animação)
        if (cena.getImagem().equals("/img/Minnie-sheetTransparente.png")) {
            // Usar a spritesheet da Minnie
            Image image = new Image(getClass().getResource(cena.getImagem()).toExternalForm());
            imagemView.setImage(image);
            imagemView.setViewport(new Rectangle2D(0, 0, 48, 48));  // Define o tamanho do quadro da animação
            imagemView.setFitWidth(96);  // Ajuste para o tamanho do sprite
            imagemView.setFitHeight(96); // Ajuste para o tamanho do sprite

            // Animar os quadros da imagem
            SpriteAnimation animation = new SpriteAnimation(
                    imagemView,
                    Duration.millis(5000),
                    11, // total de quadros
                    11, // colunas na spritesheet
                    0, 0,
                    44, 48
            );
            animation.setCycleCount(Animation.INDEFINITE); // Defina como INDEFINIDO para animação contínua
            animation.play();  // Inicia a animação
        } else {
            // Caso a imagem não seja uma spritesheet, exibir imagem normal
            Image img = new Image(getClass().getResource(cena.getImagem()).toExternalForm());
            imagemView.setImage(img);
            imagemView.setFitWidth(400);
            imagemView.setFitHeight(300);
        }

        // Atualizar texto das opções e adicionar ações
        opcao1.setText(cena.getOpcao1Texto());
        opcao1.setOnAction(e -> {
            storyManager.avancarParaCena(cena.getOpcao1Destino());
            construirCena(); // Recarregar cena após a escolha
        });

        opcao2.setText(cena.getOpcao2Texto());
        opcao2.setOnAction(e -> {
            storyManager.avancarParaCena(cena.getOpcao2Destino());
            construirCena(); // Recarregar cena após a escolha
        });
    }

    // Método para recarregar e atualizar os elementos da cena
    public void construirCena() {
        Cena cena = storyManager.getCenaAtual();

        // Atualizar texto
        texto.setText(cena.getTexto());

        // Atualizar imagem (com ou sem animação)
        if (cena.getImagem().equals("/img/Minnie-sheetTransparente.png")) {
            // Usar spritesheet da Minnie
            Image image = new Image(getClass().getResource(cena.getImagem()).toExternalForm());
            imagemView.setImage(image);
            imagemView.setViewport(new Rectangle2D(0, 0, 48, 48));  // Define o tamanho do quadro da animação
            imagemView.setFitWidth(96);  // Ajuste para o tamanho do sprite
            imagemView.setFitHeight(96); // Ajuste para o tamanho do sprite

            // Animar os quadros da imagem
            SpriteAnimation animation = new SpriteAnimation(
                    imagemView,
                    Duration.millis(5000),
                    11, // total de quadros
                    11, // colunas na spritesheet
                    0, 0,
                    44, 48
            );
            animation.setCycleCount(Animation.INDEFINITE); // Defina como INDEFINIDO para animação contínua
            animation.play();  // Inicia a animação

        } else {
            // Caso a imagem não seja uma spritesheet, exibir imagem normal
            Image img = new Image(getClass().getResource(cena.getImagem()).toExternalForm());
            imagemView.setImage(img);
            imagemView.setFitWidth(400);
            imagemView.setFitHeight(300);
        }

        // Atualizar as opções e as ações
        opcao1.setText(cena.getOpcao1Texto());
        opcao1.setOnAction(e -> {
            storyManager.avancarParaCena(cena.getOpcao1Destino());
            construirCena(); // Recarregar cena após a escolha
        });

        opcao2.setText(cena.getOpcao2Texto());
        opcao2.setOnAction(e -> {
            storyManager.avancarParaCena(cena.getOpcao2Destino());
            construirCena(); // Recarregar cena após a escolha
        });
    }
}
