package org.myCompany.utils;

import com.google.gson.Gson;

public class JSONUtil {
    private static final Gson gson = new Gson();

    public static <T> T fromJson(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }
}

