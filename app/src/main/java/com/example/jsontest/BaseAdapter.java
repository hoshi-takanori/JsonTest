package com.example.jsontest;

import com.example.jsontest.data.Base;
import com.example.jsontest.data.Book;
import com.example.jsontest.data.Machine;
import com.example.jsontest.data.Person;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BaseAdapter extends TypeAdapter<Base> {
    private Gson gson;
    private Map<String, Class<? extends Base>> typeMap;

    public BaseAdapter() {
        gson = new Gson();
        typeMap = new HashMap<>();
        typeMap.put("person", Person.class);
        typeMap.put("machine", Machine.class);
        typeMap.put("book", Book.class);
    }

    @Override
    public Base read(JsonReader in) throws IOException {
        JsonObject object = gson.fromJson(in, JsonObject.class);
        Class<? extends Base> type = typeMap.get(object.get("type").getAsString());
        return gson.fromJson(object, type != null ? type : Base.class);
    }

    @Override
    public void write(JsonWriter out, Base value) throws IOException {
        Class type = value != null ? value.getClass() : Base.class;
        gson.toJson(value, type, out);
    }
}
