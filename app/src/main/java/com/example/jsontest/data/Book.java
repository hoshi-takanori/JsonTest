package com.example.jsontest.data;

public class Book extends Base {
    public Person author;
    public String title;

    public Book() {
    }

    public Book(int id, Person author, String title) {
        super(id, "book");
        this.author = author;
        this.title = title;
    }

    @Override
    public String toString() {
        return super.toString() + ", author = [" + author + "], title = " + title;
    }
}
