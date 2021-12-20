package ru.serguun42.java.practiceFabric.Chairs;

public class Client {
    public Chair chair;

    public void sit() {
        try {
            System.out.println("Client has just sat down on chair " + chair.getClass().getSimpleName());
        } catch (Exception e) {
            System.out.println("Client has just sat down.");
        }
    }

    public void setChair(Chair chair) {
        this.chair = chair;
    }
}
