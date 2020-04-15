package com.james.admin.utils;

import java.util.Random;
import java.util.UUID;

public class IDUtil {

    public static String getUUID(){
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        return uuid;
    }

    public static String getTimeID(){
        long millis = System.currentTimeMillis();
        Random random = new Random();
        int end4 = random.nextInt(9999);
        String str = millis + String.format("%04d", end4);
        return str;
    }
}
