/**
 * @shyamhushangabadkar
 */
package selenium_base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.ExcelUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

abstract public class SeleniumBase{

	protected static String CHROME_EXE = Constants.Path_TestData + File.separator + "chromedriver.exe";
	protected static ThreadLocal<WebDriver> threadedDriver = new ThreadLocal<WebDriver>();
	protected ExcelUtils excelUtils;
	protected WebDriver driver;

	protected void initExcel(String excelFilePath, String excelFileName){
		excelUtils = new ExcelUtils();
		try {
			excelUtils.setExcelFile(excelFilePath,excelFileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

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

	public WebElement getWebElement(int rowNumber){
		String xpath = excelUtils.getCellData(rowNumber,"Xpath");
		String type = excelUtils.getCellData(rowNumber,"Type");
		return getDriver().findElement(By.xpath(xpath));
	}

}