package com.thoa.englishTutor.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtil {
    public static <E extends Object, T extends Object> T objectMapper(E object, Class<T> classType){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        try {
            return objectMapper.convertValue(object, classType);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
