package page_objects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

@Getter
public abstract class BasePage {
    private SelenideElement topUserAccountLink = $("a.header-topline__user-link");

    @Step("Log in as user")
    public HomePage logIn(String email, String password) {
        topUserAccountLink.shouldBe(enabled).click();
        $("#auth_email").sendKeys(email);
        $("#auth_pass").sendKeys(password);
        $(".auth-modal__remember-checkbox").click();
        $("div.auth-modal__form-bottom > button ").shouldBe(enabled).click();
        topUserAccountLink.shouldHave(attribute("href", "https://my.rozetka.com.ua/profile/personal-information"));
        return new HomePage();
    }

    public String getNameOfLoggedInUser() {
        return topUserAccountLink.getText();
    }


    @Step("Navigate to the user account")
    public UserAccountPage navigateToUserAccount() {
        topUserAccountLink.hover().click();

        return new UserAccountPage();
    }

    @Step("Enter text to the search field and press 'Знайти' button")
    public SearchResultsPage searchForTheItem(String item) {
        $(By.name("search")).sendKeys(item);
        $("button.button.search-form__submit").click();
        return new SearchResultsPage();
    }


}
