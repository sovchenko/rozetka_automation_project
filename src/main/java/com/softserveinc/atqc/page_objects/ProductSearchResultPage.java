package com.softserveinc.atqc.page_objects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import java.util.List;
import java.util.stream.Collectors;
import static com.codeborne.selenide.Selenide.*;

public class ProductSearchResultPage extends ProductsListPage {

    public List<String> getItemTitles(int amountOfItems) {
        ElementsCollection element;
        if ($(By.name("search-list")).exists()) {
            element = $$x("//div[@class='g-i-tile-i-title']/a");
        } else {
            element = $$x("//span[@class='goods-tile__title']");
        }

        return element.stream()
                .map(SelenideElement::getText)
                .limit(amountOfItems)
                .collect(Collectors.toList());

    }

    public String getSearchResultsTitle() {
        return $x("//h1[@class='catalog-heading']").getText().replaceAll("[«,»]", "");
    }

}
