package page_elements.filter_section;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

@Getter
public class FiltersBlock {
    private List<Filter> availableFilters = new ArrayList<>();

    public FiltersBlock(ElementsCollection filters) {
        //iterate through filter collection
        //get name and options of each filter
        //and set it for object
        for (SelenideElement element : filters) {
            Filter filter = new Filter();
            filter.setFilterTitle(element.find(By.xpath(".//button[@class='sidebar-block__toggle']")).getText());
            filter.setFilterOptions(element.findAll(By.xpath(".//li[@class='checkbox-filter__item']")));
            availableFilters.add(filter);
        }
    }

    public void selectFilter(String filterTitle, String filterOptionTitle) {
        for (Filter filter : availableFilters) {
            if (filter.getFilterTitle().equalsIgnoreCase(filterTitle)) {
                filter.selectFilterOption(filterOptionTitle);
                break;
            }
        }
    }

    public void printAllFilters(){
        for(Filter filter : availableFilters){
            System.out.println(filter.getFilterTitle());
        }
    }

    public void printAllFilterOptions(){
        System.out.println();
    }
}


