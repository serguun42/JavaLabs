package ru.serguun42.java.practice11;

public interface Queue<E> {
    void enqueue(E addingObject);
    E element();
    E dequeue();
    int getSize();
    boolean isEmpty();
    void clear();
}
