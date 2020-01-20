package com.softserveinc.atqc.page_elements.menu;

import lombok.Getter;

@Getter
public enum MenuCategories {

    PhonesTVsElectronics("telefony-tv-i-ehlektronika"), ComputersLaptops("computers-notebooks");
    private String categoryName;

    MenuCategories(String categoryName) {
        this.categoryName = categoryName;
    }

}
