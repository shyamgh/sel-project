package selenium_base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class PageBase extends SeleniumBase {

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

	protected static WebDriver driver(){
		return getDriver();
	}


}


