package tests;

import lombok.val;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static page_objects.HomePage.openHomePage;

public class SearchTest {

    @Test
    public void verifyThatSearchedTermIsPresentInItemTitle() {
        val item = "iPhone 11";

        List<String> titlesOfFirstFiveItems = openHomePage()
                .searchForTheItem(item)
                .getItemTitles(5);

        for (String title : titlesOfFirstFiveItems) {
            Assert.assertTrue(title.contains(item));
        }
        // titlesOfFirstFiveItems.forEach(string -> Assert.assertTrue(string.contains(item)));
        // or harmcrest matchers
    }
}
