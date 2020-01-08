package page_elements.filter_section;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

@Getter
public class FiltersBlock {
    private List<Filter> availableFilters = new ArrayList<>();

    public FiltersBlock(ElementsCollection filters) {
        filters.stream()
                .forEach(filterElement -> {
                    Filter filter = new Filter();
                    filter.setFilterTitle(filterElement.find(By.xpath(".//button[@class='sidebar-block__toggle']")).getText());
                    filter.setFilterOptions(filterElement.findAll((By.xpath(".//a[@class='checkbox-filter__link']"))));
                    availableFilters.add(filter);
                });

    }

    public void selectFilter(String filterTitle, String filterOptionTitle) {
        availableFilters.stream()
                .filter(s -> s.getFilterTitle().contains(filterTitle))
                .forEach(s -> s.selectFilterOption(filterOptionTitle));
    }

}


