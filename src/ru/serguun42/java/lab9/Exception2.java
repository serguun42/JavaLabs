package ru.serguun42.java.lab9;

import java.util.Scanner;

public class Exception2 {
    public void exceptionDemo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an integer");
        String intString = scanner.next();

        try {
            int i = Integer.parseInt(intString);
            System.out.println("2 / i = " + (2 / i));
        } catch (Exception e) {
            if (e instanceof ArithmeticException)
                System.out.println("There was the ArithmeticException");
            else if (e instanceof NumberFormatException)
                System.out.println("There was the NumberFormatException");
            else
                System.out.println("wat?\n" + e);
        } finally {
            System.out.println("That's all stories folks!");
        }
    }
}
