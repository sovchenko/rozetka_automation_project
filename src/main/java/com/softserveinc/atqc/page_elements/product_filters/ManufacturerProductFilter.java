package com.softserveinc.atqc.page_elements.product_filters;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.softserveinc.atqc.page_objects.ProductsListPage;

import static com.codeborne.selenide.Selenide.*;

public class ManufacturerProductFilter {

    public ProductsListPage selectManufacturer(String manufacturer) {
        SelenideElement manufacturerCheckbox = $x("//a[@class='checkbox-filter__link' and contains(@href,'producer="
                + manufacturer.toLowerCase()
                + "')]");

        manufacturerCheckbox.click();
        return new ProductsListPage();
    }

    public ManufacturerProductFilter searchManufacturer(String manufacturer){
        $x("//input[@name='searchline']").sendKeys(manufacturer);
        return this;
    }

    public ManufacturerProductFilter expandManufacturerFilter(){
        $x("//button[contains(text(),'Виробник') or contains(text(),'Производитель')]").click();

        return this;
    }

    public ManufacturerProductFilter hideManufacturerFilter(){
        return expandManufacturerFilter();
    }

    public ManufacturerProductFilter expandAlphabetMenu(){
        $("button.sidebar-alphabet__toggle").click();

        return this;
    }

    public ManufacturerProductFilter hideAlphabetMenu(){
        return expandAlphabetMenu();
    }

    public ManufacturerProductFilter selectSymbolInAlphabetMenu(String symbol){
        $x("//a[@class='sidebar-alphabet__glyph' and text()=" + symbol +"]").click();

        return this;
    }
}
