package com.softserveinc.atqc.page_elements.product_grid;

import com.codeborne.selenide.SelenideElement;
import com.softserveinc.atqc.page_objects.ProductsListPage;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class ProductSortingDropDown {
    private SelenideElement sortingDropDown = $x("//ctg-sort[@class='catalog-settings__sorting']/select");

    @Step("Sort products by price: low to high")
    public ProductsListPage sortByPriceLowToHigh() {
        sortingDropDown.selectOptionByValue("1: cheap");

        return new ProductsListPage();
    }

    @Step("Sort products by prise: high to low")
    public ProductsListPage sortByPriceHighToLow() {
        sortingDropDown.selectOptionByValue("2: expensive");

        return new ProductsListPage();
    }
}
