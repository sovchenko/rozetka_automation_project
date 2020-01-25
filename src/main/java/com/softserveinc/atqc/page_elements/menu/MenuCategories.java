package com.softserveinc.atqc.page_elements.menu;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MenuCategories {

    PhonesTVsElectronics("telefony-tv-i-ehlektronika"),
    COMPUTERS_LAPTOPS("computers-notebooks");
    private final String categoryName;

}
