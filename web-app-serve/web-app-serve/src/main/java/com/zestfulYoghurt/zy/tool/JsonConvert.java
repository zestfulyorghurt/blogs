package com.zestfulYoghurt.zy.tool;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConvert {

    //将对象转换为json字符串
    public static String ObjectToJson(Object object){
        String JsonString = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonString = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return JsonString;
    }

    //将json字符串转换为json
    public static Object JsonToObject(String jsonString){
        Object object = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            object = objectMapper.readValue(jsonString, Object.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return object;
    }


}
