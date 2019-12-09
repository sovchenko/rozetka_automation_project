package data_providers;

import org.testng.annotations.DataProvider;

public class LoginData {
    @DataProvider(name = "validLogin")
    public Object[][] validLoginData() {
        return new Object[][]{
                {"ezbooksforme@gmail.com", "Pa55word"}
        };
    }
}
