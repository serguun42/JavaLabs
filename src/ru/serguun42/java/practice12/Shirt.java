package ru.serguun42.java.practice12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Shirt {
    final private int code;
    final private String name;
    final private String color;
    final private String size;

    public Shirt(String messyLine) {
        // "S001,Black Polo Shirt,Black,XL",

        Pattern regexForMessyLine = Pattern.compile("^S(?<code>\\d+),(?<name>[^,]+),(?<color>[^,]+),(?<size>[^,]+)$");
        Matcher matcher = regexForMessyLine.matcher(messyLine);

        if (!matcher.matches())
            throw new IllegalArgumentException("Messy line gotta be too messy…");

        this.code = Integer.parseInt(matcher.group("code"));
        this.name = matcher.group("name");
        this.color = matcher.group("color");
        this.size = matcher.group("size");
    }

    public Shirt(int code, String name, String color, String size) {
        this.code = code;
        this.name = name;
        this.color = color;
        this.size = size;
    }

    @Override
    public String toString() {
        //noinspection StringBufferReplaceableByString
        StringBuilder sb = new StringBuilder();

        sb.append("Shirt ");
        sb.append(code);
        sb.append("\nHuman readable name: ");
        sb.append(name);
        sb.append("\nIts color: ");
        sb.append(color);
        sb.append("\nSize: ");
        sb.append(size);

        return sb.toString();
    }
}
