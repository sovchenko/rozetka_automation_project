package page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    protected SelenideElement topUserAccountLink = $("a.header-topline__user-link");

    public void logIn(String email, String password) {
        topUserAccountLink.shouldBe(Condition.enabled).click();
        $("#auth_email").sendKeys(email);
        $("#auth_pass").sendKeys(password);
        $(".auth-modal__remember-checkbox").click();
        $("div.auth-modal__form-bottom > button ").shouldBe(Condition.enabled).click();
    }
    public String getNameOfLoggedInUser(String name){
        return topUserAccountLink.waitUntil(Condition.exactTextCaseSensitive(name),4000).getText();
    }

    public UserAccountPage navigateToUserAccount(){
        topUserAccountLink.hover().click();
        return new UserAccountPage();
    }

    public void logOutUsingTopHeader(){
        topUserAccountLink.hover();

    }

}
