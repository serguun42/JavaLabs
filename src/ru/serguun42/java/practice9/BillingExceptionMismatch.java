package ru.serguun42.java.practice9;

public class BillingExceptionMismatch extends BillingException {
    public BillingExceptionMismatch(long clientTIN) {
        super("Given TIN (" + clientTIN + ") is not correct");
    }
}
