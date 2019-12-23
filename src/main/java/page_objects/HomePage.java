package page_objects;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class HomePage extends BasePage {

    @Step("Open home page")
    // made this method as static and didn't use this
    // because got error that driver wasn't created or something like this
    public static HomePage openHomePage() {
        open("https://rozetka.com.ua/ua/");
        return new HomePage();
    }
}
