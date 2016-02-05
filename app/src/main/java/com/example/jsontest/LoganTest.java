package com.example.jsontest;

import com.bluelinelabs.logansquare.LoganSquare;
import com.example.jsontest.data.FullnameUser;
import com.example.jsontest.data.User;

import java.io.IOException;

public class LoganTest {
    public String test() {
        StringBuilder sb = new StringBuilder();
        sb.append("test 0\n" + testUser() + "\n\n");
        sb.append("test 1\n" + test1() + "\n\n");
        sb.append("test 2\n" + test2() + "\n\n");
        sb.append("test 3\n" + test3() + "\n\n");
        return sb.toString();
    }

    public User testUser() {
        User user = new User();
        user.id = 123;
        user.name = "hoshi";
        return user;
    }

    public String test1() {
        try {
            return LoganSquare.serialize(testUser());
        } catch (IOException e) {
            return e.toString();
        }
    }

    public String test2() {
        String json = "{\"id\":456,\"name\":\"takanori\"}";
        try {
            User user = LoganSquare.parse(json, User.class);
            return json + "\n" + user;
        } catch (IOException e) {
            return e.toString();
        }
    }

    public String test3() {
        String json = "{\"id\":789,\"first_name\":\"takanori\",\"last_name\":\"hoshi\"}";
        try {
            User user = LoganSquare.parse(json, User.class);
            FullnameUser fullnameUser = LoganSquare.parse(json, FullnameUser.class);
            return json + "\n" + user + "\n" + fullnameUser;
        } catch (IOException e) {
            return e.toString();
        }
    }
}
