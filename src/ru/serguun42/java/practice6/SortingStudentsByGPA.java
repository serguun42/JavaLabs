package ru.serguun42.java.practice6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortingStudentsByGPA implements Comparator<Student> {
    public void quicksort(ArrayList<Student> students) {
        quicksort(students, 0, students.size() - 1);
    }

    public void quicksort(ArrayList<Student> students, int left, int right) {
        if (left >= right) return;

        /* Hoare's partition start */
        int currentLeft = left;
        int currentRight = right;
        Student pivot = students.get((left + right) / 2);

        do {
            while (compare(students.get(currentLeft), pivot) < 0) ++currentLeft;
            while (compare(students.get(currentRight), pivot) > 0) --currentRight;

            if (currentLeft <= currentRight) {
                swap(students, currentLeft, currentRight);

                ++currentLeft;
                --currentRight;
            }
        } while (currentLeft <= currentRight);
        /* Hoare's partition end */

        quicksort(students, left, currentRight);
        quicksort(students, currentLeft, right);
    }

    public void swap(ArrayList<Student> students, int first, int second) {
        Student temp = students.get(first);
        students.set(first, students.get(second));
        students.set(second, temp);
    }

    @Override
    public int compare(Student first, Student second) {
        return first.compareTo(second);
    }
}
