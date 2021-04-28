package com.jwd_admission.byokrut.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReaderUtil {
    private static int defPoolSize;
    private static String url;
    private static String password;
    private static String login;
    private static final Properties properties = new Properties();

    private static final Logger logger = LogManager.getLogger();

    private PropertyReaderUtil() {
    }

    private static void loadProperties() {
        try(InputStream iStream = new FileInputStream("C:\\Users\\Юзер\\Documents\\GitHub\\jwd-admission\\src\\main\\resources\\application.properties");) {
            properties.load(iStream);
            defPoolSize= Integer.parseInt(properties.getProperty("defaultPoolSize"));
            url=properties.getProperty("connectionUrl");
            password=properties.getProperty("password");
            login=properties.getProperty("login");
        } catch (IOException e) {
            logger.error(e);
        }
    }

    public static int getDefPoolSize(){
        if(defPoolSize==0) loadProperties();
        return defPoolSize;
    }

    public static String getUrl(){
        if(url==null) loadProperties();
        return url;
    }

    public static String getPassword(){
        if(password==null) loadProperties();
        return password;
    }

    public static String getLogin(){
        if(login==null) loadProperties();
        return login;
    }
}
