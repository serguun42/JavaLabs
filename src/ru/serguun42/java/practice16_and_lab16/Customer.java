package ru.serguun42.java.practice16_and_lab16;

final public class Customer {
    final private String firstName;
    final private String secondName;
    final private int age;
    final private Address address;
    final private Customer MATURE_UNKNOWN_CUSTOMER = new Customer("", "", 99, Address.EMPTY_ADDRESS);
    final private Customer NOT_MATURE_UNKNOWN_CUSTOMER = new Customer("", "", 12, Address.EMPTY_ADDRESS);

    public Customer(String firstName, String secondName, int age, Address address) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }
}
