package ru.serguun42.java.lab3;

public class Cup extends Dish {
    protected static String TYPE_NAME = "cup";

    public Cup() {
        super(TYPE_NAME);
    }

    public Cup(String color) {
        super(TYPE_NAME, color);
    }

    @Override
    public void cleanWithTool(String toolName) {
        System.out.println("Cleaning " + this.getType() + " colored in " + this.getColor() + " with " + toolName);
    }

    @Override
    public void serve(String food) {
        System.out.println("Serving " + this.getType() + " colored in " + this.getColor() + " with " + food);
        System.out.println("Serving " + this.getType() + ", so you may need some saucer");
    }
}
