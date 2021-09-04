package ru.serguun42.java.practice1;

import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {
        System.out.print("Create your dog. Input dog's name: ");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        if (name.length() == 0) {
            System.out.println("Name can't be empty");
            return;
        }

        System.out.print("Input age: ");
        int age = Integer.parseInt(scanner.nextLine());

        if (age < 0) {
            System.out.println("Age can't negative");
            return;
        }

        Dog doggo = new Dog(name, age);
        System.out.println("Your dog: " + doggo.ToString());
        System.out.println(doggo.convertAgeToHumanLike());

        System.out.print("Would you like to change dog's properties? (y/n): ");
        String nextAnswer = scanner.nextLine();

        if (!(nextAnswer.matches("^y"))) return;

        System.out.print("Would you like to change dog's <name>? (y/n): ");
        nextAnswer = scanner.nextLine();
        if (nextAnswer.matches("^y")) {
            System.out.print("New name: ");
            name = scanner.nextLine();
            doggo.setName(name);
        }

        System.out.print("Would you like to change dog's <age>? (y/n): ");
        nextAnswer = scanner.nextLine();
        if (nextAnswer.matches("^y")) {
            System.out.print("New age: ");
            age = Integer.parseInt(scanner.nextLine());
            doggo.setAge(age);
        }

        System.out.println("Your new dog: " + doggo.ToString());
    }
}
