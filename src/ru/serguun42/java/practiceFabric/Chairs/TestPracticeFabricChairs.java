package ru.serguun42.java.practiceFabric.Chairs;

public class TestPracticeFabricChairs {
    public static void main(String[] args) {
        Client client = new Client();
        ChairFactory factory = new ChairFactory();

        client.setChair(factory.createMagicChair());
        client.sit();

        if (client.chair instanceof MagicChair) {
            // This may be a bad practice, dunno yet
            ((MagicChair) client.chair).doMagic();
        }
    }
}
