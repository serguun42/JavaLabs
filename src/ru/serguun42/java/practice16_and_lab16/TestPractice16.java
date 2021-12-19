package ru.serguun42.java.practice16_and_lab16;

public class TestPractice16 {
    public static final String DIVIDER = "\n----------------------------------\n";

    public static void main(String[] args) {
//        Order order = new TableOrder(5);

        Order order = new InternetOrder();

        Drink water = new Drink("Water", "Much wet", DrinkEnumType.WATER);
        Dish pelmeni = new Dish("Pelmeni", "Really hot", 5);
        Drink brandy = new Drink("One shot", "37.5%", DrinkEnumType.BRANDY, 9, 37.5);
        Dish pizza = new Dish("Pizza", "So round!", 20);
        Drink blackTea = new Drink("Tea", "So tasty", DrinkEnumType.BLACK_TEA, 2);

        order.add(water);
        order.add(pelmeni);
        order.add(brandy);
        order.add(pizza);
        order.add(blackTea);

        if (!order.add(blackTea)) {
            System.out.println(DIVIDER + "Cannot add 6th position to order of 5 items/dishes/whatever @ TableOrder");
        }

        System.out.println(DIVIDER + "As is:");

        for (MenuItem item : order.getItems())
            System.out.println(item);

        System.out.println(DIVIDER + "Sorted by cost (descending):");

        for (MenuItem item : order.sortedItemsByCostDesc())
            System.out.println(item);

        System.out.println("Total cost: $" + order.costTotal());

        order.remove("Pelmeni");
        System.out.println(DIVIDER + "Removed Pelmeni, new total cost: $" + order.costTotal());

        System.out.println("As is:");

        for (MenuItem item : order.getItems())
            System.out.println(item);



        InternetOrdersManager manager = new InternetOrdersManager();
        manager.add(order);
        manager.add(order);


        System.out.println(DIVIDER + "Manager's first order's first item:\n\t" + manager.remove().getItems()[0]);
    }
}
