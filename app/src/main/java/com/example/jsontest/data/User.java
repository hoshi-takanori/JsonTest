package com.example.jsontest.data;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

@JsonObject
public class User {
    @JsonField public int id;
    @JsonField public String name;

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": id = " + id + ", name = " + name;
    }
}
