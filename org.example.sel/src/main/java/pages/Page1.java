/**
 * @shyamhushangabadkar
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium_base.PageBase;

public class Page1 extends PageBase {
    public static final String UPD_BTN_ID = "newloanin";

    public WebElement uploadBtn(){
        return getDriver().findElement(By.id(UPD_BTN_ID));
    }


}
