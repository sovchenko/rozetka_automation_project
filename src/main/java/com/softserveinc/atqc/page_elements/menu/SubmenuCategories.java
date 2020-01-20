package com.softserveinc.atqc.page_elements.menu;

import lombok.Getter;

@Getter
public enum SubmenuCategories {
    SmartPhones("smartfon"), MobilePhones("mob-phones");

    private String subcategoryName;

    SubmenuCategories(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }
}
