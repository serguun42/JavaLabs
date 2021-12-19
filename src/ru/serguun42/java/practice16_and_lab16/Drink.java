package ru.serguun42.java.practice16_and_lab16;

final public class Drink extends MenuItem implements Alcoholable {
    final private double alcoholVol;
    final private DrinkEnumType type;

    public Drink(String name, String description, DrinkEnumType type) {
        super(name, description);

        this.type = type;
        this.alcoholVol = 0;
    }

    public Drink(String name, String description, DrinkEnumType type, int cost) {
        super(name, description, cost);

        this.type = type;
        this.alcoholVol = 0;
    }

    public Drink(String name, String description, DrinkEnumType type, int cost, double alcoholVol) {
        super(name, description, cost);

        this.type = type;

        if (alcoholVol > 0 && !type.isAlcoholic())
            throw new IllegalArgumentException("Cannot add alcohol into non-alcoholic drink. YOLO");

        this.alcoholVol = alcoholVol;
    }

    @Override
    public double getAlcoholVol() {
        return alcoholVol;
    }

    @Override
    public boolean isAlcoholicDrink() {
        return this.type.isAlcoholic();
    }

    public DrinkEnumType getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + this.getType() + ", " + (this.isAlcoholicDrink() ? "alcoholic" : "non-alcoholic");
    }
}
