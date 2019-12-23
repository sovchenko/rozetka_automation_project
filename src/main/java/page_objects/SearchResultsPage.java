package page_objects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;


public class SearchResultsPage {
    public List<String> getTitlesOfFirstFiveItems() {
        List<String> titlesOfFirstFiveItems;
        if ($(By.name("search-list")).exists()) {
            titlesOfFirstFiveItems = $$x("//div[@class='g-i-tile-i-title']/a")
                    .stream()
                    .map(SelenideElement::getText)
                    .limit(5)
                    .collect(Collectors.toList());
        } else {
            titlesOfFirstFiveItems = $$x("//span[@class='goods-tile__title']")
                    .stream()
                    .map(SelenideElement::getText)
                    .map(String::toLowerCase)
                    .limit(5)
                    .collect(Collectors.toList());
        }

        return titlesOfFirstFiveItems;
    }
}
