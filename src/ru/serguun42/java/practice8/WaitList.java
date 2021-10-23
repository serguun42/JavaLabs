package ru.serguun42.java.practice8;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

abstract public class WaitList<E> implements IWaitList<E> {
    protected ConcurrentLinkedQueue <E> content;

    /**
     * Creates instance with empty linked queue
     */
    WaitList() {
        this.content = new ConcurrentLinkedQueue<>();
    }

    /**
     * Creates instance with preset collection
     * @param c Origin preset collection
     */
    WaitList(Collection<E> c) {
        this.content = new ConcurrentLinkedQueue<>(c);
    }

    @Override
    public String toString() {
        return "WaitList:\n\t" + content.stream().map(Object::toString).collect(Collectors.joining("\n\t"));
    }

    @Override
    public void add(E element) {
        this.content.add(element);
    }

    @Override
    public E remove() {
        return this.content.remove();
    }

    @Override
    public boolean contains(E element) {
        return this.content.contains(element);
    }

    /**
     * @param c Collection which elements are all contained in content
     * @return boolean
     */
    @Override
    public boolean containsAll(Collection<E> c) {
        return this.content.containsAll(c);
    }

    @Override
    public boolean isEmpty() {
        return (this.content.size() == 0);
    }
}
