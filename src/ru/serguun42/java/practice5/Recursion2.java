package ru.serguun42.java.practice5;

import java.util.Scanner;

public class Recursion2 {
    public static Scanner scanner = new Scanner(System.in);

    public static void recursion(int curr, int max) {
        if (curr > max) return;

        System.out.print(curr + " ");
        recursion(curr + 1, max);
    }

    public static void main(String[] args) {
        System.out.print("Input your n: ");
        int n = scanner.nextInt();

        recursion(1, n);
    }
}
