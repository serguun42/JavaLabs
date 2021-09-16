package ru.serguun42.java.practice4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

enum TEAMS { NA, LEFT, RIGHT };

class GUIMain extends JFrame {
    Font defaultFont = new Font("Roboto", Font.PLAIN, 14);

    JButton buttonLeft = new JButton();
    JButton buttonRight = new JButton();
    JLabel labelResult = new JLabel();
    JLabel labelLast = new JLabel();
    JLabel labelWinner = new JLabel();

    int leftScore = 0;
    int rightScore = 0;
    TEAMS lastScore;

    String buttonLeftValue = "AC Milan";
    String buttonRightValue = "Real Madrid";

    protected String labelResultValue() {
        return "Result: " + leftScore + " X " + rightScore;
    }

    protected String labelLastValue() {
        return "Last Scorer: " + (lastScore == TEAMS.LEFT ? buttonLeftValue : (lastScore == TEAMS.RIGHT ? buttonRightValue : "N/A"));
    }

    protected String labelWinnerValue() {
        return "Winner: " + (leftScore > rightScore ? buttonLeftValue : (rightScore > leftScore ? buttonRightValue : "DRAW"));
    }

    protected void updateLabels() {
        this.labelResult.setText(this.labelResultValue());
        this.labelLast.setText(this.labelLastValue());
        this.labelWinner.setText(this.labelWinnerValue());
    }

    protected void updateTeam(TEAMS team) {
        if (team == TEAMS.LEFT)
            ++leftScore;
        else if (team == TEAMS.RIGHT)
            ++rightScore;

        lastScore = team;

        updateLabels();
    }

    GUIMain() {
        super("Practice 4");

        setLayout(new BorderLayout());

        JPanel centerPan = new JPanel();
        getContentPane().add(centerPan, BorderLayout.CENTER);

        GridBagLayout gridBagLayout = new GridBagLayout();
        centerPan.setLayout(gridBagLayout);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;


        buttonLeft.setText(buttonLeftValue);
        buttonLeft.setFont(defaultFont);
        buttonLeft.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                updateTeam(TEAMS.LEFT);
            }

            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });
        centerPan.add(buttonLeft, gridBagConstraints);

        buttonRight.setText(buttonRightValue);
        buttonRight.setFont(defaultFont);
        buttonRight.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                updateTeam(TEAMS.RIGHT);
            }

            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });
        gridBagConstraints.gridx = 1;
        centerPan.add(buttonRight, gridBagConstraints);

        labelResult.setFont(defaultFont);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        centerPan.add(labelResult, gridBagConstraints);

        labelLast.setFont(defaultFont);
        gridBagConstraints.gridx = 1;
        centerPan.add(labelLast, gridBagConstraints);

        labelWinner.setFont(defaultFont);
        labelWinner.setHorizontalAlignment(JLabel.CENTER);
        labelWinner.setForeground(new Color(255, 100, 100));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth *= 2;
        centerPan.add(labelWinner, gridBagConstraints);

        updateLabels();


        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GUIMain();
    }
}
