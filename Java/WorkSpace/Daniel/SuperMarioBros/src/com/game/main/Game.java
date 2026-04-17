package com.game.main;

import com.game.gfx.Camera;
import com.game.gfx.Texture;
import com.game.gfx.Windows;
import com.game.main.util.LevelHandler;
import com.game.object.util.Handler;
import com.game.object.util.KeyInput;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    // Game Constants
    private static final int MILLIS_PER_SEC = 1000;
    private static final int NANOS_PER_SEC = 1000000000;
    private static final double NUM_TICKS = 60.0; // number of ticks (update game)
    private static final String NAME = "Super Mario Bros";

    private static final int WINDOW_WIDTH = 960;
    private static final int WINDOW_HEIGHT = 720;
    private static final int SCREEN_WIDTH = WINDOW_WIDTH - 67;
    private static final int SCREEN_HEIGHT = WINDOW_HEIGHT;
    private static final int SCREEN_OFFSET = 16 * 3;

    // Game Variables
    private boolean running;

    // Game Components
    private Thread thread;
    private Handler handler;
    private Camera cam;
    private static Texture tex;
    private LevelHandler levelHandler;


    public Game() {
        initialize();
    }

    private void initialize() {
        tex = new Texture();

        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));


        levelHandler = new LevelHandler(handler);
        levelHandler.start();


        // temporary code
        // handler.setPlayer(new Player(320, 32, 1, handler));
        //  for (int i = 0; i < 20; i++) {
        //      handler.addObj(new Block(i * 32, 32 * 10, 32, 32, 0,1));
        //  }
        //  for (int i = 0; i < 30; i++) {
        //      handler.addObj(new Block(i * 32, 32 * 15, 32, 32, 2,1));
        //  }


        cam = new Camera(0, SCREEN_OFFSET);
        new Windows(WINDOW_WIDTH, WINDOW_HEIGHT, NAME, this);
        start();
    }

    private synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;

    }

    private synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Super Mario Bros");
        new Game();
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = NUM_TICKS; // ex: 60 tick per sec
        double ns = NANOS_PER_SEC / amountOfTicks; // nano sec per tick
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        int updates = 0;

        final int TARGET_FPS = 60;
        final long OPTIMAL_TIME = NANOS_PER_SEC / TARGET_FPS;

        // a cada ciclo é somado a delta, para saber se já passou tempo suficiente para fazer uma nova atualização
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            // se delta for >=1, significa que passou tempo suficiente para fazer um Tick(). Pode acontecer mais que um tick seguido se o jogo tiver atrasado, para compensar
            while (delta >= 1) {
                tick(); // atualiza o estado do jogo
                updates++; // conta quantos ticks ocorreram
                delta--; // retira um "tick" do acumulado
            }
            if (running) {
                render(); // Desenha o estado do jogo no ecrã
                frames++; // Conta os frames (FPS)
            }

            // Espera o tempo necessário para manter o FPS estável
            long timeTaken = System.nanoTime() - now;
            long sleepTime = (OPTIMAL_TIME - timeTaken) / 1_000_000;
            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // A cada segundo (1000ms) mostra os FPS(frames per sec) e TPS(ticks per sec)
            if (System.currentTimeMillis() - timer > MILLIS_PER_SEC) {
                timer += MILLIS_PER_SEC;
                System.out.println("FPS: " + frames + " TPS: " + updates);
                updates = 0;
                frames = 0;
            }
        }
        // quando o running for false, o loop termina, para limpar o jogo
        stop();
    }

    private void tick() {
        handler.tick();
        cam.tick(handler.getPlayer());
    }

    /*
     * BufferStrategy) é um objeto que gerencia os buffers (áreas de memória) usados para desenhar na tela.
     * Ela ajuda a evitar o flickering (cintilação) que pode ocorrer quando o desenho é feito diretamente na tela enquanto ela está sendo atualizada.
     * Obtém a estratégia de buffer.
     * Cria a estratégia de buffer (com 3 buffers) na primeira chamada.
     * Obtém um objeto Graphics para desenhar no próximo buffer disponível.
     * Define a cor de desenho para preto.
     * Desenha um retângulo preto para limpar a tela ou definir o fundo.
     * Libera os recursos do objeto Graphics.
     * Exibe o buffer desenhado na tela.
     */
    private void render() {

        BufferStrategy buf = this.getBufferStrategy();

        if (buf == null) {
            /* Cria uma estratégia de buffer com três buffers (buffer triplo).
             * O buffer triplo pode oferecer uma suavidade ainda maior na renderização em comparação com o buffer duplo,
             * pois há um buffer adicional para o sistema operacional usar enquanto os outros dois estão sendo desenhados ou exibidos.
             */
            this.createBufferStrategy(3); // 3 imagens/frames
            return;
        }

        // draw graphics
        Graphics g = buf.getDrawGraphics();
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.black);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        g2d.translate(cam.getX(), cam.getY());
        // handler
        handler.render(g);
        g2d.translate(-cam.getX(), -cam.getY());

        // clean for next frame
        g.dispose();
        buf.show();
    }

    public static int getWindowWidth() {
        return WINDOW_WIDTH;
    }

    public static int getWindowHeight() {
        return WINDOW_HEIGHT;
    }

    public static int getScreenWidth() {
        return SCREEN_WIDTH;
    }

    public static int getScreenHeight() {
        return SCREEN_HEIGHT;
    }

    public static Texture getTexture() {
        return tex;
    }
}



