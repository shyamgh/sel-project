package pages.opensourcecms;

/**
 * @shyamhushangabadkar
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium_base.PageBase;

public class LoginPage extends PageBase implements IUIElements{



    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement userName(){
        return driver.findElement(By.id(LOGIN_USERNAME_ID));
    }

    public WebElement password(){
        return driver.findElement(By.id(LOGIN_PASSWD_ID));
    }

    public WebElement loginButton(){
        return driver.findElement(By.id(LOGIN_BTN));
    }

    public void login(String u, String p){
        userName().sendKeys(u);
        password().sendKeys(p);
        loginButton().click();
    }
}
