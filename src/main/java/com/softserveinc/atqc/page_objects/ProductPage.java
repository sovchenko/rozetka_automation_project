package com.softserveinc.atqc.page_objects;

import com.codeborne.selenide.SelenideElement;
import com.softserveinc.atqc.page_elements.product_page_elements.ProductReviewsTab;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Integer.parseInt;

public class ProductPage extends BasePage {
    private SelenideElement reviewsTab = $x("//a[@class='product__rating-reviews']");

    private int parseToText(SelenideElement element) {

        return parseInt(element.getText()
                .replaceAll("\\D", ""));
    }

    public int getItemPrice() {

        return parseToText($("p.product-prices__big"));
    }

    public String getItemTitle() {
        return $x("//h1[@class='product__title']").getText();
    }

    public String getItemRate() {

        return $x("//app-rating-stars").find(By.cssSelector("svg")).getAttribute("aria-label");
    }

    public int getReviewsAmount() {

        return parseToText(reviewsTab);
    }

    public ProductReviewsTab openReviewsTab() {
        reviewsTab.click();

        return new ProductReviewsTab();
    }
}
