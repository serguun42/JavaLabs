package ru.serguun42.java.practice11;

public class TestPractice11 {
    public static void main(String[] args) {
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();

        for (int i = 20; i < 30; i++) linkedQueue.enqueue(i);

        System.out.println("element(): " + linkedQueue.element());
        System.out.println("getSize(): " + linkedQueue.getSize());
        System.out.println("getTail(): " + linkedQueue.getTail());
        System.out.println("isEmpty(): " + linkedQueue.isEmpty());
        System.out.println("______________");


        for (int i = 0; i < 9; i++)
            System.out.println("Dequeue #" + i + ": "+ linkedQueue.dequeue());

        System.out.println("______________");


        System.out.println("element(): " + linkedQueue.element());
        System.out.println("getSize(): " + linkedQueue.getSize());
        System.out.println("getTail(): " + linkedQueue.getTail());
        System.out.println("isEmpty(): " + linkedQueue.isEmpty());
        System.out.println("______________");


        System.out.println("Dequeue last: "+ linkedQueue.dequeue());
        System.out.println("______________");


        System.out.println("element(): " + linkedQueue.element());
        System.out.println("getSize(): " + linkedQueue.getSize());
        System.out.println("getTail(): " + linkedQueue.getTail());
        System.out.println("isEmpty(): " + linkedQueue.isEmpty());
    }
}
