package com.softserveinc.atqc.page_elements.items_grid;

import com.codeborne.selenide.SelenideElement;
import com.softserveinc.atqc.page_elements.product_page_elements.ProductReviewsTab;
import com.softserveinc.atqc.page_objects.*;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductTile {
    private SelenideElement productLink;
    private int productPrice;
    private String productRate;
    private boolean isProductAvailable;
    private SelenideElement shoppingCartButton;
    private SelenideElement addToWishListButton;
    private SelenideElement addToComparisonButton;
    private SelenideElement productReviewsLink;

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

    @Step("Open product's reviews")
    public ProductReviewsTab openProductReviews() {
        productReviewsLink.click();

        return new ProductReviewsTab();
    }

    @Step("Add product to the comparison")
    public ProductComparisonPage addProductToComparison() {
        addToComparisonButton.click();

        return new ProductComparisonPage();
    }

    public int getReviewsAmount() {
        int reviewsAmount = Integer.parseInt(
                productReviewsLink
                        .getText()
                        .replaceAll("\\D", ""));

        return reviewsAmount;
    }

}
