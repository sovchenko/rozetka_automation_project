package com.softserveinc.atqc.page_objects;

import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.*;

@Getter
public class HomePage extends BasePage {

    @Step("Open home page")
    public HomePage openHomePage() {
        open("https://rozetka.com.ua/");
        return new HomePage();
    }

    @Step("Select product category in menu")
    public HomePage hoverMenuCategory(String category) {
        $x("//a[@class='menu-categories__link' and contains(@href,'" + category + "')]").hover();
        return this;
    }

    @Step("Select product subcategory in menu")
    public ProductsListPage selectProductSubcategory(String subcategory) {
        $x("//a[@class='menu__link' and contains(@href,'" + subcategory + "')]").click();
        return new ProductsListPage();
    }
}
