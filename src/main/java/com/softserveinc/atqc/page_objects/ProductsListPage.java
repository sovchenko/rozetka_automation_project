package com.softserveinc.atqc.page_objects;

import com.codeborne.selenide.ElementsCollection;
import com.softserveinc.atqc.page_elements.product_grid.ProductTile;
import com.softserveinc.atqc.page_elements.product_filters.ManufacturerProductFilter;
import com.softserveinc.atqc.page_elements.product_filters.PriceRangeProductFilter;
import com.softserveinc.atqc.page_elements.product_grid.ProductSortingDropDown;
import lombok.Getter;
import lombok.val;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.*;

@Getter
public class ProductsListPage {
    private ProductSortingDropDown productSortingDropDown = new ProductSortingDropDown();

    public ProductsListPage() {
        $x("//ctg-grid")
                .waitUntil(not(attribute("class", "preloader-type-goods")),
                        4000);
    }

    public List<ProductTile> getTiles(int amount) {
        List<ProductTile> productTiles = new ArrayList<>();
        ElementsCollection productTileElements = $$x("//div[@class='goods-tile']");
        productTileElements
                .first(amount)
                .forEach(tileElement -> {
                    val productTile = new ProductTile(tileElement);
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