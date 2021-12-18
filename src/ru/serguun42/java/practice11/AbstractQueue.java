package ru.serguun42.java.practice11;

abstract public class AbstractQueue<E> implements Queue<E> {
    private E head;
    private E tail;
    private int size;

    @Override
    public void enqueue(E addingObject) {}

    @Override
    public E element() {
        return head;
    }

    @Override
    public E dequeue() {
        return head;
    }

    @Override
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void increaseSize() {
        ++this.size;
    }

    public void decreaseSize() {
        --this.size;
    }

    public E getHead() {
        return head;
    }

    public void setHead(E head) {
        this.head = head;
    }

    public E getTail() {
        return tail;
    }

    public void setTail(E tail) {
        this.tail = tail;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
