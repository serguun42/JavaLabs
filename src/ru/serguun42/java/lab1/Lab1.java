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

        System.out.println(String.format("sumViaFor = %d", sumViaFor));
    }
}
