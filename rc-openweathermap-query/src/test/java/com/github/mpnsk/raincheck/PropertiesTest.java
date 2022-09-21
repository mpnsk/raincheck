package com.github.mpnsk.raincheck;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PropertiesTest {

    @Test
    void getTokenTest() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("../secrets.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String token = properties.getProperty("owm.token");
        assertNotEquals("", token);
        assertNotEquals("your token here", token);
        assertTrue(token.length() > 0);
    }
}