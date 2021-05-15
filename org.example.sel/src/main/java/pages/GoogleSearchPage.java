package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium_base.PageBase;

public class GoogleSearchPage extends PageBase {
    public static final String SRCH_BTN_XPATH = "//input[@name='q']";

    public WebElement searchBtn(){
        return getDriver().findElement(By.xpath(SRCH_BTN_XPATH));
    }
}
