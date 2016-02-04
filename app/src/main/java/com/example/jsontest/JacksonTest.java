package com.example.jsontest;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import java.io.IOException;

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
        try {
            String json = "{\"id\":456,\"name\":\"takanori\"}";
            User user = mapper.readValue(json, User.class);
            return json + "\n" + user;
        } catch (IOException e) {
            return e.toString();
        }
    }

    public String test3() {
        try {
            String json = "{\"id\":789,\"first_name\":\"takanori\",\"last_name\":\"hoshi\"}";
            User user = mapper.readValue(json, User.class);
            FullnameUser fullnameUser = mapper.readValue(json, FullnameUser.class);
            return json + "\n" + user + "\n" + fullnameUser;
        } catch (IOException e) {
            return e.toString();
        }
    }
}
