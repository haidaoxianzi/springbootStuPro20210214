package com.gina.util;

import org.slf4j.Logger;

import java.util.function.Supplier;

public class FutrueUtil {

    public static <T> T getDealResult(Supplier<T> supplier , T defaultValue, Logger logger){
        try {
            return supplier.get();
        } catch (Exception e) {
            logger.error("get getDealResult is error ",e);
            return defaultValue;
        }
    }

}
