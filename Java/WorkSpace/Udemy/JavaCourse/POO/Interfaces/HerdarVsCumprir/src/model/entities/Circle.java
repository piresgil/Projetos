/*
 *  @ Daniel Gil
 */

 package model.entities;

import model.entities.enums.Color;

public class Circle extends AbstractShape {
    // Herda da class enum color
    private Double radius;

    public Circle(Color color, Double radius) {
        super(color);
        this.radius = radius;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    // CONTRACT : Area aqui cumpre contract da class abstractShape
    @Override
    public Double area() {
        return Math.PI * radius * radius;
    }
}