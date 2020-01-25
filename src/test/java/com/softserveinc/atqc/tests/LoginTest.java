package com.softserveinc.atqc.tests;

import com.softserveinc.atqc.page_objects.HomePage;
import lombok.val;
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
                .open()
                .getHeader()
                .logIn("ezbooksforme@gmail.com", "Pa55word");
        val loggedInUserName = homePage.getHeader().getLoggedInUserName();
        assertEquals(loggedInUserName, expectedUserName);

        homePage.getHeader().navigateToUserAccount().logOutUsingProfileLink();
        val unloggedUserName = homePage.getHeader().getLoggedInUserName();
        assertEquals(unloggedUserName, loginLinkLabel);
    }
}
