package page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Data;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    protected SelenideElement topUserAccountLink = $("a.header-topline__user-link");


    @Step("Log in as user")
    public void logIn(String email, String password) {
        topUserAccountLink.shouldBe(Condition.enabled).click();
        $("#auth_email").sendKeys(email);
        $("#auth_pass").sendKeys(password);
        $(".auth-modal__remember-checkbox").click();
        $("div.auth-modal__form-bottom > button ").shouldBe(Condition.enabled).click();
    }

    public String getNameOfLoggedInUser() {
        String defaultText = topUserAccountLink.getText();
        return topUserAccountLink.waitUntil(Condition.not(Condition.text(defaultText)),4000).getText();
    }

    @Step("Navigate to the user account")
    public UserAccountPage navigateToUserAccount() {
        topUserAccountLink.hover().click();
        return new UserAccountPage();
    }

    public void logOutUsingTopHeader() {
        topUserAccountLink.hover();

    }

    @Step("Enter text to the search field and press 'Знайти' button")
    public ListItemPage searchForTheItem(String item) {
        $(By.name("search")).sendKeys(item);
        $("button.button.search-form__submit").click();
        $("#block_with_search > div > div.g-i-tile-l.clearfix").waitUntil(Condition.visible,5000);
        return new ListItemPage();
    }

}
