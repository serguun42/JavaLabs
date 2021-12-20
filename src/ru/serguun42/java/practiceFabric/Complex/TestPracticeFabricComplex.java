package ru.serguun42.java.practiceFabric.Complex;

public class TestPracticeFabricComplex {
    public static void main(String[] args) {
        ConcreteFactory factory = new ConcreteFactory();

        System.out.println(factory.createComplex(-5, 42));
    }
}
