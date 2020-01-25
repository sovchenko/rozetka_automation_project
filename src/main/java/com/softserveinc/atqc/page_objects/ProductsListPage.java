package com.softserveinc.atqc.page_objects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.softserveinc.atqc.page_elements.items_grid.ProductTile;
import com.softserveinc.atqc.page_elements.product_filters.ManufacturerProductFilter;
import com.softserveinc.atqc.page_elements.product_filters.PriceRangeProductFilter;
import lombok.val;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static java.lang.Integer.parseInt;

public class ProductsListPage {

    public List<ProductTile> getTiles(int amount) {
        List<ProductTile> productTiles = new ArrayList<>();
        ElementsCollection productTileElements = $$x("//div[@class='goods-tile']");
        productTileElements
                .first(amount)
                .forEach(tileElement -> {
                    val productTile = new ProductTile();

                    val productPrice = parseInt(tileElement.
                            find(By.xpath(".//span[@class='goods-tile__price-value']"))
                            .getText()
                            .replaceAll("\\D", ""));
                    productTile.setProductPrice(productPrice);

                    val comparisonButton = tileElement.find(By.xpath(".//button[@class='compare-button']"));
                    productTile.setAddToComparisonButton(comparisonButton);

                    val wishListButton = tileElement.find(By.xpath(".//button[@class='wish-button']"));
                    productTile.setAddToWishListButton(wishListButton);

                    val productAvailability = tileElement.find(By.cssSelector("div.goods-tile__availability"));

                    productTile.setProductAvailable(productAvailability
                            .getAttribute("class")
                            .contains("available"));

                    val productLink = tileElement.find(By.xpath(".//span[@class='goods-tile__title']"));
                    productTile.setProductLink(productLink);

                    val ratingXpath = ".//div[@class='goods-tile__stars']";
                    if (tileElement.find(By.xpath(ratingXpath)).exists()) {
                        productTile.setProductRate(tileElement.find(By.xpath(ratingXpath))
                                .find(By.cssSelector("svg"))
                                .getAttribute("aria-label"));
                    }

                    val productReviewsLink = tileElement.find(By.xpath(".//span[@class='goods-tile__reviews-link']"));
                    productTile.setProductReviewsLink(productReviewsLink);

                    val shoppingCartButton = tileElement.find(By.xpath(".//button[@class='goods-tile__buy-button']"));
                    productTile.setShoppingCartButton(shoppingCartButton);

                    productTiles.add(productTile);
                });

        return productTiles;
    }

    public PriceRangeProductFilter getPriceRangeProductFilter() {

        return new PriceRangeProductFilter();
    }

    public ManufacturerProductFilter getManufacturerProductFilter() {

        return new ManufacturerProductFilter();
    }
}