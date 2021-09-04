package ru.serguun42.java.lab1;

import java.util.ArrayList;

public class Lab1 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 8, 42, 777, 2000};

        int sumViaFor = 0;
        int sumViaWhile = 0;
        int sumViaDo = 0;

        for (int num : nums)
            sumViaFor += num;

        int whileCounter = 0;
        while (whileCounter < nums.length) {
            sumViaWhile += nums[whileCounter++];
        }

        int doCounter = 0;
        do {
            sumViaDo += nums[doCounter++];
        } while (doCounter < nums.length);

        System.out.println(String.format("sumViaFor = %d", sumViaFor));
        System.out.println(String.format("sumViaWhile = %d", sumViaWhile));
        System.out.println(String.format("sumViaDo = %d", sumViaDo));


        System.out.println("Args from command line:");
        for (String arg : args)
            System.out.print(arg + "\t");


        System.out.println("\n\nHarmonics:");
        for (double i = 1; i <= 10; i += 1)
            System.out.print(String.format("%.3f\t", 1d / i));
    }
}
