package ru.serguun42.java.practice8;

import java.util.concurrent.ConcurrentLinkedQueue;

public class UnfairWaitList<E> extends WaitList<E> {
    UnfairWaitList() {
        this.content = new ConcurrentLinkedQueue<E>();
    }

    public void remove(E seekingElement) {
        int size = this.content.size();
        for (int i = 0; i < size; i++) {
            E currentElement = this.content.remove();

            if (currentElement != seekingElement)
                this.content.add(currentElement);
        }
    }

    /**
     * @param seekingElement Seeking seekingElement which needs to move to queue's end
     */
    public void moveToBack(E seekingElement) {
        boolean found = false;

        int size = this.content.size();
        for (int i = 0; i < size; i++) {
            E currentElement = this.content.remove();

            if (currentElement.equals(seekingElement))
                found = true;
            else
                this.content.add(currentElement);
        }

        if (found)
            this.content.add(seekingElement);
    }
}
