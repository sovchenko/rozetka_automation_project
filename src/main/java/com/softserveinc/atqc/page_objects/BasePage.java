package com.softserveinc.atqc.page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.softserveinc.atqc.page_elements.Header;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

@Getter
public abstract class BasePage {
    private Header header = new Header();
}
