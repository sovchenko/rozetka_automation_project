package com.softserveinc.atqc.tests;

import com.softserveinc.atqc.page_objects.HomePage;
import lombok.val;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static org.testng.Assert.assertEquals;
//TODO: create parent test runner class
//TODO: create test suite
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
        val nameOfLoggedInUser = homePage.getHeader().getLoggedInUserName();
        assertEquals(nameOfLoggedInUser, expectedUserName);

        homePage.getHeader().navigateToUserAccount().logOutUsingProfileLink();
        val unloggedUserName = homePage.getHeader().getLoggedInUserName();
        assertEquals(unloggedUserName, loginLinkLabel);
    }
}
