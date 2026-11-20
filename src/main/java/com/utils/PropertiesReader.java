package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    // Read the data.properties and give to anyone who wants with key.
    // url ->

public static String readKeys(String key) {

    String user_dir = System.getProperty("user.dir");
    String filePath = user_dir + "/src/main/resources/data.properties";
    Properties p;
    try {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        p = new Properties();
        p.load(fileInputStream);
    } catch (IOException e) {

    throw new RuntimeException(e);
    }
    return p.getProperty(key);
}
}
