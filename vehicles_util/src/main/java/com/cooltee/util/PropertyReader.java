package com.cooltee.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private static final String FILE_PATH = "parameter.properties";

    public static String getProperty(String key) {

        return getProperty(FILE_PATH, key);

    }

    public static String getProperty(String fileName, String key) {
        Properties property = new Properties();
        InputStream in = null;
        try {
            in = PropertyReader.class.getClassLoader().getResourceAsStream(fileName);
            property.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return property.getProperty(key);
    }

}
