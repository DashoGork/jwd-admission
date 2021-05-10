package com.jwd_admission.byokrut.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public enum PropertyReaderUtil {
    INSTANSE;
    private Properties properties = null;
    private final Logger logger = LogManager.getLogger();

    PropertyReaderUtil() {
        try (InputStream input = PropertyReaderUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
            properties = new Properties();
            properties.load(input);
        } catch (IOException e) {
            logger.error(e);
        }
    }

    public Properties getProperties() {
        return properties;
    }
}
