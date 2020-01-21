package com.softserveinc.atqc.tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.softserveinc.atqc.page_objects.HomePage;
import lombok.val;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.softserveinc.atqc.page_elements.menu.MenuCategories.PhonesTVsElectronics;
import static com.softserveinc.atqc.page_elements.menu.SubmenuCategories.SmartPhones;
import static com.softserveinc.atqc.page_elements.product_filters.product_filter_values.Manufacturers.Asus;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductFilterTest {

    @BeforeMethod
    public void setup() {
        Selenide.clearBrowserCookies();
        Configuration.startMaximized = true;
    }

    @Test
    public void verifyThatFilteredItemHasCorrectPriceAndTitle() {
        val productTile = new HomePage()
                .open()
                .hoverMenuCategory(PhonesTVsElectronics.getCategoryName())
                .selectProductSubcategory(SmartPhones.getSubcategoryName())
                .getManufacturerProductFilter()
                .selectManufacturer(Asus.getName())
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
