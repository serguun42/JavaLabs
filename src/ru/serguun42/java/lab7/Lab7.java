package ru.serguun42.java.lab7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Lab7 {
    public static void printList(ArrayList<String> listToPrint) {
        printList(listToPrint, "");
    }

    public static void printList(ArrayList<String> listToPrint, String additionalMessage) {
        System.out.println(
                String.format(
                        "\r\nHere goes list with size of %d (%s)",
                        listToPrint.size(),
                        additionalMessage
                )
        );
        listToPrint.forEach((value) -> System.out.println(value));
        System.out.println("-------------------\r\n");
    }

    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();

        System.out.print("Input some text (empty line to stop): ");
        Scanner scanner = new Scanner(System.in);
        String lastLine = scanner.nextLine();
        while (lastLine.trim().length() > 0) {
            System.out.print("Next: ");
            myList.add(lastLine);
            lastLine = scanner.nextLine();
        }

        printList(myList);

        ArrayList<String> listToAttach = new ArrayList<>(
                Arrays.asList("Additional elem 1", "Additional elem 2", "Additional elem 3")
        );
        myList.addAll(listToAttach);

        printList(myList);


        System.out.println("Second from the end element: " + myList.get(myList.size() - 2));
        System.out.println("First index of '123': " + myList.indexOf("123"));
        System.out.println("Last index of '123': " + myList.lastIndexOf("123"));

        if (myList.size() > 3) myList.get(myList.size() - 4);
        printList(myList, "Removed 4th from the end elem");


        myList.set(1, "Some new text");
        printList(myList, "Updated second element with 'Some new text'");


        myList.sort(new Lab7Comparator());
        printList(myList, "Sorted by length decreasing");


        printList(
                new ArrayList<>(myList.subList(1, myList.size() - 1)),
                "Sublist – skipped one from start and from end"
        );
    }
}
