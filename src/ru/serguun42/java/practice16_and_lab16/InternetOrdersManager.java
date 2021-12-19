package ru.serguun42.java.practice16_and_lab16;

public class InternetOrdersManager implements OrdersManager {
    private QueueNode head;
    private QueueNode tail;
    private int size;

    InternetOrdersManager() {
        this.size = 0;
    }

    @Override
    public int itemsQuantity(String itemName) {
        int totalQuantity = 0;

        QueueNode lastNode = this.head;

        while (lastNode != null) {
            totalQuantity += lastNode.value.itemQuantity(itemName);
            lastNode = lastNode.next;
        }

        return totalQuantity;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        int totalQuantity = 0;

        QueueNode lastNode = this.head;

        while (lastNode != null) {
            totalQuantity += lastNode.value.itemQuantity(item);
            lastNode = lastNode.next;
        }

        return totalQuantity;
    }

    @Override
    public int ordersQuantity() {
        return this.size;
    }

    @Override
    public int ordersCostSummary() {
        int costSummary = 0;

        QueueNode lastNode = this.head;

        while (lastNode != null) {
            costSummary += lastNode.value.costTotal();
            lastNode = lastNode.next;
        }

        return costSummary;
    }

    @Override
    public Order[] getOrders() {
        Order[] returningOrders = new Order[this.size];
        int position = 0;

        QueueNode lastNode = this.head;

        while (lastNode != null) {
            returningOrders[position++] = lastNode.value;
            lastNode = lastNode.next;
        }

        return returningOrders;
    }

    public boolean add(Order order) {
        QueueNode newListNode = new QueueNode(order);

        if (this.head == null) this.head = newListNode;
        if (this.tail != null) this.tail.next = newListNode;
        this.tail = newListNode;

        ++this.size;
        return true;
    }

    public Order remove() {
        if (this.head == null) return null;

        Order returningHeadOrder = this.head.value;
        this.head = this.head.next;

        return returningHeadOrder;
    }

    public Order order() {
        return (this.head != null ? this.head.value : null);
    }
}
