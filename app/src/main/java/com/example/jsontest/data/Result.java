package com.example.jsontest.data;

import java.util.List;

public class Result {
    public boolean success;
    public List<Base> results;

    @Override
    public String toString() {
        if (results == null) {
            return "Result: success = " + success + ", results = " + results;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Result: success = " + success + ", results " + results.size() + "items");
            for (int i = 0; i < results.size(); i++) {
                sb.append("\n[" + i + "] = " + results.get(i));
            }
            return sb.toString();
        }
    }
}
