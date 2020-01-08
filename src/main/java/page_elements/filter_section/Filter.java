package page_elements.filter_section;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import page_objects.ListItemsPage;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class Filter {
    private String filterTitle;
    private ElementsCollection filterOptions;

    public void selectFilterOption(String filterOptionTitle) {
        filterOptions.stream()
                .filter(option -> option.find(By.xpath(".//label")).getText().contains(filterOptionTitle))
                .limit(1)
                .forEach(SelenideElement::click);
    }
}


