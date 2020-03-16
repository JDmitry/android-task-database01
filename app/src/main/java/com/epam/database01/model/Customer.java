package com.epam.database01.model;

public class Customer {
    private long id;
    private String surname;
    private String firstName;
    private String patronymic;
    private int age;

    public Customer(long id, String surname, String firstName, String patronymic, int age) {
        this.id = id;
        this.surname = surname;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatrymonic() {
        return patronymic;
    }

    public int getAge() {
        return age;
    }
}
