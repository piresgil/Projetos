package com.game.object;

import com.game.gfx.Animation;
import com.game.gfx.Texture;
import com.game.main.Game;
import com.game.object.util.Handler;
import com.game.object.util.ObjectId;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Player extends GameObject {
    // constants
    private static final float WIDTH = 16;
    private static final float HEIGHT = 16;

    // variables
    private Handler handler;
    private Texture tex;

    private PlayerState state;
    private BufferedImage[] spriteL, spriteS;
    private Animation playerWalkL, playerWalkS;
    private BufferedImage[] currentSprite;
    private Animation currentAnimation;
    private LinkedList<Block> removeBlocks;

    private boolean jumped = false;
    private int health = 2;
    private boolean forwad = false;

    public Player(float x, float y, int scale, Handler handler) {
        super(x, y, ObjectId.Player, WIDTH, HEIGHT, scale);
        this.handler = handler;
        tex = Game.getTexture();
        removeBlocks = new LinkedList<Block>();

        spriteL = tex.getMarioL();
        spriteS = tex.getMarioS();

        playerWalkL = new Animation(5, spriteL[1], spriteL[2], spriteL[3]);
        playerWalkS = new Animation(5, spriteS[1], spriteS[2], spriteS[3]);

        state = PlayerState.Small;
        currentSprite = spriteS;
        currentAnimation = playerWalkS;
    }

    /* @Override
     public void trick() {
         setX(getVelX() + getX());
         setY(getVelY() + getY());
         applyGravity();

         collisions();
     }*/
    @Override
    public void trick() {
        // Movimento horizontal primeiro
        setX(getX() + getVelX());
        checkHorizontalCollisions();

        // Movimento vertical depois
        setY(getY() + getVelY());
        applyGravity();
        checkVerticalCollisions();

        currentAnimation.runAnimation();
    }

    @Override
    public void render(Graphics g) {
        // temporary code
        // g.setColor(Color.YELLOW);
        // g.fillRect((int) getX(), (int) getY(), (int) WIDTH, (int) HEIGHT);
        //  if (health == 1) {
        //      g.drawImage(spriteS[0], (int) getX(), (int) getY(), (int) getWidth(), (int) getHeight() / 2, null);
        //  } else if (health == 2) {
        //      g.drawImage(spriteL[0], (int) getX(), (int) getY(), (int) getWidth(), (int) getHeight(), null);
        //  }

        if (jumped) {
            if (forwad) {
                g.drawImage(currentSprite[5], (int) getX(), (int) getY(), (int) getWidth(), (int) getHeight(), null);
            } else {
                g.drawImage(currentSprite[5], (int) (getX() + getWidth()), (int) getY(), (int) -getWidth(), (int) getHeight(), null);
            }
        } else if (getVelX() > 0) {
            currentAnimation.drawAnimation(g, (int) getX(), (int) getY(), (int) getWidth(), (int) getHeight());
            forwad = true;
        } else if (getVelY() < 0) {
            currentAnimation.drawAnimation(g, (int) (getX() + getWidth()), (int) getY(), (int) -getWidth(), (int) getHeight());
            forwad = false;
        } else {
            g.drawImage(currentSprite[0], (int) getX(), (int) getY(), (int) getWidth(), (int) getHeight(), null);
        }

        // showBounds(g);
    }


    private void checkHorizontalCollisions() {
        for (GameObject temp : handler.getGameObjects()) {
            if (temp.getId() == ObjectId.Block || temp.getId() == ObjectId.Pipe) {
                if (getBoundsRight().intersects(temp.getBounds())) {
                    setX(temp.getX() - getWidth());
                }
                if (getBoundsLeft().intersects(temp.getBounds())) {
                    setX(temp.getX() + temp.getWidth());
                }
            }
        }
    }

    private void checkVerticalCollisions() {
        for (GameObject temp : handler.getGameObjects()) {

            if (removeBlocks.contains(temp)) continue;

            if (temp.getId() == ObjectId.Block || temp.getId() == ObjectId.Pipe) {
                // Colisão inferior (chão)
                if (getBounds().intersects(temp.getBounds())) {
                    if (getVelY() > 0) {
                        setY(temp.getY() - getHeight());
                        setVelY(0);
                        jumped = false;
                    }
                }

                // Colisão superior (teto)
                if (getBoundsTop().intersects(temp.getBounds())) {
                    setY(temp.getY() + temp.getHeight());
                    setVelY(0);
                }
            }
        }
    }

    /*  private void collisions() {
          for (int i = 0; i < handler.getGameObjects().size(); i++) {
              GameObject temp = handler.getGameObjects().get(i);

              if (temp.getId() == ObjectId.Block || temp.getId() == ObjectId.Pipe) {
                  if (getBounds().intersects(temp.getBounds())) {
                      if (getVelY() > 0) { // só se estiver a cair
                          setY(temp.getY() - getHeight());
                          setVelY(0);
                          jumped = false;
                      }
                  }
                  if (getBoundsTop().intersects(temp.getBounds())) {
                      setY(temp.getY() + temp.getHeight());
                      setVelY(0);
                  }
                  if (getBoundsRight().intersects(temp.getBounds())) {
                      setX(temp.getX() - getWidth());
                  }
                  if (getBoundsLeft().intersects(temp.getBounds())) {
                      setX(temp.getX() + temp.getWidth());
                  }
              }
          }
      }*/
    @Override
    public Rectangle getBounds() { // Bottom (baixo)
        return new Rectangle(
                (int) (getX() + getWidth() / 2 - getWidth() / 4),
                (int) (getY() + getHeight() / 2),
                (int) getWidth() / 2,
                (int) getHeight() / 2);
    }

    public Rectangle getBoundsTop() {
        return new Rectangle(
                (int) (getX() + getWidth() / 2 - getWidth() / 4),
                (int) getY(),
                (int) getWidth() / 2,
                (int) getHeight() / 2);
    }

    public Rectangle getBoundsRight() {
        return new Rectangle(
                (int) (getX() + getWidth() - 5),
                (int) getY() + 5,
                5,
                (int) getHeight() - 10
        );
    }

    public Rectangle getBoundsLeft() {
        return new Rectangle(
                (int) getX(),
                (int) (getY() + 5),
                5,
                (int) getHeight() - 10
        );
    }

    public void showBounds(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.red);
        g2d.draw(getBounds());
        g2d.draw(getBoundsRight());
        g2d.draw(getBoundsLeft());
        g2d.draw(getBoundsTop());
    }

    public boolean hasJumped() {
        return jumped;
    }

    public void setJumped(boolean hasJumped) {
        this.jumped = hasJumped;
    }
}
