package com.softserveinc.atqc.page_objects;

import com.codeborne.selenide.ElementsCollection;
import com.softserveinc.atqc.page_elements.product_filters.ManufacturerProductFilter;
import com.softserveinc.atqc.page_elements.product_filters.PriceRangeProductFilter;
import com.softserveinc.atqc.page_elements.items_grid.ProductTile;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.Integer.*;

public class ProductsListPage {

    public List<ProductTile> getTiles(int amount) {
        List<ProductTile> productTiles = new ArrayList<>();
            ElementsCollection productTileElements = $$x("//div[@class='goods-tile']");
            productTileElements
                    .first(amount)
                    .forEach(tileElement -> {
                        ProductTile productTile = new ProductTile();
                        productTile.setProductPrice(
                                parseInt(tileElement.
                                        find(By.xpath(".//span[@class='goods-tile__price-value']"))
                                        .getText()
                                        .replaceAll("\\D", "")));

                        productTile.setAddToComparisonButton(tileElement.find(By.xpath(".//button[@class='compare-button']")));
                        productTile.setAddToWishListButton(tileElement.find(By.xpath(".//button[@class='wish-button']")));
                        productTile.setProductAvailable(tileElement.find(By.cssSelector("div.goods-tile__availability")).getAttribute("class").contains("available"));
                        productTile.setProductLink(tileElement.find(By.xpath(".//span[@class='goods-tile__title']")));
                        if (tileElement.find(By.xpath(".//div[@class='goods-tile__stars']")).exists()) {
                            productTile.setProductRate(tileElement.find(By.xpath(".//div[@class='goods-tile__stars']")).find(By.cssSelector("svg")).getAttribute("aria-label"));
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