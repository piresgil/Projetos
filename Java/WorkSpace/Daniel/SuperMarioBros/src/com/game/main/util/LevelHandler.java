package com.game.main.util;

import com.game.gfx.BufferedImageLoader;
import com.game.object.Block;
import com.game.object.Pipe;
import com.game.object.Player;
import com.game.object.util.Handler;

import java.awt.image.BufferedImage;

public class LevelHandler {

    // Variables
    private final String PARENT_FOLDER = "/level";

    private BufferedImageLoader loader;
    private BufferedImage levelTiles;
    private Handler handler;

    // constructor

    public LevelHandler(Handler handler) {
        this.handler = handler;
        loader = new BufferedImageLoader();
    }

    public void start() {
        // System.out.println("star lvl things");
        setLevel(PARENT_FOLDER + "/Untitled.png");
        loadCharacters();
    }

    public void setLevel(String levelTilesPath) {
        this.levelTiles = loader.loadImage(levelTilesPath);

        if (levelTiles == null) {
            System.out.println("Erro: imagem não carregada.");
            return;
        } else {
            System.out.println("Imagem carregada com sucesso: " + levelTilesPath);
        }

        int width = levelTiles.getWidth();
        int height = levelTiles.getHeight();
        System.out.println("Imagem carregada: " + width + "x" + height);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int pixel = levelTiles.getRGB(j, i);  // Corrigir para j, i
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;

                //  if (red == 255 && green == 255 && blue == 255) {
                //      continue;
                //  }

                if (red == 0 && green == 0 && blue == 0) {
                    System.out.println("Bloco encontrado em: " + j + ", " + i);
                    System.out.println("Pixel RGB: " + red + ", " + green + ", " + blue);
                    handler.addObj(new Block(j * 16, i * 16, 16, 16, 0, 1));  // Corrigido para j, i
                }
                if (red == 0 && green == 100 && blue == 0) {
                    handler.addObj(new Pipe(j * 16, i * 16, 32, 16, 0, 1, false));  // Corrigido para j, i
                }
                if (red == 0 && green == 255 && blue == 0) {
                    handler.addObj(new Pipe(j * 16, i * 16, 32, 16, 1, 1, false));  // Corrigido para j, i
                }
            }
        }
    }

    public void loadCharacters() {
        handler.setPlayer(new Player(300, 0, 1, handler));
    }
}
