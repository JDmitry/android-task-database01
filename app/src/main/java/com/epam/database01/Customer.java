package com.epam.database01;

public class Customer {
    private int id;
    private String surname;
    private String firstName;
    private String patrymonic;
    private int age;

    public Customer(int id, String surname, String firstName, String patrymonic, int age) {
        this.id = id;
        this.surname = surname;
        this.firstName = firstName;
        this.patrymonic = patrymonic;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatrymonic() {
        return patrymonic;
    }

    public int getAge() {
        return age;
    }
}
