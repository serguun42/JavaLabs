package ru.serguun42.java.practice1;

public class Dog {
    private String name;
    private int age;

    public Dog(String _name, int _age) {
        name = _name;
        age = _age;
    }

    public Dog(String _name) {
        name = _name;
        age = 42;
    }

    public Dog() {
        name = "Doggo";
        age = 42;
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

    public String ToString() {
        return "Dog { name: \"" + name + "\", age: \"" + age + "\"}";
    }
}
