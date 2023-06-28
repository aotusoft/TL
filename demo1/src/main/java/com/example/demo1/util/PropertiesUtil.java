package com.example.demo1.util;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

    private PropertiesUtil(){}

    private static Properties properties=null;

    public static Properties getProperties() throws IOException {
        if(properties==null){
            properties=new Properties();
            properties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
        }
        return properties;
    }

}
