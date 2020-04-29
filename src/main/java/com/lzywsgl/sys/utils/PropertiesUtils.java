package com.lzywsgl.sys.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PropertiesUtils.java
 * @Description TODO
 * @createTime 2020年04月14日 14:37:00
 */
public class PropertiesUtils {
    private static final Properties properties = new Properties();

    static {
        InputStream stream = PropertiesUtils.class.getClassLoader().getResourceAsStream("export.properties");
        try {
            properties.load(stream);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
