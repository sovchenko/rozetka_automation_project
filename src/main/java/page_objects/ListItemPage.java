package page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ListItemPage {

    @Step("Verify that term entered in search field is present in title of the first 5 items")
    public boolean verifyThatItemsContainsSearchedTerm(String searchedTerm) {
        ElementsCollection listOfTheItems = $(By.name("search_list")).findAll("div[data-location='SearchResults']");

        boolean isPresentInItemTitle = false;
        int indexOfTheLastItemThatShouldBeVerified = 4;

        for (; indexOfTheLastItemThatShouldBeVerified >= 0; indexOfTheLastItemThatShouldBeVerified--) {

            String titleOfTheItem = listOfTheItems.get(indexOfTheLastItemThatShouldBeVerified).
                    find("div > div > div > div > div.g-i-tile-i-title.clearfix > a").getText()
                    .toLowerCase();

            if (titleOfTheItem.contains(searchedTerm)) {
                isPresentInItemTitle = true;
            } else {
                System.out.println(titleOfTheItem);
                break;
            }
        }
        return isPresentInItemTitle;
    }
}
