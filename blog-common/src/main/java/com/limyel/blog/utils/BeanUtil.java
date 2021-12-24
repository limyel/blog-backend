package com.limyel.blog.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanUtil {

    public static <T> T copy(Object source, Class<T> clazz) {
        if (source == null) {
            return null;
        }
        T obj = null;
        try {
            obj = clazz.getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        BeanUtils.copyProperties(source, obj);
        return obj;
    }

    public static <T> List<T> copyList(List source, Class<T> clazz) {
        List<T> target = new ArrayList<>();
        if (!CollectionUtils.isEmpty(source)) {
            for (Object c: source) {
                T obj = copy(c, clazz);
                target.add(obj);
            }
        }
        return target;
    }

    public static <T> void cover(Object source, T target) {
        Field[] sourceFields = source.getClass().getDeclaredFields();
        Field[] targetFields = target.getClass().getDeclaredFields();

        Map<String, Field> map = new HashMap<>();
        for (Field targetField: targetFields) {
            map.put(targetField.getName(), targetField);
        }
        for (Field sourceField: sourceFields) {
            if (map.get(sourceField.getName()) != null && sourceField.getType().equals(map.get(sourceField.getName()).getType())) {
                Field field = map.get(sourceField.getName());
                sourceField.setAccessible(true);
                field.setAccessible(true);
                try {
                    field.set(target, sourceField.get(source));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
