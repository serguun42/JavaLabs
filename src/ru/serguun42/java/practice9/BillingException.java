package ru.serguun42.java.practice9;

public class BillingException extends Exception {
    public BillingException(String message) {
        super("Billing exception: " + message);
    }
}
