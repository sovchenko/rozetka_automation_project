package com.softserveinc.atqc.page_elements;

import com.codeborne.selenide.SelenideElement;
import com.softserveinc.atqc.page_objects.HomePage;
import com.softserveinc.atqc.page_objects.ProductSearchResultPage;
import com.softserveinc.atqc.page_objects.UserAccountPage;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.val;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class Header {
    private SelenideElement topUserAccountLink = $("a.header-topline__user-link");

    @Step("Enter text to the search field and press 'Find' button")
    public ProductSearchResultPage searchForProduct(String productName) {
        val searchField = $("input.search-form__input");
        searchField.setValue(productName);
        $("button.search-form__submit").click();

        return new ProductSearchResultPage();
    }

    @Step("Log in as user")
    public HomePage logIn(String email, String password) {
        topUserAccountLink.shouldBe(enabled).click();
        $("#auth_email").setValue(email);
        $("#auth_pass").setValue(password);
        $(".auth-modal__remember-checkbox").click();
        $("div.auth-modal__form-bottom > button ").shouldBe(enabled).click();
        topUserAccountLink.shouldHave(attribute("href", "https://my.rozetka.com.ua/profile/personal-information"));

        return new HomePage();
    }

    public String getLoggedInUserName() {
        return topUserAccountLink.getText();
    }

    @Step("Navigate to the user account")
    public UserAccountPage navigateToUserAccount() {
        topUserAccountLink.hover().click();

        return new UserAccountPage();
    }
}
