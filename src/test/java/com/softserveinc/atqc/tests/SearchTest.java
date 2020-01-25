package com.softserveinc.atqc.tests;

import com.softserveinc.atqc.page_elements.product_grid.ProductTile;
import com.softserveinc.atqc.page_objects.HomePage;
import lombok.val;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class SearchTest extends BaseTest{

    @Test
    public void verifyThatSearchedTermIsPresentInItemTitle() {
        val item = "iPhone 11";

        List<ProductTile> productTiles = new HomePage()
                .open()
                .getHeader()
                .searchForProduct(item)
                .getTiles(5);

        for (ProductTile title : productTiles) {
            assertTrue(title.getProductTitle()
                    .contains(item));
        }
    }
}
