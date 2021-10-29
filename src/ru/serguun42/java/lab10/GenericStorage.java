package ru.serguun42.java.lab10;

import java.util.ArrayList;
import java.util.Arrays;

public class GenericStorage<E> {
    public ArrayList<E> data;

    GenericStorage() {
        this.data = new ArrayList<>();
    }

    GenericStorage(ArrayList<E> data) {
        this.data = data;
    }

    GenericStorage(E[] data) {
        this.data = new ArrayList<E>();
        this.data.addAll(Arrays.asList(data));
    }

    public void set(ArrayList<E> data) {
        this.data = data;
    }

    public void set(E[] data) {
        this.data = new ArrayList<E>();
        this.data.addAll(Arrays.asList(data));
    }

    public ArrayList<E> get() {
        return this.data;
    }
}
