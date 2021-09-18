package ru.serguun42.java.lab5;

import java.awt.*;

abstract public class Shape {
    protected Color color;
    protected int posX;
    protected int posY;

    Shape() {
        color = Color.BLACK;
        posX = 0;
        posY = 0;
    }

    public Shape(int posX, int posY) {
        int red = (int)(Math.random() * 255);
        int green = (int)(Math.random() * 255);
        int blue = (int)(Math.random() * 255);

        this.color = new Color(red, green, blue);
        this.posX = posX;
        this.posY = posY;
    }

    public Shape(Color color, int posX, int posY) {
        this.color = color;
        this.posX = posX;
        this.posY = posY;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    abstract public void setPosX(int posX);

    abstract public void setPosY(int posY);

    public Color getColor() {
        return color;
    }

    abstract public int getPosX();

    abstract public int getPosY();
}
