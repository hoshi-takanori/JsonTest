package com.example.jsontest;

public class Machine extends Base {
    public String maker;
    public String name;
    public int price;

    public Machine() {
    }

    public Machine(int id, String maker, String name, int price) {
        super(id, "machine");
        this.maker = maker;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return super.toString() + ", maker = " + maker + ", name = " + name + ", price = " + price;
    }
}
