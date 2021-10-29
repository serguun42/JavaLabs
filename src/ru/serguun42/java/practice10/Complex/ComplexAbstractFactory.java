package ru.serguun42.java.practice10.Complex;

public interface ComplexAbstractFactory {
    Complex createComplex();
    Complex createComplex(int real, int image);
}
