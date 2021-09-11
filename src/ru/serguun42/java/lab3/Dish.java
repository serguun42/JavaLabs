package ru.serguun42.java.lab3;

abstract public class Dish {
    protected String type;
    protected String color;

    public Dish() {
        this.type = "undefined";
        this.color = "undefined";
    }

    public Dish(String type) {
        this.type = type;
        this.color = "undefined";
    }

    public Dish(String type, String color) {
        this.type = type;
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setColor(String color) {
        this.color = color;
    }

    abstract public void cleanWithTool(String toolName);

    abstract public void serve(String food);

    @Override
    public String toString() {
        return "Dish { type: \"" + type + "\", color: \"" + color + "\" }";
    }
}
