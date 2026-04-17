/*
* @ Daniel Gil
*/

package entities;

import entities.enums.Color;

public class Rectangle extends Shape {
    private Double witdth;
    private Double height;

    public Rectangle() {
        super();
    }

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

    @Override
    public Double area() {
        return witdth * height;
    }
}