package main.application.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import main.application.model.Bot;
import main.application.model.Jogador;
import main.application.model.Labirinto;

import java.util.*;

public class LabirintoController {
    private Labirinto labirinto;
    private Jogador jogador;
    private Bot bot;

    private GridPane grid;

    private Rectangle retanguloBot; // Representação visual do bot
    private Timeline movimentoBotTimeline;

    private int jogadorScore = 0;
    private int botScore = 0;
    private Label scoreLabel;

    private final Image spriteSheet = new Image(getClass().getResourceAsStream("/img/img.png"));

    private final int blocoSize = 64;         // Tamanho original dos blocos
    private final int escala = 30;            // Tamanho final de exibição (visualmente igual para tudo)

    private int frameAtual = 0;
    private final int totalFrames = 8; // Supondo que cada direção tem 3 colunas

    private Timeline animacaoJogador;
    private GridPane gridGlobal;

    private final Set<KeyCode> teclasPressionadas = new HashSet<>();
    private Timeline movimentoContinuoJogador;

    public LabirintoController(Labirinto labirinto, Jogador jogador) {
        this.labirinto = labirinto;
        this.jogador = jogador;
        this.bot = new Bot(); // Inicializa o bot

        animacaoJogador = new Timeline(new KeyFrame(Duration.millis(150), e -> {
            if (gridGlobal != null) {
                frameAtual = (frameAtual + 1) % totalFrames;
                desenharLabirinto(gridGlobal);
            }
        }));
    }

    public void setGrid(GridPane grid) {
        this.grid = grid;
        inicializarBot(); // Inicializa a visualização do bot após ter o grid
        iniciarMovimentoBot();
    }

    private Queue<int[]> filaBFS = new LinkedList<>();
    private List<int[]> caminhoBot = new ArrayList<>();
    private boolean[][] visitado;
    private int[] saidaPosicao;

    private void inicializarBot() {
        Random random = new Random();
        int botX, botY;
        do {
            botX = random.nextInt(labirinto.getAltura());
            botY = random.nextInt(labirinto.getLargura());
        } while (!labirinto.ehMovimentoValido(botX, botY));

        bot.setX(botX);
        bot.setY(botY);
        retanguloBot = new Rectangle(escala, escala);
        retanguloBot.setFill(Color.BLUE);
        grid.add(retanguloBot, bot.getY(), bot.getX());

        try {
            filaBFS.offer(new int[]{bot.getX(), bot.getY()});
            visitado = new boolean[labirinto.getAltura()][labirinto.getLargura()];
            visitado[bot.getX()][bot.getY()] = true;

            // Verificar se a saída é acessível
            saidaPosicao = encontrarSaida();
            if (saidaPosicao == null) {
                throw new IllegalStateException("Não foi possível encontrar a saída.");
            }

            // Executar BFS em uma thread separada
            new Thread(() -> realizarBuscaBFS()).start();
        } catch (Exception e) {
            System.err.println("Erro na inicialização do Bot: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void realizarBuscaBFS() {
        while (!filaBFS.isEmpty()) {
            int[] posicaoAtual = filaBFS.poll();
            int x = posicaoAtual[0];
            int y = posicaoAtual[1];

            int[][] direcoes = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
            for (int[] d : direcoes) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx >= 0 && ny >= 0 && nx < labirinto.getAltura() && ny < labirinto.getLargura() &&
                        !visitado[nx][ny] && labirinto.ehMovimentoValido(nx, ny)) {
                    filaBFS.offer(new int[]{nx, ny});
                    visitado[nx][ny] = true;
                    // Pode ser necessário guardar o "pai" para reconstruir o caminho
                }
            }

            // Pequeno delay para visualização (opcional)
            //  try {
            //      Thread.sleep(50);
            //  } catch (InterruptedException e) {
            //      Thread.currentThread().interrupt();
            //  }
        }
        // Após a busca, calcular o caminho para a saída
        Platform.runLater(this::calcularCaminhoBot);
    }

    private void moverBotPara(int novoX, int novoY) {
        bot.setX(novoX);
        bot.setY(novoY);

        //System.out.println("Novo bot: " + novoX + "," + novoY);
        Platform.runLater(this::atualizarBotGrid);
    }

    private void atualizarBotGrid() {
        if (grid != null && grid.getChildren().contains(retanguloBot)) {
            GridPane.setConstraints(retanguloBot, bot.getY(), bot.getX());
        } else if (grid != null) {
            grid.add(retanguloBot, bot.getY(), bot.getX());
        }
    }

