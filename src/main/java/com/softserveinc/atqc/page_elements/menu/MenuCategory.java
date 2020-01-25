package com.softserveinc.atqc.page_elements.menu;

import lombok.Getter;

@Getter
public enum MenuCategory {

    PHONES_TV_ELECTRONICS("telefony-tv-i-ehlektronika"),
    COMPUTERS_LAPTOPS("computers-notebooks");
    private String categoryName;

    MenuCategory(String categoryName) {
        this.categoryName = categoryName;
    }

}
