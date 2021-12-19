package ru.serguun42.java.practice16_and_lab16;

public enum DrinkEnumType {
    WATER(),
    BEER(true),
    WINE(true),
    VODKA(true),
    BRANDY(true),
    CHAMPAGNE(true),
    WHISKEY(true),
    RUM(true),
    JUICE(),
    COFFEE(),
    GREEN_TEA(),
    BLACK_TEA();

    private final boolean alcoholic;

    DrinkEnumType() {
        this.alcoholic = false;
    }

    DrinkEnumType(boolean alcoholic) {
        this.alcoholic = alcoholic;
    }

    public boolean isAlcoholic() {
        return alcoholic;
    }
}
