package com.jwd_admission.byokrut.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyReaderUtilTest {

    @Test
    void getDefPoolSize() {
        int poolSize=PropertyReaderUtil.getDefPoolSize();
        assertEquals(32,poolSize);
    }

    @Test
    void getUrl() {
        System.out.println(PropertyReaderUtil.getLogin());
    }

    @Test
    void getPassword() {
    }

    @Test
    void getLogin() {
    }
}