package ru.serguun42.java.practice3;

public class Square extends Rectangle {
    public Square() {
        super();
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return this.width;
    }

    public void setSide(double side) {
        setWidth(side);
        setHeight(side);
    }

    @Override
    public void setWidth(double side) {
        this.width = side;
        this.height = side;
    }

    @Override
    public void setHeight(double side) {
        this.width = side;
        this.height = side;
    }

    @Override
    public String toString() {
        return "Square { side: \"" + width + "\", color: \"" + color + "\", filled: \"" + filled + "\" }";
    }
}