    private void iniciarMovimentoBot() {
        // Aumente o valor do intervalo para tornar o bot mais lento.
        // Experimente com valores como 1000 (1 segundo), 1500 (1.5 segundos) ou mais.
        double intervalo = 1000; // Move a cada 1 segundo (exemplo)
        movimentoBotTimeline = new Timeline(new KeyFrame(Duration.millis(intervalo), e -> {
            if (!caminhoBot.isEmpty()) {
                int[] proximoPasso = caminhoBot.remove(0);
                // System.out.println("Movendo para: " + proximoPasso[0] + ", " + proximoPasso[1]); // Log para verificar movimento
                moverBotPara(proximoPasso[0], proximoPasso[1]);
            } else {
                if (labirinto.getCelula(bot.getX(), bot.getY()) == 'S') {
                    botScore++;
                    movimentoBotTimeline.stop();
                    System.out.println("Bot alcançou a saída! jogador: "+jogadorScore+ ", Bot: "+botScore);
                    reiniciarLabirinto();
                }
            }
        }));
        movimentoBotTimeline.setCycleCount(Animation.INDEFINITE);
        movimentoBotTimeline.play();
    }

    private void calcularCaminhoBot() {
        int altura = labirinto.getAltura();
        int largura = labirinto.getLargura();

        boolean[][] visitado = new boolean[altura][largura];
        int[][][] pai = new int[altura][largura][2];

        Queue<int[]> fila = new LinkedList<>();
        fila.offer(new int[]{bot.getX(), bot.getY()});
        visitado[bot.getX()][bot.getY()] = true;

        boolean encontrou = false;
        int saidaX = -1, saidaY = -1;
        if (saidaPosicao != null) {
            saidaX = saidaPosicao[0];
            saidaY = saidaPosicao[1];
        }

        while (!fila.isEmpty()) {
            int[] atual = fila.poll();
            int x = atual[0];
            int y = atual[1];

            if (x == saidaX && y == saidaY && saidaX != -1) {
                encontrou = true;
                break;
            }

            int[][] direcoes = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
            for (int[] d : direcoes) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx >= 0 && ny >= 0 && nx < altura && ny < largura && !visitado[nx][ny] && labirinto.ehMovimentoValido(nx, ny)) {
                    fila.offer(new int[]{nx, ny});
                    visitado[nx][ny] = true;
                    pai[nx][ny][0] = x;
                    pai[nx][ny][1] = y;
                }
            }
        }

        if (encontrou && saidaX != -1) {
            caminhoBot.clear();
            int currX = saidaX;
            int currY = saidaY;
            while (currX != bot.getX() || currY != bot.getY()) {
                caminhoBot.add(0, new int[]{currX, currY});
                int prevX = pai[currX][currY][0];
                int prevY = pai[currX][currY][1];
                currX = prevX;
                currY = prevY;
            }
            // Iniciar o movimento do bot após calcular o caminho
            if (movimentoBotTimeline != null && movimentoBotTimeline.getStatus() != Animation.Status.RUNNING) {
                Platform.runLater(movimentoBotTimeline::play);
            } else if (movimentoBotTimeline == null) {
                Platform.runLater(this::iniciarMovimentoBot);
            }
        } else {
            System.out.println("Bot: Não foi possível encontrar um caminho para a saída.");
        }
    }

    private int[] encontrarSaida() {
        for (int i = 0; i < labirinto.getAltura(); i++) {
            for (int j = 0; j < labirinto.getLargura(); j++) {
                if (labirinto.getCelula(i, j) == 'S') {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // Pega um sprite de bloco (ex: chão ou parede)
    private ImageView getTileSprite(int col, int row) {
        ImageView view = new ImageView(spriteSheet);
        view.setViewport(new Rectangle2D(col * blocoSize, row * blocoSize, blocoSize, blocoSize));
        view.setFitWidth(escala);
        view.setFitHeight(escala);
        return view;
    }

    private ImageView getSpriteJogador(String direcao) {
        ImageView view = new ImageView(spriteSheet);

        int row = switch (direcao) {
            case "cima" -> 2;
            case "baixo" -> 1;
            case "esquerda" -> 3;
            case "direita" -> 4;
            default -> 0; // Padrão: baixo
        };

        double offsetY = blocoSize; // Pular blocos (64px)
        double viewportX = frameAtual * jogador.getLargura();
        double viewportY = offsetY + (row * jogador.getAltura());

        view.setViewport(new Rectangle2D(viewportX, viewportY, jogador.getLargura(), jogador.getAltura()));
        view.setFitWidth(escala);
        view.setFitHeight(escala);

        return view;
    }

    public void configurarControloTeclado(Scene cena) {
        cena.setOnKeyPressed(event -> {
            teclasPressionadas.add(event.getCode());
        });

        cena.setOnKeyReleased(event -> {
            teclasPressionadas.remove(event.getCode());
        });

        movimentoContinuoJogador = new Timeline(new KeyFrame(Duration.millis(100), e -> {
            if (teclasPressionadas.contains(KeyCode.UP)) {
                moverJogadorParaCima();
            } else if (teclasPressionadas.contains(KeyCode.DOWN)) {
                moverJogadorParaBaixo();
            } else if (teclasPressionadas.contains(KeyCode.LEFT)) {
                moverJogadorParaEsquerda();
            } else if (teclasPressionadas.contains(KeyCode.RIGHT)) {
                moverJogadorParaDireita();
            }

            desenharLabirinto(gridGlobal); // Atualiza o desenho
        }));
        movimentoContinuoJogador.setCycleCount(Animation.INDEFINITE);
        movimentoContinuoJogador.play();
    }

    private void iniciarAnimacaoJogador() {
        if (animacaoJogador.getStatus() == Animation.Status.RUNNING) {
            animacaoJogador.stop();
        }
        animacaoJogador.play(); // Reinicia a animação
    }

    // Desenhar o labirinto e os personagens
    public void desenharLabirinto(GridPane grid) {
        if (grid == null) return; // evita NullPointerException

        this.gridGlobal = grid; // guarda para o Timeline

        grid.getChildren().clear();

        for (int i = 0; i < labirinto.getMapa().length; i++) {
            for (int j = 0; j < labirinto.getMapa()[i].length; j++) {

                char celula = labirinto.getCelula(i, j);

                // 1. Desenhar o chão como fundo
                ImageView fundo = getTileSprite(0, 0); // Sprite do chão
                grid.add(fundo, j, i);


                // Define a cor para cada tipo de célula
                if (celula == '#') {
                    ImageView parede = getTileSprite(2, 0); // Sprite da parede (ajusta se necessário)
                    grid.add(parede, j, i);
                }
                if (celula == 'S') {
                    Rectangle saidaRect = new Rectangle(escala, escala);
                    saidaRect.setFill(Color.GREEN);
                    grid.add(saidaRect, j, i);
                }

                // Adicionar o jogador
                if (i == jogador.getX() && j == jogador.getY()) {
                    ImageView spriteJogador = getSpriteJogador(jogador.getDirecaoJogador());
                    grid.add(spriteJogador, j, i);
                }
            }
        }
        // Certifica-se de que o bot seja redesenhado na sua posição atual
        atualizarBotGrid();
    }

    private void posicionarJogadorAleatoriamente() {
        Random random = new Random();
        int linhas = labirinto.getAltura();
        int colunas = labirinto.getLargura();

        int x, y;

        do {
            x = random.nextInt(linhas);
            y = random.nextInt(colunas);
        } while (!labirinto.ehMovimentoValido(x, y));

        jogador.setX(x);
        jogador.setY(y);
    }

    public boolean verificarSaidaJogador() {
        return labirinto.getCelula(jogador.getX(), jogador.getY()) == 'S';
    }

    private void reiniciarLabirinto() {
        // Reinicia a posição do jogador
        labirinto.resetarLabirinto();
        posicionarJogadorAleatoriamente();

        frameAtual = 0; // Reinicia a animação
        jogador.setDirecaoJogador("baixo"); // Reseta a direção

        animacaoJogador.stop(); // Para a animação, caso necessário
        animacaoJogador.play(); // Reinicia a animação

        if (movimentoBotTimeline != null) {
            movimentoBotTimeline.stop();
        }

        grid.getChildren().remove(retanguloBot); // remove visual anterior

        inicializarBot(); // Recomeça
    }

    private void moverJogador(int novoX, int novoY, String direcao) {
        if (labirinto.ehMovimentoValido(novoX, novoY)) {
            jogador.setX(novoX);
            jogador.setY(novoY);
            jogador.setDirecaoJogador(direcao);
            iniciarAnimacaoJogador();

            if (verificarSaidaJogador()) {
                jogadorScore++;
                System.out.println("Você alcançou a saída! jogador: "+jogadorScore+ ", Bot: "+botScore);
                reiniciarLabirinto();
            }
        }
    }

    private void moverJogadorParaCima() {
        moverJogador(jogador.getX() - 1, jogador.getY(), "cima");
    }

    private void moverJogadorParaBaixo() {
        moverJogador(jogador.getX() + 1, jogador.getY(), "baixo");
    }

    private void moverJogadorParaEsquerda() {
        moverJogador(jogador.getX(), jogador.getY() - 1, "esquerda");
    }

    private void moverJogadorParaDireita() {
        moverJogador(jogador.getX(), jogador.getY() + 1, "direita");
    }
}