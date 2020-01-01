package page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class HomePage extends BasePage {

    private SelenideElement getCategory(ElementsCollection collection, String categoryTitle) {
        SelenideElement category = null;
        for (SelenideElement element : collection) {
            if (element.getAttribute("href").contains(categoryTitle)) {
                category = element;
                break;
            }
        }

        return category;
    }

    @Step("Open home page")
    public static HomePage openHomePage() {
        open("https://rozetka.com.ua/");

        Selenide.sleep(2000);
        return new HomePage();
    }

    public ListItemsPage selectGoodSubcategory(String category, String subcategory) {
        getCategory($$x("//a[@class='menu-categories__link']"), category).hover();
        getCategory($$x("//a[@class='menu__link']"), subcategory).click();

        return new ListItemsPage();
    }
}
