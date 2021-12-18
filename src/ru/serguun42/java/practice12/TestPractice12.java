package ru.serguun42.java.practice12;

import java.util.ArrayList;

public class TestPractice12 {
    public static String[] SHIRTS_STRINGS_PRESET = {
            "S001,Black Polo Shirt,Black,XL",
            "S002,Black Polo Shirt,Black,L",
            "S003,Blue Polo Shirt,Blue,XL",
            "S004,Blue Polo Shirt,Blue,M",
            "S005,Tan Polo Shirt,Tan,XL",
            "S006,Black T-Shirt,Black,XL",
            "S007,White TShirt,White,XL",
            "S008,White T-Shirt,White,L",
            "S009,Green T-Shirt,Green,S",
            "S010,Orange T-Shirt,Orange,S",
            "S011,Maroon Polo Shirt,Maroon,S"
    };

    public static void main(String[] args) {
        ArrayList<Shirt> allParsedShirts = new ArrayList<>();

        for (String messyShirtLine : SHIRTS_STRINGS_PRESET)
            allParsedShirts.add(new Shirt(messyShirtLine));

        Shirt randomShirt = allParsedShirts.get((int) (Math.random() * allParsedShirts.size()));
        System.out.println("Random shirt: " + randomShirt);
    }
}
