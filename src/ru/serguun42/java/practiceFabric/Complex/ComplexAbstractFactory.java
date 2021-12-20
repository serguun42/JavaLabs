package ru.serguun42.java.practiceFabric.Complex;

public interface ComplexAbstractFactory {
    Complex createComplex();
    Complex createComplex(int real, int image);
}
