package ru.serguun42.java.lab5;

import javax.swing.*;
import java.awt.*;

public class Lab5 extends JFrame {
    int WIDTH = 5;
    int HEIGHT = 4;

    Lab5() {
        super("Lab 5");

        setLayout(new GridLayout(WIDTH, HEIGHT, 20, 20));

        for (int i = 0; i < WIDTH * HEIGHT; i++) {
            Square currentShape = new Square(i % WIDTH, i / WIDTH);

            JPanel panel = new JPanel();
            panel.setBackground(currentShape.color);

            add(panel);
        }

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Lab5();
    }
}