package com.softserveinc.atqc.tests;

import com.softserveinc.atqc.page_objects.HomePage;
import lombok.val;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class SearchTest {

    @Test
    public void verifyThatSearchedTermIsPresentInItemTitle() {
        val item = "iPhone 11";

        List<String> titlesOfFirstFiveItems = new HomePage()
                .open()
                .getHeader()
                .searchForProduct(item)
                .getItemTitles(5); //TODO: you should work with product tile object here

        for (String title : titlesOfFirstFiveItems) {
            assertTrue(title.contains(item));
        }
    }
}
