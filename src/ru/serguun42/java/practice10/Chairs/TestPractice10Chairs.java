package ru.serguun42.java.practice10.Chairs;

public class TestPractice10Chairs {
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
