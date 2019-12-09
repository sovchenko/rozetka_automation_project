package tests;

import data_providers.LoginData;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.BasePage;
import page_objects.HomePage;
import page_objects.ListItemPage;

import static com.codeborne.selenide.Selenide.*;
import static page_objects.HomePage.openPage;

public class SmokeTests {
    @BeforeMethod
    public void setUp(){
        clearBrowserCookies();
    }

    @Test(description = "Positive login", dataProvider = "validLogin", dataProviderClass = LoginData.class)
    @Description("Verify successful logging of the user")
    public void logInAsUser(String email, String password) {
        String nameOfTheUser = "Тест";
        open("https://rozetka.com.ua/ua/");
        HomePage homePage = new HomePage();
        homePage.logIn(email, password);
        Assert.assertEquals(homePage.getNameOfLoggedInUser(), nameOfTheUser);
        homePage.navigateToUserAccount()
                .logOutUsingLinkInProfile();

    }

    @Test(description = "Search for items", dataProvider = "validLogin", dataProviderClass = LoginData.class)
    @Description("Verify that searched term is present in items titles")
    public void verifySearch(String email, String password) {
        String item = "moto g7";
        ListItemPage listItemPage = openPage().logIn(email, password).searchForTheItem(item);
        Assert.assertEquals(listItemPage.verifyThatItemsContainsSearchedTerm(item), true);

    }
}
