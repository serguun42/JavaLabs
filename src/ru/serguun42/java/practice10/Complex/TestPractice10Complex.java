package ru.serguun42.java.practice10.Complex;

public class TestPractice10Complex {
    public static void main(String[] args) {
        ConcreteFactory factory = new ConcreteFactory();

        System.out.println(factory.createComplex(-5, 42));
    }
}
