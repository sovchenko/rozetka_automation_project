package page_objects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {
    private String ukrLabel = " увійдіть в особистий кабінет ";
    private String rusLabel = " войдите в личный кабинет ";
    private SelenideElement topUserAccountLink = $("a.header-topline__user-link");

    @Step("Log in as user")
    public HomePage logInFromHomePage(String email, String password) {
        topUserAccountLink.click();
        $("#auth_email").sendKeys(email);
        $("#auth_pass").sendKeys(password);
        $(".auth-modal__remember-checkbox").click();
        $("div.auth-modal__form-bottom > button ").shouldBe(enabled).click();
        return new HomePage();
    }

    public String getNameOfLoggedInUser() {

        return topUserAccountLink
                .waitUntil(not(text(rusLabel)), 4000)
                .waitUntil(not(text(ukrLabel)), 4000)
                .getText();
    }

    @Step("Navigate to the user account")
    public UserAccountPage navigateToUserAccountPage(){
        topUserAccountLink
                .shouldNot(text(ukrLabel).because("user should be logged in"))
                .shouldNot(text(rusLabel).because("user should be logged in"))
                .hover()
                .click();
        return new UserAccountPage();
    }

    @Step("Enter text to the search field and press 'Знайти' button")
    public SearchResultsPage searchForTheItem(String item) {
        $(By.name("search")).sendKeys(item);
        $("button.button.search-form__submit").click();
        return new SearchResultsPage();
    }

}
