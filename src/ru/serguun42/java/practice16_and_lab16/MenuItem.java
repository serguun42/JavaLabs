package ru.serguun42.java.practice16_and_lab16;

abstract public class MenuItem implements Item {
    final private String name;
    final private String description;
    final private int cost;

    public MenuItem(String name, String description) throws IllegalArgumentException {
        if (name.length() == 0) throw new IllegalArgumentException("Name cannot be empty");
        if (description.length() == 0) throw new IllegalArgumentException("Description cannot be empty");

        this.name = name;
        this.description = description;
        this.cost = ZERO;
    }

    public MenuItem(String name, String description, int cost) throws IllegalArgumentException {
        if (name.length() == 0) throw new IllegalArgumentException("Name cannot be empty");
        if (description.length() == 0) throw new IllegalArgumentException("Description cannot be empty");
        if (cost < 0) throw new IllegalArgumentException("Cost cannot be negative");

        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + name + ", " + description + ", cost: " + cost;
    }

    public static void quicksort(MenuItem[] itemsToSort, int left, int right) {
        if (left >= right) return;

        /** @see ru.serguun42.java.practice6.SortingStudentsByGPA – same quicksort is there */
        /* Hoare's partition start */
        int currentLeft = left;
        int currentRight = right;
        MenuItem pivot = itemsToSort[(left + right) / 2];

        do {
            while (itemsToSort[currentLeft].getCost() > pivot.getCost()) ++currentLeft; // Descending
            while (itemsToSort[currentRight].getCost() < pivot.getCost()) --currentRight; // Descending

            if (currentLeft <= currentRight) {
                MenuItem temp = itemsToSort[currentLeft];
                itemsToSort[currentLeft] = itemsToSort[currentRight];
                itemsToSort[currentRight] = temp;

                ++currentLeft;
                --currentRight;
            }
        } while (currentLeft <= currentRight);
        /* Hoare's partition end */

        quicksort(itemsToSort, left, currentRight);
        quicksort(itemsToSort, currentLeft, right);
    }
}
