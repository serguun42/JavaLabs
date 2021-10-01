package ru.serguun42.java.lab7;

import java.util.Comparator;

public class Lab7Comparator implements Comparator<String> {
    @Override
    public int compare(String first, String second) {
        return second.length() - first.length();
    }
}
