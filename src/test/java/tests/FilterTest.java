package tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.HomePage;
import lombok.val;

public class FilterTest {
    //open page
    //select category
    //select subcategory
    //select price range
    //select brand of the phone
    //select third item (save title, price and amount of stars)
    //verify that on the new page same phone and it has same price
    //verify that amount of the stars is the same

    //name of the test should be enhanced
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
                .selectFilter("Производитель", "LG");

        String expectedTitle = listItemsPage.getItemName(0);
        int expectedPrice = listItemsPage.getItemPrice(0);
        String expectedRate = listItemsPage.getItemRate(0);

        val itemPage = listItemsPage.openItemsPage(0);
        String actualTitle = itemPage.getItemTitle();
        int actualPrice = itemPage.getItemPrice();
        String actualRate = itemPage.getItemRate();
//        Selenide.sleep(20000);

        Assert.assertEquals(actualPrice, expectedPrice);
        Assert.assertEquals(actualTitle, expectedTitle);

        //Assert.assertEquals(actualRate,expectedRate);
    }

    @Test
    public void verifyThatAmountOfReviewsOnItemPageIsTheSameAsOnListItemsPage() {
        //log in
        //enter ipad 16gb
        // verify that title of the search result contains ipad 16gb
        //open item
        // verify that amount of the feedbacks on listpage is the same as on item page
        // click on feedback link and verify that feedback page is opened
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
