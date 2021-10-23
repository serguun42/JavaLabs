package ru.serguun42.java.practice8;

import java.util.Arrays;
import java.util.Collection;

public class TestPractice8 {
    public static void main(String[] args) {
        Collection<Integer> marksToJournal = Arrays.asList(5, 5, 9001, 5, 3, 2, 3, 4, 5);

        BoundedWaitList<Integer> waitingListForJournal = new BoundedWaitList<>(marksToJournal.size());
        marksToJournal.forEach(waitingListForJournal::add);
        System.out.println(waitingListForJournal);

        UnfairWaitList<Integer> betterWaitingList = new UnfairWaitList<>();
        marksToJournal.forEach(betterWaitingList::add);

        betterWaitingList.moveToBack(9001);
        betterWaitingList.remove(2);

        System.out.println(betterWaitingList);
        System.out.println("betterWaitingList contains any '2': " + betterWaitingList.contains(2));
    }
}
