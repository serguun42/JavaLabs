package ru.serguun42.java.practice16_and_lab16;

public class TableOrder implements Order {
    final private int size;
    final private MenuItem[] items;
    private Customer customer;

    public TableOrder() {
        this.size = 100;
        this.items = new MenuItem[this.size];
    }

    public TableOrder(int size) {
        this.size = size;
        this.items = new MenuItem[this.size];
    }

    @Override
    public boolean add(MenuItem item) {
        int availablePosition = 0;

        while (availablePosition < this.size && this.items[availablePosition] != null)
            ++availablePosition;

        if (availablePosition >= this.size)
            return false;

        this.items[availablePosition] = item;
        return true;
    }

    @Override
    public String[] itemsNames() {
        int position = 0;
        MenuItem[] filteredItems = this.getItems();
        String[] names = new String[filteredItems.length];

        for (MenuItem currentItem : filteredItems)
            names[position++] = currentItem.getName();

        return names;
    }

    @Override
    public int itemsQuantity() {
        int quantity = 0;

        for (MenuItem currentItem : this.items)
            if (currentItem != null)
                ++quantity;

        return quantity;
    }

    @Override
    public int itemQuantity(String itemName) {
        int quantity = 0;

        for (MenuItem currentItem : this.items)
            if (currentItem != null && itemName.equals(currentItem.getName()))
                ++quantity;

        return quantity;
    }

    @Override
    public int itemQuantity(MenuItem item) {
        int quantity = 0;

        for (MenuItem currentItem : this.items)
            if (currentItem.equals(item))
                ++quantity;

        return quantity;
    }

    /** Only filtered ones (not NULL) */
    @Override
    public MenuItem[] getItems() {
        int position = 0;
        MenuItem[] returningItems = new MenuItem[this.itemsQuantity()];

        for (MenuItem currentItem : this.items)
            if (currentItem != null)
                returningItems[position++] = currentItem;

        return returningItems;
    }

    @Override
    public boolean remove(String itemName) {
        int indexToRemove = -1;

        for (int i = 0; i < this.size; i++) {
            MenuItem currentItem = this.items[i];

            if (currentItem != null && itemName.equals(currentItem.getName()))
                indexToRemove = i;
        }

        if (indexToRemove > -1)
            this.items[indexToRemove] = null;

        return indexToRemove > -1;
    }

    @Override
    public boolean remove(MenuItem item) {
        int indexToRemove = -1;

        for (int i = 0; i < this.size; i++) {
            MenuItem currentItem = this.items[i];

            if (item.equals(currentItem))
                indexToRemove = i;
        }

        if (indexToRemove > -1)
            this.items[indexToRemove] = null;

        return indexToRemove > -1;
    }

    @Override
    public int removeAll(String itemName) {
        int removedCount = 0;

        for (int i = 0; i < this.size; i++) {
            MenuItem currentItem = this.items[i];

            if (currentItem != null && itemName.equals(currentItem.getName())) {
                this.items[i] = null;
                ++removedCount;
            }
        }

        return removedCount;
    }

    @Override
    public int removeAll(MenuItem item) {
        int removedCount = 0;

        for (int i = 0; i < this.size; i++) {
            MenuItem currentItem = this.items[i];

            if (item.equals(currentItem)) {
                this.items[i] = null;
                ++removedCount;
            }
        }

        return removedCount;
    }

    @Override
    public MenuItem[] sortedItemsByCostDesc() {
        int position = 0;
        MenuItem[] filteredItems = this.getItems();
        MenuItem[] sortedItems = new MenuItem[filteredItems.length];

        for (MenuItem currentItem : filteredItems)
            sortedItems[position++] = currentItem;

        MenuItem.quicksort(sortedItems, 0, filteredItems.length - 1);

        return sortedItems;
    }

    @Override
    public int costTotal() {
        int totalCost = 0;

        for (MenuItem currentItem : this.items)
            if (currentItem != null)
                totalCost += currentItem.getCost();

        return totalCost;
    }

    @Override
    public Customer getCustomer() {
        return this.customer;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
