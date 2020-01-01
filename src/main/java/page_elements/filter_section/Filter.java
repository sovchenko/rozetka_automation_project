package page_elements.filter_section;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;

@Getter
@Setter
public class Filter {
    private String filterTitle;
    private ElementsCollection filterOptions;

    public void selectFilterOption(String filterTitle) {
        for (SelenideElement filter : filterOptions) {
            String optionTitle = filter.find(By.xpath(".//label")).getText();
            if (optionTitle.contains(filterTitle)) {
                filter.click();
                break;
            }
        }
    }
}


