package com.game.gfx;

import com.game.main.Game;

import javax.swing.JFrame;
import java.awt.Dimension;

public class Windows {

    // variables
    private JFrame frame;
    private Dimension size;

    // constructer
    public Windows(int with, int height, String title, Game game){
        size= new Dimension(with, height);
        frame = new JFrame(title);

        frame.setPreferredSize(size);
        frame.setMaximumSize(size);
        frame.setMinimumSize(size);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
    }

}
