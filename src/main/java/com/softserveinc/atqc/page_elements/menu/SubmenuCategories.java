package com.softserveinc.atqc.page_elements.menu;

import lombok.Getter;

@Getter
public enum SubmenuCategories {
    SMARTPHONES("smartfon"),
    MOBILE_PHONES("mob-phones");

    private String subcategoryName;

    SubmenuCategories(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }
}
