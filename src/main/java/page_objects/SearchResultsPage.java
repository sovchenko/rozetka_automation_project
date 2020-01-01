package page_objects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import page_elements.items_grid.ItemsGrid;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;


public class SearchResultsPage extends ListItemsPage{

    public List<String> getItemTitles(int amountOfItems) {
        List<String> titlesOfFirstFiveItems;
        if ($(By.name("search-list")).exists()) {
            titlesOfFirstFiveItems = $$x("//div[@class='g-i-tile-i-title']/a")
                    .stream()
                    .map(SelenideElement::getText)
                    .limit(amountOfItems)
                    .collect(Collectors.toList());
        } else {
            titlesOfFirstFiveItems = $$x("//span[@class='goods-tile__title']")
                    .stream()
                    .map(SelenideElement::getText)
                    .map(String::toLowerCase)
                    .limit(amountOfItems)
                    .collect(Collectors.toList());
        }

        return titlesOfFirstFiveItems;
    }

    public String getSearchResultsTitle(){
        return $x("//h1[@class='catalog-heading']").getText().replaceAll("[«,»]","");
    }

}
