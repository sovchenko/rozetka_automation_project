package page_objects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import page_elements.items_grid.ItemsGrid;

import static com.codeborne.selenide.Selenide.*;

public class HomePage extends BasePage {
    private ItemsGrid grid = new ItemsGrid($$x("//ul[@class='catalog-grid__cell']"));

    private SelenideElement getCategory(ElementsCollection collection, String categoryTitle){
        SelenideElement category = null;
        for(SelenideElement element: collection){
            if(element.getAttribute("href").contains(categoryTitle)){
                category = element;
                break;
            }
        }

        return category;
    }
    @Step("Open home page")
    // made this method as static and didn't use this
    // because got error that driver wasn't created or something like this
    public static HomePage openHomePage() {
        open("https://rozetka.com.ua/ua/");
        return new HomePage();
    }

    public ListItemsPage selectGoodCategory(String category, String subcategory){
        Selenide.sleep(4000);
        ElementsCollection categories = $$x("//a[@class='menu-categories__link']");
        getCategory(categories,category).hover();

        ElementsCollection subcategories = $$x("//a[@class='menu__link']");
        getCategory(subcategories,subcategory).click();

        return new ListItemsPage();
    }
}
