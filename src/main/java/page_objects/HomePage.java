package page_objects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class HomePage extends BasePage {

    @Step("Open home page")
    public static final HomePage openPage() {
        open("https://rozetka.com.ua/");
        return new HomePage();
    }
}
