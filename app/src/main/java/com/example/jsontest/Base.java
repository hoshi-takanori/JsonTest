package com.example.jsontest;

public class Base {
    public int id;
    public String type;

    public Base() {
    }

    public Base(int id, String type) {
        this.id = id;
        this.type = type;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": id = " + id + ", type = " + type;
    }
}
