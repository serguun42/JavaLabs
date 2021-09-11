package ru.serguun42.java.lab3;

public class DishTest {
    public static void main(String[] args) {
        Cup cup = new Cup("#AADDFF");
        cup.cleanWithTool("Sponge");
        cup.serve("Tea");

        Plate plate = new Plate("#FFFFFF");
        plate.cleanWithTool("Another sponge");
        plate.serve("Жареные гвозди");
    }
}
