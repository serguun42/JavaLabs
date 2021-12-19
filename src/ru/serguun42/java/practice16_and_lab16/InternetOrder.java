package ru.serguun42.java.practice16_and_lab16;

public class InternetOrder implements Order {
    private int size;
    private ListNode head;
    private ListNode tail;
    private Customer customer;

    public InternetOrder() {
        this.size = 0;
    }

    @Override
    public boolean add(MenuItem item) {
        ListNode newListNode = new ListNode(item);

        if (this.head == null) this.head = newListNode;
        if (this.tail != null) this.tail.next = newListNode;
        this.tail = newListNode;

        ++this.size;
        return true;
    }

    @Override
    public String[] itemsNames() {
        String[] names = new String[this.size];
        int position = 0;
        ListNode lastNode = this.head;

        while (lastNode != null) {
            names[position++] = lastNode.value.getName();
            lastNode = lastNode.next;
        }

        return names;
    }

    @Override
    public int itemsQuantity() {
        return this.size;
    }

    @Override
    public int itemQuantity(String itemName) {
        int quantity = 0;
        ListNode lastNode = this.head;

        while (lastNode != null) {
            if (lastNode.value.getName().equals(itemName))
                ++quantity;

            lastNode = lastNode.next;
        }

        return quantity;
    }

    @Override
    public int itemQuantity(MenuItem item) {
        int quantity = 0;
        ListNode lastNode = this.head;

        while (lastNode != null) {
            if (item.equals(lastNode.value))
                ++quantity;

            lastNode = lastNode.next;
        }

        return quantity;
    }

    /** Only filtered ones (not NULL) */
    @Override
    public MenuItem[] getItems() {
        int position = 0;
        MenuItem[] returningItems = new MenuItem[this.size];

        ListNode lastNode = this.head;

        while (lastNode != null) {
            returningItems[position++] = lastNode.value;
            lastNode = lastNode.next;
        }

        return returningItems;
    }

    @Override
    public boolean remove(String itemName) {
        boolean removedFlag = false;

        ListNode lastNode = new ListNode(null);
        lastNode.next = this.head;
        ListNode nextNode;

        while (lastNode != null) {
            nextNode = lastNode.next;

            if (
                    !removedFlag &&
                    nextNode != null &&
                    nextNode.value != null &&
                    nextNode.value.getName().equals(itemName)
            ) {
                if (nextNode.equals(this.head)) this.head = nextNode.next;
                if (nextNode.equals(this.tail)) this.tail = lastNode;
                nextNode.value = null;
                lastNode.next = nextNode.next;
                --this.size;
                removedFlag = true;
            } else {
                lastNode = lastNode.next;
            }
        }

        return removedFlag;
    }

    @Override
    public boolean remove(MenuItem item) {
        boolean removedFlag = false;

        ListNode lastNode = new ListNode(null);
        lastNode.next = this.head;
        ListNode nextNode;

        while (lastNode != null) {
            nextNode = lastNode.next;

            if (!removedFlag && nextNode != null && item.equals(nextNode.value)) {
                if (nextNode.equals(this.head)) this.head = nextNode.next;
                if (nextNode.equals(this.tail)) this.tail = lastNode;
                nextNode.value = null;
                lastNode.next = nextNode.next;
                --this.size;
                removedFlag = true;
            } else {
                lastNode = lastNode.next;
            }
        }

        return removedFlag;
    }

    @Override
    public int removeAll(String itemName) {
        int removedCount = 0;

        ListNode lastNode = new ListNode(null);
        lastNode.next = this.head;
        ListNode nextNode;

        while (lastNode != null) {
            nextNode = lastNode.next;

            if (nextNode != null && nextNode.value != null && nextNode.value.getName().equals(itemName)) {
                if (nextNode.equals(this.head)) this.head = nextNode.next;
                if (nextNode.equals(this.tail)) this.tail = lastNode;
                nextNode.value = null;
                lastNode.next = nextNode.next;
                --this.size;
                ++removedCount;
            } else {
                lastNode = lastNode.next;
            }
        }

        return removedCount;
    }

    @Override
    public int removeAll(MenuItem item) {
        int removedCount = 0;

        ListNode lastNode = new ListNode(null);
        lastNode.next = this.head;
        ListNode nextNode;

        while (lastNode != null) {
            nextNode = lastNode.next;

            if (nextNode != null && item.equals(nextNode.value)) {
                if (nextNode.equals(this.head)) this.head = nextNode.next;
                if (nextNode.equals(this.tail)) this.tail = lastNode;
                nextNode.value = null;
                lastNode.next = nextNode.next;
                --this.size;
                ++removedCount;
            } else {
                lastNode = lastNode.next;
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

        ListNode lastNode = this.head;

        while (lastNode != null) {
            totalCost += lastNode.value.getCost();
            lastNode = lastNode.next;
        }

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
