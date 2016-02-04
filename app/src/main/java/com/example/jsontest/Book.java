package com.example.jsontest;

public class Book extends Base {
    public Person author;
    public String title;

    @Override
    public String toString() {
        return super.toString() + ", author = [" + author + "], title = " + title;
    }
}
