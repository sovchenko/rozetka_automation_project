package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.BasePage;
import page_objects.HomePage;

import static com.codeborne.selenide.Selenide.*;

public class SmokeTests {
    @Test
    public void logInAsUser(){
        String nameOfTheUser = "Тест";
        open("https://rozetka.com.ua/");
        HomePage homePage = new HomePage();
        homePage.logIn("ezbooksforme@gmail.com", "Pa55word");
        Assert.assertEquals(homePage.getNameOfLoggedInUser(nameOfTheUser),nameOfTheUser);
        homePage.navigateToUserAccount()
                .logOutUsingLinkInProfile();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
