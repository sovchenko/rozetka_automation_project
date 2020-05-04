package com.softserveinc.atqc.tests;

import com.softserveinc.atqc.page_objects.HomePage;
import lombok.val;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
//TODO: create parent test runner class
//TODO: create test suite
public class LoginTest  extends BaseTest{

    @Test
    public void verifySuccessfulLogIn() {
        val expectedUserName = "Тест";
        val loginLinkLabel = "увійдіть в особистий кабінет";
        val homePage = new HomePage()
                .open()
                .getHeader()
                .logIn(properties.getProperty("userEmail"), properties.getProperty("userPassword"));
        val loggedInUserName = homePage.getHeader().getLoggedInUserName();
        assertEquals(loggedInUserName, expectedUserName);

        homePage.getHeader().navigateToUserAccount().logOutUsingProfileLink();
        val unloggedUserName = homePage.getHeader().getLoggedInUserName();
        assertEquals(unloggedUserName, loginLinkLabel);
    }
}
