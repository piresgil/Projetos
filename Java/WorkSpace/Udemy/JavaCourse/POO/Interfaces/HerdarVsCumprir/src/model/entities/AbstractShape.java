/*
 *  @ Daniel Gil
 */

 package model.entities;

import model.entities.enums.Color;

public abstract class AbstractShape implements Shape {
// CONTRACT : Area será implementado pelas class concretas (circle e rectangle)
  private Color color;

  public AbstractShape(Color color) {
    this.color = color;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }
}
