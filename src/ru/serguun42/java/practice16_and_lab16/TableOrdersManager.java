package ru.serguun42.java.practice16_and_lab16;

public class TableOrdersManager implements OrdersManager {
    private Order[] orders = new Order[100];

    @Override
    public int itemsQuantity(String itemName) {
        int totalQuantity = 0;

        for (Order order : this.orders)
            if (order != null)
                totalQuantity += order.itemQuantity(itemName);

        return totalQuantity;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        int totalQuantity = 0;

        for (Order order : this.orders)
            if (order != null)
                totalQuantity += order.itemQuantity(item);

        return totalQuantity;
    }

    @Override
    public int ordersQuantity() {
        int quantity = 0;

        for (Order order : this.orders)
            if (order != null)
                ++quantity;

        return quantity;
    }

    @Override
    public int ordersCostSummary() {
        int costSummary = 0;

        for (Order order : this.orders)
            if (order != null)
                costSummary += order.costTotal();

        return costSummary;
    }

    @Override
    public Order[] getOrders() {
        Order[] returningOrders = new Order[this.ordersQuantity()];
        int position = 0;

        for (Order order : this.orders)
            if (order != null)
                returningOrders[position++] = order;

        return returningOrders;
    }

    public void add(Order order, int tableNumber) {
        if (this.orders[tableNumber] == null)
            this.orders[tableNumber] = order;
    }

    public void addItem(MenuItem item, int tableNumber) {
        if (this.orders[tableNumber] == null) return;

        this.orders[tableNumber].add(item);
    }

    public int freeTableNumber() {
        int quantity = 0;

        for (Order order : this.orders)
            if (order == null)
                ++quantity;

        return quantity;
    }

    public int[] freeTableNumbers() {
        int[] freeTables = new int[this.orders.length - this.ordersQuantity()];
        int position = 0;

        for (int i = 0; i < this.orders.length; i++)
            if (this.orders[i] == null)
                freeTables[position++] = i;

        return freeTables;
    }

    public Order getOrder(int tableNumber) {
        return this.orders[tableNumber];
    }

    public void remove(int tableNumber) {
        this.orders[tableNumber] = null;
    }

    public int remove(Order order) {
        int removedIndex = -1;

        for (int i = 0; i < this.orders.length; i++) {
            if (removedIndex < 0 && order.equals(this.orders[i])) {
                this.orders[i] = null;
                removedIndex = i;
            }
        }

        return removedIndex;
    }

    public int removeAll(Order order) {
        int removedCount = 0;

        for (int i = 0; i < this.orders.length; i++) {
            if (order.equals(this.orders[i])) {
                this.orders[i] = null;
                ++removedCount;
            }
        }

        return removedCount;
    }
}
