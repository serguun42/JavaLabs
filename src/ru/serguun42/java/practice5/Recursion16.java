package ru.serguun42.java.practice5;

import java.util.ArrayList;
import java.util.Scanner;

public class Recursion16 {
    public static ArrayList<Integer> list = new ArrayList();
    public static Scanner scanner = new Scanner(System.in);

    public static void recursion() {
        int num = scanner.nextInt();

        if (num <= 0) {
            int max = 0;
            int counter = 0;

            for (int i = 0; i < list.size(); i++) {
                int curr = list.get(i);

                if (curr > max) {
                    max = curr;
                    counter = 1;
                } else if (curr == max)
                    ++counter;
            }

            System.out.println(counter + " elements is equal to the greatest one");
        } else {
            list.add(num);
            recursion();
        }
    }

    public static void main(String[] args) {
        System.out.println("Input your sequence of natural numbers:");
        recursion();
    }
}
