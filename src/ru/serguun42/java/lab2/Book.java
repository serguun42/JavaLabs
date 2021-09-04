package ru.serguun42.java.lab2;

public class Book {
    private String name;
    private String author;
    private int year;
    private String genre;

    public Book(String name, String author, int year, String genre) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.genre = genre;
    }

    public Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.genre = "Unset";
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
        this.year = 0;
        this.genre = "Unset";
    }

    public Book(String name) {
        this.name = name;
        this.author = "Unset";
        this.year = 0;
        this.genre = "Unset";
    }

    public Book() {
        this.name = "Unset";
        this.author = "Unset";
        this.year = 0;
        this.genre = "Unset";
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Presenting you the book! { name: \"" + name + "\", author: \"" + author + "\", year: \"" + year + "\", genre: \"" + genre + "\" }";
    }
}
