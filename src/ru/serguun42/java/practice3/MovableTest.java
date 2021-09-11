package ru.serguun42.java.practice3;

public class MovableTest {
    public static void main(String[] args) {
        MovablePoint point = new MovablePoint(42, 20, 4, 3);
        System.out.println("Initial point: " + point);
        point.moveUp();
        point.moveUp();
        point.moveLeft();
        System.out.println("Moved point: " + point);


        MovableCircle circle = new MovableCircle(42, 20, 4, 3, 50);
        System.out.println("Initial circle: " + circle);
        circle.moveUp();
        circle.moveUp();
        circle.moveLeft();
        System.out.println("Moved circle: " + circle);


        MovableRectangle rect = new MovableRectangle(0, 50, 100, 0, 5, 10);
        System.out.println("Initial rect: " + rect);
        rect.moveUp();
        rect.moveUp();
        rect.moveLeft();
        System.out.println("Moved rect: " + rect);
    }
}
