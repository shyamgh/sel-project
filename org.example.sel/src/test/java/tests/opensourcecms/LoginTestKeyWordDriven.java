package tests.opensourcecms;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium_base.Constants;
import selenium_base.TestBase;
import java.io.File;

public class LoginTestKeyWordDriven extends TestBase {

    static String excelFilePath = Constants.Path_TestData+File.separator+"data.xls";

    @BeforeMethod
    public void setUp(){
        super.initExcel(excelFilePath, "Login");
    }

    @Test
    public void loginTestKeyWordDriven() {
        WebDriver driver = getDriver();
        driver.get(Constants.URL);
        testStep(1);
        testStep(2);
        testStep(3);
    }
    
}
