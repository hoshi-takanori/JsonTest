package com.example.jsontest;

public class Person extends Base {
    public String firstName;
    public String lastName;

    @Override
    public String toString() {
        return super.toString() + ", firstName = " + firstName + ", lastName = " + lastName;
    }
}
