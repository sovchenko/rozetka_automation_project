package com.softserveinc.atqc.page_objects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static java.util.stream.Collectors.toList;

public class ProductSearchResultPage extends ProductsListPage {

    public List<String> getItemTitles(int amountOfItems) {
        ElementsCollection element;
        //there are two possible versions of the application
        //each has different locators
        if ($(By.name("search-list")).exists()) {
            element = $$x("//div[@class='g-i-tile-i-title']/a");
        } else {
            element = $$x("//span[@class='goods-tile__title']");
        }

        return element.stream()
                .map(SelenideElement::getText)
                .limit(amountOfItems)
                .collect(toList());

    }

    public String getSearchResultsTitle() {

        return $x("//h1[@class='catalog-heading']").getText().replaceAll("[«,»]", "");
    }
}
