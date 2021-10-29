package ru.serguun42.java.practice9;

import java.util.HashMap;

public class Billing {
    // Just `Map` is abstract class
    private final HashMap<String, Long> clients = new HashMap<>();

    public Billing() {
        for (int i = 0; i < 10; i++) {
            StringBuilder clientName = new StringBuilder();

            for (int n = 0; n < 10; n++)
                clientName.append((char) ((n == 0 ? 65 : 97) + 26 * Math.random()));

            /* ИНН – 12 цифр для физ.лиц */
            long clientTIN = (long) Math.floor(Math.random() * 1e13);
            this.clients.put(clientName.toString(), clientTIN);
        }

        this.printClients();
    }

    public void printClients() {
        System.out.println("Shop's clients list:");
        this.clients.forEach((name, tin) -> System.out.println("\tClient: " + name + ", TIN: " + tin));
    }

    public void checkTIN(String clientName, long clientTIN) throws BillingException {
        boolean contains = this.clients.containsKey(clientName);
        if (!contains) throw new BillingExceptionNoSuchClient(clientName);

        long gotINT = this.clients.get(clientName);
        if (gotINT != clientTIN) throw new BillingExceptionMismatch(clientTIN);
    }
}
