package com.example.jsontest;

import com.example.jsontest.data.Base;
import com.example.jsontest.data.Book;
import com.example.jsontest.data.FullnameUser;
import com.example.jsontest.data.Machine;
import com.example.jsontest.data.Person;
import com.example.jsontest.data.Result;
import com.example.jsontest.data.User;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class GsonTest {
    private Gson gson;

    public GsonTest() {
        gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(Base.class, new BaseAdapter())
                .create();
    }

    public String test() {
        StringBuilder sb = new StringBuilder();
        sb.append("test 0\n" + testUser() + "\n\n");
        sb.append("test 1\n" + test1() + "\n\n");
        sb.append("test 2\n" + test2() + "\n\n");
        sb.append("test 3\n" + test3() + "\n\n");
        sb.append("test 4\n" + test4() + "\n\n");
        sb.append("test 5\n" + test5() + "\n\n");
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
        Result result = new Result();
        result.success = true;
        result.results = new ArrayList<>();
        result.results.add(new Base(1, "base"));
        Person person = new Person(2, "takanori", "hoshi");
        result.results.add(person);
        result.results.add(new Machine(3, "apple", "iphone", 600));
        result.results.add(new Book(4, person, "the top secret"));
        return gson.toJson(result);
    }

    public String test5() {
        String json = test4();
        Result result = gson.fromJson(json, Result.class);
        return result.toString();
    }
}
