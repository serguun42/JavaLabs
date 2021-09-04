package ru.serguun42.java.practice1;

import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {
        System.out.print("Create your dog. Input dog's name: ");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.print("Input age: ");
        int age = Integer.parseInt(scanner.nextLine());

        Dog dog = new Dog(name, age);
        System.out.println("Your dog: " + dog.ToString());

        System.out.print("Would you like to change dog's properties? (y/n): ");
        String nextAnswer = scanner.nextLine();

        if (!(nextAnswer.matches("^y"))) return;

        System.out.print("Would you like to change dog's <name>? (y/n): ");
        nextAnswer = scanner.nextLine();
        if (nextAnswer.matches("^y")) {
            System.out.print("New name: ");
            name = scanner.nextLine();
            dog.setName(name);
        }

        System.out.print("Would you like to change dog's <age>? (y/n): ");
        nextAnswer = scanner.nextLine();
        if (nextAnswer.matches("^y")) {
            System.out.print("New age: ");
            age = Integer.parseInt(scanner.nextLine());
            dog.setAge(age);
        }

        System.out.println("Your new dog: " + dog.ToString());
    }
}
