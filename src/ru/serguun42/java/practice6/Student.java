package ru.serguun42.java.practice6;

public class Student implements Comparable<Student> {
    private int idNumber;
    private String name;
    private double GPA;

    public Student() {
        this.idNumber = 0;
        this.name = "";
        this.GPA = 0;
    }

    public Student(int idNumber, String name, double gpa) {
        this.idNumber = idNumber;
        this.name = name;
        this.GPA = gpa;
    }

    @Override
    public String toString() {
        return "Student { idNumber: \"" + idNumber + "\", name: \"" + name + "\", gpa: \"" + GPA + "\" }";
    }

    public double getGPA() {
        return GPA;
    }

    @Override
    public int compareTo(Student other) {
        return (int) ((other.getGPA() - this.getGPA()) * 100);
    }
}
