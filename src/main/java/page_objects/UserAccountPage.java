package page_objects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class UserAccountPage extends BasePage {

    private SelenideElement signOutLink = $("#profile_signout");

    @Step("Log out using link in user's profile")
    public void logOutUsingLinkInProfile() {
        signOutLink.click();
        getTopUserAccountLink().shouldHave(attribute("href", "https://rozetka.com.ua/ua/#"));
    }
}
