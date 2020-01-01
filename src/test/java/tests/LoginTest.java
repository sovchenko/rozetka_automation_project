package tests;

import lombok.val;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static org.testng.Assert.*;
import static page_objects.HomePage.openHomePage;

public class LoginTest {
    @BeforeMethod
    public void setUp() {
        clearBrowserCookies();
    }

    @Test
    public void verifySuccessfulLogIn() {
        val expectedUserName = "Тест";
        val label = "увійдіть в особистий кабінет";
        val homePage = openHomePage()
                .logInFromHomePage("ezbooksforme@gmail.com", "Pa55word");
        val nameOfLoggedInUser = homePage.getNameOfLoggedInUser();
        assertEquals(nameOfLoggedInUser, expectedUserName);

        homePage.navigateToUserAccountPage().logOutUsingLinkInProfile();
        Assert.assertEquals(homePage.getNameOfLoggedInUser(), label);

    }


}
