package selenium_base;

import org.openqa.selenium.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

abstract public class TestBase extends SeleniumBase {

	protected void initDriver(){
		WebDriver d = getNewDriver(5);
		setDriver(d);
	}

	@BeforeMethod
	protected void setUp(){
		initDriver();
	}

	@AfterMethod
	protected void tearDown(){
		getDriver().close();
	}

}


