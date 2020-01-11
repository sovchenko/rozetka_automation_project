package com.softserveinc.atqc.page_elements.product_page_elements;

import static com.codeborne.selenide.Selenide.$x;

public class ProductReviewsTab {

    public String getReviewTabTitle(){
        return $x("//h2[@class='product-tabs__heading']").getText();
    }
}
