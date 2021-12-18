package ru.serguun42.java.practice11;

import java.util.LinkedList;

public class LinkedQueue<E> extends AbstractQueue<E> {
    private LinkedList<E> queue;

    public LinkedQueue() {
        this.queue = new LinkedList<E>();
        setHead(null);
        setTail(null);
        setSize(0);
    }

    @Override
    public void enqueue(E addingObject) {
        if (getSize() == 0) setHead(addingObject);
        setTail(addingObject);

        queue.add(addingObject);
        increaseSize();
    }

    @Override
    public E dequeue() {
        if (isEmpty()) return null;

        E returningHead = getHead();

        if (getSize() == 1) {
            setHead(null);
            setTail(null);
        } else
            setHead(queue.get(1));

        queue.removeFirst();
        decreaseSize();

        return returningHead;
    }

    @Override
    public void clear() {
        setHead(null);
        setTail(null);
        setSize(0);
        queue.clear();
    }
}
