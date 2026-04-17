package com.game.object.util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

// extending KeyAdapting allows the extending class (KeyInput) because a KeyEvent Listener
// A keyEvent Listener takes actions when certain events take place (KeyPress, KeyRelease)
public class KeyInput extends KeyAdapter {

    //variables
    private boolean[] keyDown = new boolean[4];
    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }

        // Jump
        if (key == KeyEvent.VK_W) {
            if (!handler.getPlayer().hasJumped()) {
                handler.getPlayer().setVelY(-15);
                keyDown[0] = true;
                handler.getPlayer().setJumped(true);
            }
        }

        // Left
        if (key == KeyEvent.VK_A) {
            handler.getPlayer().setVelX(-8);
            keyDown[1] = true;
        }

        // Right
        if (key == KeyEvent.VK_D) {
            handler.getPlayer().setVelX(8);
            keyDown[2] = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W){
            keyDown[0]=false;
        }

        if (key == KeyEvent.VK_A){
            keyDown[1]=false;
        }

        if (key == KeyEvent.VK_D){
            keyDown[2]=false;
        }

        if (!keyDown[1] && !keyDown[2]){
            handler.getPlayer().setVelX(0);
        }


    }
}
