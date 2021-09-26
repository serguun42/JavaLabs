package ru.serguun42.java.practice6;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class TestPractice6 {
    public static void main(String[] args) {
        ArrayList<Student> myStudents = new ArrayList<Student>();

        for (int i = 0; i < 10; i++) {
            int id = (int) (1e5 * Math.random());
            StringBuilder name = new StringBuilder();
            for (int n = 0; n < 10; n++)
                name.append((char) ((n == 0 ? 65 : 97) + 26 * Math.random()));
            double gpa = (double)(Math.round(Math.random() * 100)) * 3 / 100 + 2;

            myStudents.add(new Student(id, name.toString(), gpa));
        }

        new SortingStudentsByGPA().quicksort(myStudents);

        System.out.println(myStudents.stream().map(Student::toString).collect(Collectors.joining("\n")));
    }
}
