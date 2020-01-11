package com.softserveinc.atqc.page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.softserveinc.atqc.page_elements.product_page_elements.ProductReviewsTab;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProductPage {
    private SelenideElement reviewsLink = $x("//a[@class='product__rating-reviews']");


    public int getItemPrice() {
        return Integer.parseInt($("p.product-prices__big").getText().replaceAll("\\D", ""));
    }

    public String getItemTitle() {
        return $x("//h1[@class='product__title']").getText();
    }

    public String getItemRate() {
        return $x("//app-rating-stars").find(By.cssSelector("svg")).getAttribute("aria-label");
    }

    public int getReviewsAmount() {
        return Integer.parseInt(reviewsLink.getText().replaceAll("\\D", ""));
    }

    public ProductReviewsTab openReviewsTab() {
        reviewsLink.click();
        //return created object or find another solution
        return new ProductReviewsTab();
    }

    public String getReviewTitle() {
        SelenideElement titleOfReviewSection = $x("//div[@class='product-comments__header']/h2[@class='product-tabs__heading']").shouldBe(Condition.visible);
        return titleOfReviewSection.getText();
    }
}
