package com.softserveinc.atqc.tests;


import com.softserveinc.atqc.page_objects.HomePage;
import lombok.val;
import org.testng.annotations.Test;


import static com.softserveinc.atqc.page_elements.menu.MenuCategory.*;
import static com.softserveinc.atqc.page_elements.menu.SubmenuCategory.*;
import static com.softserveinc.atqc.page_elements.product_filters.product_filter_values.Manufacturer.ASUS;
import static org.testng.Assert.*;


public class ProductFilterTest extends BaseTest {


    @Test
    public void verifyThatFilteredItemHasCorrectPriceAndTitle() {
        val productTile = new HomePage()
                .open()
                .hoverMenuCategory(PHONES_TV_ELECTRONICS)
                .selectProductSubcategory(SMARTPHONES)
                .getManufacturerProductFilter()
                .selectManufacturer(ASUS)
                .getPriceRangeProductFilter()
                .setProductPriceRange(500, 15000)
                .getTiles(1)
                .get(0);

        val expectedTitle = productTile.getProductTitle();
        val expectedPrice = productTile.getProductPrice();
        val productPage = productTile.openProductPage();

        assertEquals(expectedPrice, productPage.getItemPrice());
        assertEquals(expectedTitle, productPage.getItemTitle());
    }


    @Test
    public void verifyThatAmountOfReviewsOnItemPageIsTheSameAsOnListItemsPage() {
        val searchResultPage = new HomePage()
                .open()
                .getHeader()
                .searchForProduct("samsung s10");

        val searchResultsTitle = searchResultPage.getSearchResultsTitle();
        assertTrue(searchResultsTitle.contains("s10"));

        val reviewsAmountOnSearchResultPage = searchResultPage
                .getTiles(1)
                .get(0)
                .getReviewsAmount();

        val productPage = searchResultPage
                .getTiles(1)
                .get(0)
                .openProductPage();

        assertEquals(reviewsAmountOnSearchResultPage, productPage.getReviewsAmount());

        val reviewSectionTitle = productPage.openReviewsTab().getReviewTabTitle();
        assertEquals(reviewSectionTitle, "Отзывы покупателей о " + productPage.getItemTitle() + " " + productPage.getReviewsAmount());
    }
}
