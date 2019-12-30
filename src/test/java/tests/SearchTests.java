package tests;

import lombok.val;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static page_objects.HomePage.openHomePage;

public class SearchTests {
    // open page
    // search for item
    // get list of the items title
    // verify that first five item title have searched term
    @Test
    public void verifyThatSearchedTermIsPresentInItemTitle() {
        val item = "samsung galaxy s8";
        List<String> titlesOfFirstFiveItems = openHomePage()
                .searchForTheItem(item)
                .getItemTitles(5);

        for (String title : titlesOfFirstFiveItems) {
            Assert.assertTrue(title.contains(item));
        }
    }
}
