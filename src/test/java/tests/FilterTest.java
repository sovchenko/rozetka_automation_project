package tests;


import com.codeborne.selenide.Selenide;
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
    @Test
    public void verifyFiltering() {

        val itemPage = HomePage.openHomePage()
                .selectGoodCategory("telefony", "smartfon")
               // .setPriceRange(1600,10000)
                .selectFilter("Производитель", "LG")
                .openItemsPage(2);
                Selenide.sleep(5000);

    }

}
