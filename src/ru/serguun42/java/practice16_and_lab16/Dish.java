package ru.serguun42.java.practice16_and_lab16;

final public class Dish extends MenuItem {
    public Dish(String name, String description) {
        super(name, description);
    }

    public Dish(String name, String description, int cost) {
        super(name, description, cost);
    }
}
