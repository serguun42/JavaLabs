package ru.serguun42.java.lab9;

import java.util.Scanner;

public class ThrowsDemo {
    public void getKey() {
        Scanner scanner = new Scanner(System.in);
        boolean passed = false;

        while (!passed) {
            System.out.print("Enter key: ");
            String key = scanner.nextLine();

            try {
                printDetails(key);
                passed = true;
            } catch (Exception e) {
                System.out.println("Wrong key, try other");
            }
        }
    }

    public void printDetails(String key) throws Exception {
        String message = getDetails(key);
        System.out.println(message);
    }

    private String getDetails(String key) throws Exception {
        if (key.equals(""))
            throw new Exception("Key set to empty string");

        return "data for " + key;
    }
}
