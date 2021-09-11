package ru.serguun42.java.lab4;

public class Product implements Priceable {
    protected double price;
    protected double quantity;
    protected String name;

    public Product() {
        this.price = 0;
        this.quantity = 0;
        this.name = "undefined";
    }

    public Product(double price, double quantity, String name) {
        this.price = price;
        this.quantity = quantity;
        this.name = name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }
}
