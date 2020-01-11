package com.softserveinc.atqc.page_elements.product_filters;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;

@Getter
@Setter
public class ProductFilter {
    // need of this class should be considered
    // move here all methods which are same for all filter
    // e.g hide-expand

    private String filterTitle;
    private ElementsCollection filterOptions;

    public void selectFilterOption(String filterOptionTitle) {
        filterOptions.stream()
                .filter(option ->
                        option.find(By.xpath(".//label"))
                        .getText()
                        .contains(filterOptionTitle))
                .limit(1)
                .forEach(SelenideElement::click);
    }
}