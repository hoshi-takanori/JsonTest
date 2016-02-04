package com.example.jsontest;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

@JsonObject(fieldNamingPolicy = JsonObject.FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
public class FullnameUser extends User {
    @JsonField public String firstName;
    @JsonField public String lastName;

    @Override
    public String toString() {
        return super.toString() + ", firstName = " + firstName + ", lastName = " + lastName;
    }
}
