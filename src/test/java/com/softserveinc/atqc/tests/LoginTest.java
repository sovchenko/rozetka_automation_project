package com.softserveinc.atqc.tests;

import com.softserveinc.atqc.page_objects.HomePage;
import lombok.val;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static org.testng.Assert.*;

public class LoginTest {
    @BeforeMethod
    public void setUp() {
        clearBrowserCookies();
    }

    @Test
    public void verifySuccessfulLogIn() {
        val expectedUserName = "Тест";
        val loginLinkLabel = "увійдіть в особистий кабінет";
        val homePage = new HomePage()
                .openHomePage()
                .getHeader()
                .logIn("ezbooksforme@gmail.com", "Pa55word");
        val nameOfLoggedInUser = homePage.getHeader().getLoggedInUserName();
        assertEquals(nameOfLoggedInUser, expectedUserName);

        homePage.getHeader().navigateToUserAccount().logOutUsingLinkInProfile();
        val defaultLabel = homePage.getHeader().getLoggedInUserName();
        Assert.assertEquals(defaultLabel, loginLinkLabel);
    }
}
