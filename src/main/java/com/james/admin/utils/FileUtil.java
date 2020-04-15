package com.james.admin.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {

    public static String getFilePathByDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String filePath = dateFormat.format(new Date());
        return filePath;
    }
}
