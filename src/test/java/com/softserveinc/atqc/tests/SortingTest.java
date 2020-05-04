package com.softserveinc.atqc.tests;

import com.softserveinc.atqc.page_elements.product_grid.ProductTile;
import com.softserveinc.atqc.page_objects.HomePage;
import lombok.val;
import org.testng.annotations.Test;

import java.util.List;

import static com.softserveinc.atqc.page_elements.menu.MenuCategory.PHONES_TV_ELECTRONICS;
import static com.softserveinc.atqc.page_elements.menu.SubmenuCategory.SMARTPHONES;
import static org.testng.Assert.*;

public class SortingTest {

    @Test
    public void verifyProductSortingByPriceHighToLow(){
        List<ProductTile> productTiles =  new HomePage()
                .open()
                .hoverMenuCategory(PHONES_TV_ELECTRONICS)
                .selectProductSubcategory(SMARTPHONES)
                .getProductSortingDropDown()
                .sortByPriceHighToLow()
                .getTiles(5);

        for(int i = 0; i < productTiles.size()-1; i++){
            val indexOfFollowingItem = i+1;
            val priceOfTheCurrentProduct = productTiles.get(i).getProductPrice();
            val priceOfTheNextProduct = productTiles.get(indexOfFollowingItem).getProductPrice();
            assertTrue(priceOfTheCurrentProduct > priceOfTheNextProduct);
        }
    }

    @Test
    public void verifyProductSortingByPriceLowToHigh(){
        List<ProductTile> productTiles =  new HomePage()
                .open()
                .hoverMenuCategory(PHONES_TV_ELECTRONICS)
                .selectProductSubcategory(SMARTPHONES)
                .getProductSortingDropDown()
                .sortByPriceLowToHigh()
                .getTiles(5);

        for(int i = 0; i < productTiles.size()-1; i++){
            val indexOfFollowingItem = i+1;
            val priceOfTheCurrentProduct = productTiles.get(i).getProductPrice();
            val priceOfTheNextProduct = productTiles.get(indexOfFollowingItem).getProductPrice();
            assertTrue(priceOfTheCurrentProduct < priceOfTheNextProduct);
        }
    }

}
