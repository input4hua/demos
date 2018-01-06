package com.input4hua.PDruidTask.utils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.input4hua.PDruidTask.model.Demo;

import java.io.File;
import java.io.IOException;

/**
 * Created by jiahua.hu on 2018/1/6.
 */
public class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper()
            .configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true)
            .configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);


    public static <T> T readValue(File file, Class<T> tClass){
        T t = null;
        try {
            t = objectMapper.readValue(file, tClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }

    public static <T> T readValue(String source, Class<T> tClass){
        T t = null;
        try {
            t = objectMapper.readValue(source, tClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }

    public static<T> String parseObj2JsonString(T t){
        String jsonString = null;
        try {
            jsonString = objectMapper.writeValueAsString(t);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

}
