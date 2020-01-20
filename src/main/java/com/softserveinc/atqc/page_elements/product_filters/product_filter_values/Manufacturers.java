package com.softserveinc.atqc.page_elements.product_filters.product_filter_values;

import lombok.Getter;

@Getter
public enum Manufacturers {
    Apple("Apple"), Samsung("Samsung"), Xiaomi("Xiaomi"), Huawei("Huawei"),
    Meizu("Meizu"), LG("LG"), Asus("Asus");

    private String name;

    Manufacturers(String name) {
        this.name = name;
    }
}
