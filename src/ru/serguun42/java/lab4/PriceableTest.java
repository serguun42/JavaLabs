package ru.serguun42.java.lab4;

public class PriceableTest {
    public static void main(String[] args) {
        Product prod1 = new Product(42.69, 9000, "First product ever");
        System.out.println("Product " + prod1.getName() + " has price " + prod1.getPrice());

        Idea idea = new Idea(1000000, "flying cars");
        System.out.println("Idea about " + idea.getSummary() + " can be sold for " + idea.getPrice());
    }
}
