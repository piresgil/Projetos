package com.game.object;

import com.game.object.util.ObjectId;

import java.awt.*;

public abstract class GameObject {

    // variables
    private float x, y; // positions
    private ObjectId id; // id
    private float velX, velY; // velocity
    private float with, height; // size obj
    private int scale; // scale obj

    public GameObject(float x, float y, ObjectId id, float with, float height, int scale) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.with = with * scale;
        this.height = height * scale;
        this.scale = scale;
    }

    public abstract void trick(); // update game (positions etc)

    public abstract void render(Graphics g); // all graphics

    public abstract Rectangle getBounds(); // find gaming bounds(collisions etc.)

    // gravity
    public void applyGravity() {
        velY += 0.5f;
    }

    // setters
    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }


    public void setVelY(float velY) {
        this.velY = velY;
    }

    public void setWith(float with) {
        this.with = with;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setScale(int scale){
        this.scale= scale;
    }

    // Getters
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public ObjectId getId() {
        return id;
    }

    public float getVelX() {
        return velX;
    }

    public float getVelY() {
        return velY;
    }

    public float getWidth() {
        return with;
    }

    public float getHeight() {
        return height;
    }

    public int getScale() {
        return scale;
    }

}
