package com.softserveinc.atqc.tests;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
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
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        browserCapabilities.setCapability(ChromeOptions.CAPABILITY,chromeOptions);
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
