package page_objects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class UserAccountPage extends BasePage{

    private SelenideElement signOutLink = $("#profile_signout");

    public void logOutUsingLinkInProfile(){
        signOutLink.click();
    }
}
