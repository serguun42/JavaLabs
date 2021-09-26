package ru.serguun42.java.lab6;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Lab6 extends JFrame {
    protected Font defaultFont = new Font("Roboto", Font.PLAIN, 14);
    protected JTextField textField = new JTextField();
    protected JButton button = new JButton();
    protected JLabel labelAsk = new JLabel();

    protected int numToGuess = 0;
    protected int userNum = 0;
    protected int triesLeft = 3;
    protected boolean ended = false;

    protected static String ASK_S = "Guess what the number is (between 0 and 20)";
    protected static String BUTTON_INIT_S = "Make the guess";
    protected static String RESULT_LEFT_S = "You have __TRIES__ tries left";
    protected static String RESULT_LOST_S = "You lost. Number was __NUM__";
    protected static String RESULT_WON_S = "You won!";

    Lab6() {
        super("Lab 6");

        numToGuess = 1 + (int)(Math.random() * 20);

        labelAsk.setFont(defaultFont);
        textField.setFont(defaultFont);
        button.setFont(defaultFont);

        labelAsk.setText(ASK_S);
        textField.setText("1");
        button.setText(BUTTON_INIT_S);

        this.setLayout(new BorderLayout());

        JPanel centerPan = new JPanel();
        this.add(centerPan, BorderLayout.CENTER);
        centerPan.setLayout(new BoxLayout(centerPan, BoxLayout.Y_AXIS));
        centerPan.setBorder(new EmptyBorder(24, 24, 24, 24));


        centerPan.add(labelAsk);
        centerPan.add(textField);
        centerPan.add(button);

        button.addActionListener((e) -> buttonOnClick());

        this.setSize(400, 200);
        this.setVisible(true);
    }

    private void buttonOnClick() {
        if (ended) return;

        userNum = Integer.parseInt(textField.getText());

        if (userNum == numToGuess) {
            ended = true;
        } else {
            --triesLeft;

            if (triesLeft <= 0) ended = true;
        }

        updateButtonText();
    }

    private void updateButtonText() {
        if (userNum == numToGuess)
            button.setText(RESULT_WON_S);
        else if (triesLeft > 0)
            button.setText(RESULT_LEFT_S.replace("__TRIES__", String.format("%d", triesLeft)));
        else
            button.setText(RESULT_LOST_S.replace("__NUM__", String.format("%d", numToGuess)));
    }

    public static void main(String[] args) {
        new Lab6();
    }
}
