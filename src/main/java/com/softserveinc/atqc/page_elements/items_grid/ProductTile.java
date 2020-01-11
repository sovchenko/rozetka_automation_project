package com.softserveinc.atqc.page_elements.items_grid;

import com.codeborne.selenide.SelenideElement;
import com.softserveinc.atqc.page_objects.*;
import jdk.nashorn.internal.objects.annotations.Where;
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

    public String getProductTitle(){
        return productLink.getText();
    }

    public ProductPage openProductPage(){
        productLink.click();
        return new ProductPage();
    }

    public CheckoutModalPage buyProduct(){
        shoppingCartButton.click();
        return new CheckoutModalPage();
    }

    public WishListPage addProductToWishList(){
        addToWishListButton.click();
        return new WishListPage();
    }

    public ReviewsPage openProductReviews(){
        productReviewsLink.click();
        return new ReviewsPage();
    }

    public ComparisonPage addProductToComparison(){
        addToComparisonButton.click();
        return new ComparisonPage();
    }

    public int getReviewsAmount(){
        return Integer.parseInt(productReviewsLink.getText().replaceAll("\\D",""));
    }







}
