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

                    productTile.setProductPrice(
                            parseInt(tileElement.
                                    find(By.xpath(".//span[@class='goods-tile__price-value']"))
                                    .getText()
                                    .replaceAll("\\D", "")));

                    val addToComparisonButton = tileElement.find(By.xpath(".//button[@class='compare-button']"));
                    productTile.setAddToComparisonButton(addToComparisonButton);
                    val addToWishListButton = tileElement.find(By.xpath(".//button[@class='wish-button']"));
                    productTile.setAddToWishListButton(addToWishListButton);

                    val selenideElement = tileElement.find(By.cssSelector("div.goods-tile__availability"));
                    productTile.setProductAvailable(selenideElement
                            .getAttribute("class")
                            .contains("available"));

                    productTile.setProductLink(tileElement.find(By.xpath(".//span[@class='goods-tile__title']")));

                    val ratingXpath = ".//div[@class='goods-tile__stars']";
                    if (tileElement.find(By.xpath(ratingXpath)).exists()) {
                        productTile.setProductRate(tileElement.find(By.xpath(ratingXpath))
                                .find(By.cssSelector("svg"))
                                .getAttribute("aria-label"));
                    }

                    productTile.setProductReviewsLink(tileElement.find(By.xpath(".//span[@class='goods-tile__reviews-link']")));
                    productTile.setShoppingCartButton(tileElement.find(By.xpath(".//button[@class='goods-tile__buy-button']")));
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