package ru.serguun42.java.practice5;

import java.util.Scanner;

public class Recursion15 {
    public static void recursion(long num) {
        if (num <= 0) return;

        System.out.print((num % 10) + " ");
        recursion(num / 10);
    }

    public static void main(String[] args) {
        System.out.print("Input your number to split recursively: ");

        Scanner scanner = new Scanner(System.in);
        long userNum = Long.parseLong(scanner.nextLine());

        System.out.println("Reversed number: ");
        recursion(userNum);
    }
}
