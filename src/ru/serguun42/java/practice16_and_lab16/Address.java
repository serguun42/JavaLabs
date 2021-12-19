package ru.serguun42.java.practice16_and_lab16;

final public class Address {
    final private String cityName;
    final private int zipCode;
    final private String streetName;
    final private int buildingNumber;
    final private char buildingLetter;
    final private int apartmentNumber;

    final public static Address EMPTY_ADDRESS = new Address("", 0, "", 0, '-', 0);

    public Address(String cityName, int zipCode, String streetName, int buildingNumber, char buildingLetter, int apartmentNumber) {
        this.cityName = cityName;
        this.zipCode = zipCode;
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
        this.buildingLetter = buildingLetter;
        this.apartmentNumber = apartmentNumber;
    }

    public String getCityName() {
        return cityName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public char getBuildingLetter() {
        return buildingLetter;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }
}
