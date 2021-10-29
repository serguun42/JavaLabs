package ru.serguun42.java.practice10.Complex;

public class Complex {
    private int real;
    private int image;

    public Complex() {
        this.real = 0;
        this.image = 0;
    }

    public Complex(int real, int image) {
        this.real = real;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Complex number: " + real + (image < 0 ? " - " : " + ") + image + "i";
    }
}
