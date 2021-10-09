package ru.serguun42.java.practice7;

import java.util.*;
import java.util.stream.Collectors;

public class Game {
    private Queue<Integer> first = new LinkedList<Integer>();
    private Queue<Integer> second = new LinkedList<Integer>();
    private int stepsDone = 0;

    private void fillOnStart() {
        System.out.print("What should initial set of cards be: random or tweaked-preset? (Type r/ran/random for first option): ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().matches("^r(an(dom)?)?")) {
            for (int i = 0; i < 10; i++) {
                if (this.first.size() == 5)
                    this.second.add(i);
                else if (this.second.size() == 5)
                    this.first.add(i);
                else
                    (Math.random() < 0.5 ? this.first : this.second).add(i);
            }
        } else {
            this.first.addAll(Arrays.asList(1, 3, 5, 7, 9));
            this.second.addAll(Arrays.asList(2, 4, 6, 8, 0));
        }
    }

    private void playStep() {
        ++this.stepsDone;

        int fromFirst = this.first.remove();
        int fromSecond = this.second.remove();

        if (fromFirst >= fromSecond) {
            this.first.add(fromFirst);
            this.first.add(fromSecond);
        } else {
            this.second.add(fromSecond);
            this.second.add(fromFirst);
        }

        if (this.first.size() == 0)
            System.out.println("Second player won in " + this.stepsDone + " steps");
        else if (this.second.size() == 0)
            System.out.println("First player won in " + this.stepsDone + " steps");
        else if (this.stepsDone >= 106)
            System.out.println("Botva");
        else
            this.playStep();
    }

    public void display() {
        System.out.println("Here's current game position:");
        System.out.println("First player:");
        System.out.println(this.first.stream().map(Object::toString).collect(Collectors.joining(" ")));
        System.out.println("Second player:");
        System.out.println(this.second.stream().map(Object::toString).collect(Collectors.joining(" ")));
        System.out.println("---------------------------");
    }

    Game() {
        this.fillOnStart();
        this.display();
        this.playStep();
    }
}
