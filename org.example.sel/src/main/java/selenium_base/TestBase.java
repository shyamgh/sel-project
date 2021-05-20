/**
 * @shyamhushangabadkar
 */
package selenium_base;

import org.openqa.selenium.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ExcelUtils;

import java.io.IOException;

abstract public class TestBase extends SeleniumBase {

//	protected ExcelUtils excelUtils;

	protected void initDriver(){
		WebDriver d = getNewDriver(5);
		setDriver(d);
	}

	@BeforeMethod
	protected void setUpSuper(){
		initDriver();
	}

	@AfterMethod
	protected void tearDown(){
		getDriver().close();
	}

	public void testStep(int rowNumber){
		WebElement w = getWebElement(rowNumber);
		String action = excelUtils.getCellData(rowNumber,"Action");

		action = action.toLowerCase();
		switch (action){
			case "click":
				w.click();
				break;
			case "enter":
				String data = excelUtils.getCellData(rowNumber,"Value");
				w.sendKeys(data);
				break;
			default:
				new Exception("Invalid action in sheet");
		}
	}

}


