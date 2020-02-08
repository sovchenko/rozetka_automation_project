package com.softserveinc.atqc.page_elements.menu;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SubmenuCategory {
    SMARTPHONES("smartfon"),
    MOBILE_PHONES("mob-phones");

    private final String subcategoryName;

}
