package com.game.gfx;

import com.game.main.Game;
import com.game.object.GameObject;

public class Camera {
    // variables
    private int x, y;

    public Camera(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void tick(GameObject player) {
        x = (int) (-player.getX() + Game.getScreenWidth() / 2);
       // y = (int) (-player.getY() + Game.getScreenHeight() / 2);
    }

    // setters
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    // getters

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
