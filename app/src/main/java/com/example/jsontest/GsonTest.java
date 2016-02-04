package com.example.jsontest;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonTest {
    private Gson gson;

    public GsonTest() {
        gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }

    public String test() {
        StringBuilder sb = new StringBuilder();
        sb.append("test 0\n" + testUser() + "\n\n");
        sb.append("test 1\n" + test1() + "\n\n");
        sb.append("test 2\n" + test2() + "\n\n");
        sb.append("test 3\n" + test3() + "\n\n");
        sb.append("test 4\n" + test4() + "\n\n");
        return sb.toString();
    }

    public User testUser() {
        User user = new User();
        user.id = 123;
        user.name = "hoshi";
        return user;
    }

    public String test1() {
        return gson.toJson(testUser());
    }

    public String test2() {
        String json = "{\"id\":456,\"name\":\"takanori\"}";
        User user = gson.fromJson(json, User.class);
        return json + "\n" + user;
    }

    public String test3() {
        String json = "{\"id\":789,\"first_name\":\"takanori\",\"last_name\":\"hoshi\"}";
        User user = gson.fromJson(json, User.class);
        FullnameUser fullnameUser = gson.fromJson(json, FullnameUser.class);
        return json + "\n" + user + "\n" + fullnameUser;
    }

    public String test4() {
        String json = "{\"success\":true,\"results\":[" +
                "{\"id\":1,\"type\":\"base\"}," +
                "{\"id\":2,\"type\":\"person\",\"firstName\":\"Takanori\",\"lastName\":\"Hoshi\"}," +
                "{\"id\":3,\"type\":\"machine\",\"maker\":\"Apple\",\"name\":\"iPhone\",\"price\":800}," +
                "{\"id\":4,\"type\":\"book\",\"author\":" +
                "{\"id\":2,\"type\":\"person\",\"firstName\":\"Takanori\",\"lastName\":\"Hoshi\"}," +
                "\"title\":\"Top Secret\"}" +
                "]}";
        Result result = gson.fromJson(json, Result.class);
        return json + "\n" + result;
    }
}
