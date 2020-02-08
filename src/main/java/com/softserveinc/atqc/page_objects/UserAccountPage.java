package com.softserveinc.atqc.page_objects;

import com.codeborne.selenide.SelenideElement;
import com.softserveinc.atqc.page_elements.Header;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$;

public class UserAccountPage extends BasePage {

    private SelenideElement signOutLink = $("#profile_signout");

    @Step("Log out using link in user's profile")
    public void logOutUsingProfileLink() {
        signOutLink.click();
        getHeader()
                .getTopUserAccountLink()
                .shouldHave(
                        attribute("href", "https://rozetka.com.ua/ua/#"));
    }
}
