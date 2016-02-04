package com.example.jsontest;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import java.io.IOException;
import java.util.ArrayList;

public class JacksonTest {
    private ObjectMapper mapper;

    public JacksonTest() {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
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
        try {
            return mapper.writeValueAsString(testUser());
        } catch (IOException e) {
            return e.toString();
        }
    }

    public String test2() {
        String json = "{\"id\":456,\"name\":\"takanori\"}";
        try {
            User user = mapper.readValue(json, User.class);
            return json + "\n" + user;
        } catch (IOException e) {
            return e.toString();
        }
    }

    public String test3() {
        String json = "{\"id\":789,\"first_name\":\"takanori\",\"last_name\":\"hoshi\"}";
        try {
            User user = mapper.readValue(json, User.class);
            FullnameUser fullnameUser = mapper.readValue(json, FullnameUser.class);
            return json + "\n" + user + "\n" + fullnameUser;
        } catch (IOException e) {
            return e.toString();
        }
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
        try {
            return mapper.writeValueAsString(result);
        } catch (IOException e) {
            return e.toString();
        }
    }

    public String test5() {
        String json = test4();
        try {
            Result result = mapper.readValue(json, Result.class);
            return result.toString();
        } catch (IOException e) {
            return e.toString();
        }
    }
}
