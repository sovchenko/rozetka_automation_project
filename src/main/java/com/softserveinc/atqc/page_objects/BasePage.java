package com.softserveinc.atqc.page_objects;

import com.softserveinc.atqc.page_elements.Header;
import lombok.Getter;

@Getter
public abstract class BasePage {
    private Header header = new Header();
}
