package com.example.jsontest;

public class Base {
    public int id;
    public String type;

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": id = " + id + ", type = " + type;
    }
}
