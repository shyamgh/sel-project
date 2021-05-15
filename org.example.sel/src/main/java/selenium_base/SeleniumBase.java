package selenium_base;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

abstract public class SeleniumBase{

	protected static String CHROME_EXE = "D:\\Development\\Selenium Project\\chromedriver.exe";
	protected static ThreadLocal<WebDriver> threadedDriver = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver(){
		return threadedDriver.get();
	}

	public void setDriver(WebDriver driver){
		threadedDriver.set(driver);
	}

	public static DesiredCapabilities getCapability(){
		System.setProperty("webdriver.chrome.driver",CHROME_EXE);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("disable-infobars");
		chromeOptions.addArguments("start-maximized");

		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability("applicationCacheEnabled", false);
		cap.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		return cap;
	}

	public static WebDriver getNewDriver(int timeout){
		WebDriver driver = new ChromeDriver(getCapability());
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		return driver;
	}

	public void clearCache() throws InterruptedException {
		SeleniumBase.getDriver().get("chrome://settings/clearBrowserData");
		Thread.sleep(2000);
		Actions a = new Actions(SeleniumBase.getDriver());
		a.sendKeys(Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.ENTER);
		a.perform();
		Thread.sleep(200);
	}

}