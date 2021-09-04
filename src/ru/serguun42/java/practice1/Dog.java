package ru.serguun42.java.practice1;

public class Dog {
    private String name;
    private int age;

    public Dog(String _name, int _age) {
        this.name = _name;
        this.age = _age;
    }

    public Dog(String _name) {
        this.name = _name;
        this.age = 42;
    }

    public Dog() {
        this.name = "Doggo";
        this.age = 42;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String convertAgeToHumanLike() {
        return "Dog's age is " + this.age * 7 + " (converted to human form)";
    }

    public String ToString() {
        return "Dog { name: \"" + name + "\", age: \"" + age + "\"}";
    }
}
