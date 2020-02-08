package com.softserveinc.atqc.page_objects;

import com.codeborne.selenide.Selenide;
import com.softserveinc.atqc.page_elements.menu.MenuCategory;
import com.softserveinc.atqc.page_elements.menu.SubmenuCategory;
import io.qameta.allure.Step;
import lombok.val;

import static java.lang.String.format;
import static com.codeborne.selenide.Selenide.$x;


public class HomePage extends BasePage {

    @Step("Open home page")
    public HomePage open() {
        Selenide.open("https://rozetka.com.ua/");

        return this;
    }

    @Step("Hover on product category in menu")
    public HomePage hoverMenuCategory(MenuCategory category) {
        val menuCategoryXpath = format("//a[@class='menu-categories__link' and contains(@href,'%s')]",
                category.getCategoryName());
        $x(menuCategoryXpath).hover();

        return this;
    }

    @Step("Select product subcategory in menu")
    public ProductsListPage selectProductSubcategory(SubmenuCategory subcategory) {
        val subCategoryXpath = format("//a[@class='menu__link' and contains(@href,'%s')]",
                subcategory.getSubcategoryName());
        $x(subCategoryXpath).click();

        return new ProductsListPage();
    }
}
