package page_objects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {
    private String userNamePlaceHolder = " увійдіть в особистий кабінет ";
    private String defaultRussianUserPlaceholder = " войдите в личный кабинет ";
    private SelenideElement topUserAccountLink = $("a.header-topline__user-link");

    // called this method this way due to the fact that user can log in on any page
    // and after logging he will remain on that page
    // so each logIn method should return instance of certain page
    @Step("Log in as user")
    public HomePage logInFromHomePage(String email, String password) {
        closeBanner();
        topUserAccountLink.shouldBe(enabled).click();
        $("#auth_email").sendKeys(email);
        $("#auth_pass").sendKeys(password);
        $(".auth-modal__remember-checkbox").click();
        $("div.auth-modal__form-bottom > button ").shouldBe(enabled).click();
        return new HomePage();
    }

    public String getNameOfLoggedInUser() {

        return topUserAccountLink
                .waitUntil(not(text(defaultRussianUserPlaceholder)), 4000)
                .waitUntil(not(text(userNamePlaceHolder)), 4000)
                .getText();
    }

    @Step("Navigate to the user account")
    public UserAccountPage navigateToUserAccount() {
        closeBanner();
        topUserAccountLink
                .shouldNot(text(userNamePlaceHolder).because("user should be logged in"))
                .shouldNot(text(defaultRussianUserPlaceholder).because("user should be logged in"))
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

    static void closeBanner(){
        if($(".rz-banner_picture").exists()){
            $(".exponea-close-cross").waitUntil(visible,3000).click();
        }
    }



}
