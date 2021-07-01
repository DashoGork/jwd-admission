package com.jwd_admission.byokrut.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class InputDeserializer {
    private static final Logger logger = LogManager.getLogger();

    public static Object deserialize(String path) {
        Object result = null;
        try (FileInputStream fileInputStream = new FileInputStream(path);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            result = objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            logger.error(e);
        }
        return result;
    }


}
