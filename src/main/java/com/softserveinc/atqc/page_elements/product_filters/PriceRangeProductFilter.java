package com.softserveinc.atqc.page_elements.product_filters;

import com.codeborne.selenide.SelenideElement;
import com.softserveinc.atqc.page_objects.ProductsListPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class PriceRangeProductFilter {

    public PriceRangeProductFilter hidePriceRangeProductFilter() {
        $x("//button[contains(text(),'Ціна') or contains(text(),'Цена')]").click();
        return this;
    }

    public PriceRangeProductFilter expandPriceRangeProductFilter() {
        return hidePriceRangeProductFilter();
    }

    @Step("Set price range for products")
    public ProductsListPage setProductPriceRange(int min, int max) {
        SelenideElement minField = $x("//input[@formcontrolname='min']");
        minField.clear();
        minField.sendKeys(Integer.toString(min));

        SelenideElement maxField = $x("//input[@formcontrolname='max']");
        maxField.clear();
        maxField.sendKeys(Integer.toString(max));
        $x("//button[@type='submit']").click();
        return new ProductsListPage();
    }
}
