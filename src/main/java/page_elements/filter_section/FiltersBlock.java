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
        for (SelenideElement element : filters) {
            Filter filter = new Filter();
            filter.setFilterTitle(element.find(By.xpath(".//button[@class='sidebar-block__toggle']")).getText());
            filter.setFilterOptions(element.findAll(By.xpath(".//a[@class='checkbox-filter__link']")));
            availableFilters.add(filter);
        }

    }

    public void selectFilter(String filterTitle, String filterOptionTitle) {
        for (Filter filter : availableFilters) {
            if (filter.getFilterTitle().contains(filterTitle)) {
                filter.selectFilterOption(filterOptionTitle);
                break;
            }
        }
    }

}


