package com.softserveinc.atqc.tests;

import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Configuration.startMaximized;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;

public class BaseTest {
    private InputStream input;
    protected Properties properties;

    @BeforeClass
    public void setUp() {
        clearBrowserCookies();
        startMaximized = true;

        try {
            input = new FileInputStream("./properties");
            properties = new Properties();
            properties.load(input);
        } catch (IOException ex) {
            System.out.println("File is not found");
        }

    }


}
