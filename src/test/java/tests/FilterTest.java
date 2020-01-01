package tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.HomePage;
import lombok.val;

public class FilterTest {

    @BeforeMethod
    public void setup() {
        Selenide.clearBrowserCookies();
        Configuration.startMaximized = true;
    }

    @Test

    public void verifyThatFilteredItemHasCorrectPriceAndTitle() {

        val listItemsPage = HomePage.openHomePage()
                .selectGoodSubcategory("telefony", "smartfon")
                .setPriceRange(1600, 10000)
                .selectFilter("Производитель", "Apple");

        String expectedTitle = listItemsPage.getItemName(2);
        int expectedPrice = listItemsPage.getItemPrice(2);
        String expectedRate = listItemsPage.getItemRate(2);

        val itemPage = listItemsPage.openItemsPage(2);
        String actualTitle = itemPage.getItemTitle();
        int actualPrice = itemPage.getItemPrice();
        String actualRate = itemPage.getItemRate();

        Assert.assertEquals(actualPrice, expectedPrice);
        Assert.assertEquals(actualTitle, expectedTitle);
        //Assert.assertEquals(actualRate,expectedRate);
    }

    @Test
    public void verifyThatAmountOfReviewsOnItemPageIsTheSameAsOnListItemsPage() {
        val searchResultPage = HomePage.openHomePage()
                .searchForTheItem("samsung s10");
        val searchResultsTitle = searchResultPage.getSearchResultsTitle();
        Assert.assertTrue(searchResultsTitle.contains("s10"));

        val amountOfFeedbacksOnSearchResultPage = searchResultPage.getAmountOfFeedbacks(1);

        val itemPage = searchResultPage.openItemsPage(1);
        val amountOfFeedbacksonItemPage = itemPage.getAmountOfReviews();

        Assert.assertEquals(amountOfFeedbacksonItemPage, amountOfFeedbacksOnSearchResultPage);

        val headerOfReviewSection = itemPage.openReviewsTab().getHeaderOfReviewsSection();
        Assert.assertEquals(headerOfReviewSection, "Отзывы покупателей о " + itemPage.getItemTitle() + " " + itemPage.getAmountOfReviews());


    }

}
