package page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import versions_of_rozetka.BaseRozetkaVersion;
import versions_of_rozetka.NewRozetkaVersion;
import versions_of_rozetka.OldRozetkaVersion;

import static com.codeborne.selenide.Selenide.*;

public class ListItemPage {

    @Step("Verify that term entered in search field is present in title of the first 5 items")
    public boolean verifyThatItemsContainsSearchedTerm(String searchedTerm) {
        boolean isPresent = false;
        if ($("div.g-i-tile-l.clearfix").exists()) {
            ElementsCollection itemsInGrid = $("div.g-i-tile-l.clearfix").
                    findAll("div[data-location='SearchResults'");
            BaseRozetkaVersion version = new NewRozetkaVersion();
            isPresent = version.isPresentInItemTitle(itemsInGrid, searchedTerm);
        } else if ($("app-search-goods > ul").exists()) {
            ElementsCollection itemsInGrid = $$("app-search-goods > ul > li");
            BaseRozetkaVersion version = new OldRozetkaVersion();
            isPresent = version.isPresentInItemTitle(itemsInGrid, searchedTerm);
        }
        return isPresent;
    }
}
