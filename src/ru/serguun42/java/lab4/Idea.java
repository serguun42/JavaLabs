package ru.serguun42.java.lab4;

public class Idea implements Priceable {
    protected double price;
    protected String summary;

    public Idea() {
        this.price = 0;
        this.summary = "undefined";
    }

    public Idea(double price, String summary) {
        this.price = price;
        this.summary = summary;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String getSummary() {
        return summary;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
