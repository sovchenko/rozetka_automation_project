package com.softserveinc.atqc.page_objects;

import com.codeborne.selenide.SelenideElement;
import com.softserveinc.atqc.page_elements.Header;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$;

public class UserAccountPage extends BasePage {

    private SelenideElement signOutLink = $("#profile_signout");
    private Header header = new Header();

    @Step("Log out using link in user's profile")
    public void logOutUsingLinkInProfile() {
        signOutLink.click();
        header.getTopUserAccountLink().shouldHave(attribute("href", "https://rozetka.com.ua/ua/#"));
    }
}
