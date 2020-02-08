package com.softserveinc.atqc.page_elements.product_filters;

import com.softserveinc.atqc.page_elements.product_filters.product_filter_values.Manufacturer;
import com.softserveinc.atqc.page_objects.ProductsListPage;
import io.qameta.allure.Step;
import lombok.val;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class ManufacturerProductFilter {

    @Step("Select manufacturer")
    public ProductsListPage selectManufacturer(Manufacturer manufacturer) {

        val checkboxXpath = format("//a[@class='checkbox-filter__link' and contains(@href,'producer=%s')]",
                manufacturer.name()
                        .toLowerCase());
        $x(checkboxXpath).click();

        return new ProductsListPage();
    }

    @Step("Search for manufacturer")
    public ManufacturerProductFilter searchManufacturer(String manufacturer) {
        $x("//input[@name='searchline']").setValue(manufacturer);

        return this;
    }

    @Step("Expand 'Manufacturer' filter section")
    public ManufacturerProductFilter expandManufacturerFilter() {
        $x("//div[@class='sidebar-alphabet']/preceding::button[1]");

        return this;
    }

    @Step("Hide manufacturer filter")
    public ManufacturerProductFilter hideManufacturerFilter() {
        return expandManufacturerFilter();
    }

    @Step("Expand alphabetical menu")
    public ManufacturerProductFilter expandAlphabetMenu() {
        $("button.sidebar-alphabet__toggle").click();

        return this;
    }

    @Step("Hide alphabetical menu")
    public ManufacturerProductFilter hideAlphabetMenu() {
        return expandAlphabetMenu();
    }

    @Step("Select symbol in alphabetical menu")
    public ManufacturerProductFilter selectSymbolInAlphabetMenu(String symbol) {
        val symbolXpath = String.format("//a[@class='sidebar-alphabet__glyph' and contains(text(),'%s')]", symbol);
        $x(symbolXpath).click();

        return this;
    }
}
