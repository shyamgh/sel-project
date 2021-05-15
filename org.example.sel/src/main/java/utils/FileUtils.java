package utils;

import org.openqa.selenium.*;
import selenium_base.SeleniumBase;

public class FileUtils {

	public void uploadFile(String filePath){
//		driver().get("https://tus.io/demo.html");
//		String id = "js-file-input";
		SeleniumBase.getDriver().get("file:///D:/Development/Selenium%20Project/uploadf.html");
		String id = "newloanin";
		WebElement upldBox = SeleniumBase.getDriver().findElement(By.id(id));

		JavascriptExecutor js = (JavascriptExecutor) SeleniumBase.getDriver();
		String script = "arguments[0].removeAttribute('readonly','readonly')";
		js.executeScript(script, upldBox);

		upldBox.sendKeys(filePath);
	}

}