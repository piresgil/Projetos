/*
 *  @ Daniel Gil
 */

 package model.entities;

import model.entities.enums.Color;

public class Rectangle extends AbstractShape {
    // Herda da class enum color
    private Double witdth;
    private Double height;

    public Rectangle(Color color, Double witdth, Double height) {
        super(color);
        this.witdth = witdth;
        this.height = height;
    }

    public Double getWitdth() {
        return witdth;
    }

    public void setWitdth(Double witdth) {
        this.witdth = witdth;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

// CONTRACT : Area aqui cumpre contract da class abstractShape
    @Override
    public Double area() {
        return witdth * height;
    }
}