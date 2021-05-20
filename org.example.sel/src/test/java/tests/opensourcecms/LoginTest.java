package tests.opensourcecms;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.opensourcecms.LoginPage;
import selenium_base.Constants;
import selenium_base.TestBase;

public class LoginTest extends TestBase {

    @Test
    public void loginTest() {
        WebDriver driver = getDriver();
        driver.get(Constants.URL);
        LoginPage lp = new LoginPage(driver);
        lp.login("opensourcecms", "opensourcecms");
    }

}
