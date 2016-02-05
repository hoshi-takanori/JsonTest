package com.example.jsontest.data;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type",
        defaultImpl = Base.class
)
@JsonSubTypes({
        @JsonSubTypes.Type(name = "person", value = Person.class),
        @JsonSubTypes.Type(name = "machine", value = Machine.class),
        @JsonSubTypes.Type(name = "book", value = Book.class)
})
public class Base {
    public int id;
    public String type;

    public Base() {
    }

    public Base(int id, String type) {
        this.id = id;
        this.type = type;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": id = " + id + ", type = " + type;
    }
}
