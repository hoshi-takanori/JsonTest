package com.example.jsontest;

public class Machine extends Base {
    public String maker;
    public String name;
    public int price;

    @Override
    public String toString() {
        return super.toString() + ", maker = " + maker + ", name = " + name + ", price = " + price;
    }
}
