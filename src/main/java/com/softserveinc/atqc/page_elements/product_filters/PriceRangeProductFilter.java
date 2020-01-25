package com.softserveinc.atqc.page_elements.product_filters;

import com.softserveinc.atqc.page_objects.ProductsListPage;
import io.qameta.allure.Step;
import lombok.val;


import static com.codeborne.selenide.Selenide.$x;

public class PriceRangeProductFilter {

    @Step("Hide price range filter")
    public PriceRangeProductFilter hidePriceRangeProductFilter() {
        $x("//ctg-filter-slider[@class='filter_layout_sidebar']/preceding::button[1]").click();

        return this;
    }

    @Step("Expand price range filter")
    public PriceRangeProductFilter expandPriceRangeProductFilter() {
        return hidePriceRangeProductFilter();
    }

    @Step("Set price range for products")
    public ProductsListPage setProductPriceRange(int min, int max) {
        val minField = $x("//input[@formcontrolname='min']");
        minField.setValue(Integer.toString(min));

        val maxField = $x("//input[@formcontrolname='max']");
        maxField.setValue(Integer.toString(max));
        $x("//button[@type='submit']").click();

        return new ProductsListPage();
    }
}
