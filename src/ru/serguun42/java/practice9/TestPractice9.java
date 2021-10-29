package ru.serguun42.java.practice9;

import java.util.Scanner;

public class TestPractice9 {
    public static void main(String[] args) {
        Billing billing = new Billing();

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Input client's name: ");
            String checkingName = scanner.nextLine();
            System.out.print("Input client's TIN: ");
            long checkingINT = Long.parseLong(scanner.nextLine());
            billing.checkTIN(checkingName, checkingINT);

            System.out.println("Billing system successfully validated client.");
        } catch (BillingException e) {
            System.out.println("Handled BillingException");
            System.out.println(e);
        } catch (Exception e) {
            System.out.println("Caught unexpected exception");
            System.out.println(e);
        }
    }
}
