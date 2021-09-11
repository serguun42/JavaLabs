package ru.serguun42.java.practice3;

abstract public class Shape {
    protected String color;
    protected boolean filled;

    public Shape() {
        this.color = "undefined";
        this.filled = false;
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    abstract public double getArea();

    abstract public double getPerimeter();

    abstract public String toString();
}
