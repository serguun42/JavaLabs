package ru.serguun42.java.lab10;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @version Написать класс, который умеет хранить в себе массив любых типов данных (int, long etc.).
 */
public class Lab10Test {
    public static void main(String[] args) {
        Integer[] arrOfInt = {1, 2, 3, 4, 66};
        GenericStorage<Integer> storageOfInts = new GenericStorage<>(arrOfInt);
        System.out.println(storageOfInts.get());


        ArrayList<String> listOfStr = new ArrayList<String>(Arrays.asList(
                "Hello",
                "there",
                "general <E>"
        ));
        GenericStorage<String> storageOfStrings = new GenericStorage<>(listOfStr);
        System.out.println(storageOfStrings.get());
    }
}
