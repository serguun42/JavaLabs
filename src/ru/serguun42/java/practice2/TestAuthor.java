package ru.serguun42.java.practice2;

import java.util.Scanner;

public class TestAuthor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Let's create new author! Input their name: ");
        String name = scanner.nextLine();
        if (name.isEmpty()) {
            System.out.println("Name can't be empty");
            return;
        }

        System.out.print("Now input email: ");
        String email = scanner.nextLine();
        if (email.isEmpty()) {
            System.out.println("Email can't be empty");
            return;
        }

        System.out.print("And gender (Male/Female): ");
        char gender = scanner.nextLine().charAt(0);
        if (gender != 'M' && gender != 'F')
                gender = 'U';

        Author authy = new Author(name, email, gender);

        System.out.println("Your newly created author: " + authy.toString());
    }
}
