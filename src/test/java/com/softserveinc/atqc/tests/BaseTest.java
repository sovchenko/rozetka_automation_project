package com.softserveinc.atqc.tests;

import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;

public class BaseTest {
    private InputStream input;
    protected Properties properties;

    @BeforeClass
    public void setUp() {
        System.setProperty("chromeoptions.args",
                "--disable-browser-side-navigation," +
                        "--disable-gpu,--dns-prefetch-disable," +
                        "--disable-impl-side-painting," +
                        // disables site isolation introduced in Chrome due to Spectre attacks
                        // https://bugs.chromium.org/p/chromedriver/issues/detail?id=2660
                        "--disable-site-isolation-trials," +
                        "--no-sandbox," +
                        "--disable-infobars," +
                        "--ignore-certificate-errors," +
                        "--disable-popup-blocking," +
                        "--disable-notifications");
        clearBrowserCookies();
        headless = false;
        startMaximized = true;
        baseUrl = "https://rozetka.com.ua/";

        try {
            input = new FileInputStream("./properties");
            properties = new Properties();
            properties.load(input);
        } catch (IOException ex) {
            System.out.println("File is not found");
        }

    }


}
