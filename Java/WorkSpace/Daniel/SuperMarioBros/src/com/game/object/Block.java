package com.game.object;

import com.game.gfx.Texture;
import com.game.main.Game;
import com.game.object.util.ObjectId;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Block extends GameObject {

    // Variables
    private Texture tex = Game.getTexture();
    private int index;
    private BufferedImage[] sprite;

    private boolean hit;
    private Debris debris;

    // constructor
    public Block(int x, int y, int with, int height, int index, int scale) {
        super(x, y, ObjectId.Block, with, height, scale);
        this.index = index;
        sprite = tex.getTile1();
    }

    @Override
    public void trick() {
        if (hit) {
            debris.tick();
        }
    }

    public boolean shouldRemove() {
        if (debris.shouldRemove()) {
            return true;
        }
        return false;
    }

    @Override
    public void render(Graphics g) {
        // temporary code
        // g.setColor(Color.WHITE);
        // g.drawRect((int) getX(), (int) getY(), (int) getWith(), (int) getHeight());
        if (!hit) {
            g.drawImage(sprite[index], (int) getX(), (int) getY(), (int) getWidth(), (int) getHeight(), null);
        } else {
            debris.draw(g);
        }
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) getX(), (int) getY(), (int) getWidth(), (int) getHeight());
    }

    public void hit() {
        hit = true;
        debris = new Debris(getX(), getY(), getWidth(), getHeight(), getScale());
    }
}
