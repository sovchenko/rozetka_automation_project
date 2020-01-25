package com.softserveinc.atqc.page_elements.product_grid;

import com.codeborne.selenide.SelenideElement;
import com.softserveinc.atqc.page_elements.product_page_elements.ProductReviewsTab;
import com.softserveinc.atqc.page_objects.CheckoutModalPage;
import com.softserveinc.atqc.page_objects.ProductComparisonPage;
import com.softserveinc.atqc.page_objects.ProductPage;
import com.softserveinc.atqc.page_objects.WishListPage;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.Setter;
import lombok.val;
import org.openqa.selenium.By;

import static java.lang.Integer.parseInt;

@Getter
@Setter
public class ProductTile {
    private SelenideElement productLink;
    private int productPrice;
    private String productRate;
    private boolean productAvailability;
    private SelenideElement shoppingCartButton;
    private SelenideElement addToWishListButton;
    private SelenideElement addToComparisonButton;
    private SelenideElement productReviewsLink;

    public ProductTile(SelenideElement element){
        this.productPrice = parseInt(element.
                $x(".//span[@class='goods-tile__price-value']")
                .getText()
                .replaceAll("\\D", ""));

        this.addToComparisonButton = element.$x(".//button[@class='compare-button']");

        this.addToWishListButton = element.$x(".//button[@class='wish-button']");

        this.productAvailability = element.find("div.goods-tile__availability")
                .getAttribute("class")
                .contains("available");

        this.productLink = element.$x(".//span[@class='goods-tile__title']");

        val ratingXpath = ".//div[@class='goods-tile__stars']";
        if (element.$x(ratingXpath).exists()) {
            this.productRate = element.$x(ratingXpath)
                    .find("svg")
                    .getAttribute("aria-label");
        }

        this.productReviewsLink  = element.$x(".//span[@class='goods-tile__reviews-link']");

        this.shoppingCartButton = element.$x(".//button[@class='goods-tile__buy-button']");
    }

    public String getProductTitle() {

        return productLink.getText();
    }

    @Step("Open product page")
    public ProductPage openProductPage() {
        productLink.click();

        return new ProductPage();
    }

    @Step("Add product to the cart")
    public CheckoutModalPage addProductToCart() {
        shoppingCartButton.click();

        return new CheckoutModalPage();
    }

    @Step("Add product to the wishlist")
    public WishListPage addProductToWishList() {
        addToWishListButton.click();

        return new WishListPage();
    }

    @Step("Open product's reviews tab")
    public ProductReviewsTab openProductReviewsTab() {
        productReviewsLink.click();

        return new ProductReviewsTab();
    }

    @Step("Add product to the comparison")
    public ProductComparisonPage addProductToComparison() {
        addToComparisonButton.click();

        return new ProductComparisonPage();
    }

    public int getReviewsAmount() {
        val reviewsAmount = parseInt(
                productReviewsLink
                        .getText()
                        .replaceAll("\\D", ""));

        return reviewsAmount;
    }

}
