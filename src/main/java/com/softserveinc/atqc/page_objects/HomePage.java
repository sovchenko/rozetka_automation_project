package com.softserveinc.atqc.page_objects;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import lombok.val;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class HomePage extends BasePage {

    @Step("Open home page")
    public HomePage open() {
        Selenide.open("https://rozetka.com.ua/");

        return new HomePage();
    }

    @Step("Hover on product category in menu")
    public HomePage hoverMenuCategory(String category) {
        val menuCategoryXpath = format("//a[@class='menu-categories__link' and contains(@href,'%s')]", category);
        $x(menuCategoryXpath).hover();

        return this;
    }

    @Step("Select product subcategory in menu")
    public ProductsListPage selectProductSubcategory(String subcategory) {
        val subCategoryXpath = format("//a[@class='menu__link' and contains(@href,'%s')]", subcategory);
        $x(subCategoryXpath).click();

        return new ProductsListPage();
    }
}
