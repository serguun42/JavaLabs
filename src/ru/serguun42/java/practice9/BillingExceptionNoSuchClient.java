package ru.serguun42.java.practice9;

public class BillingExceptionNoSuchClient extends BillingException {
    public BillingExceptionNoSuchClient(String username) {
        super("No such user: " + username);
    }
}
