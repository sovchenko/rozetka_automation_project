package com.softserveinc.atqc.page_elements.menu;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MenuCategory {
    PHONES_TV_ELECTRONICS("telefony-tv-i-ehlektronika"),
    COMPUTERS_LAPTOPS("computers-notebooks");

    private final String categoryName;

}
