package com.example.jsontest.data;

public class Person extends Base {
    public String firstName;
    public String lastName;

    public Person() {
    }

    public Person(int id, String firstName, String lastName) {
        super(id, "person");
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return super.toString() + ", firstName = " + firstName + ", lastName = " + lastName;
    }
}
