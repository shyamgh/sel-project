/**
 * @shyamhushangabadkar
 */
package utils;

import org.openqa.selenium.*;
import selenium_base.TestBase;

public class FileUtils extends TestBase {

	public void uploadFile(String filePath){
		getDriver().get("https://tus.io/demo.html");
		String id = "js-file-input";
		WebElement upldBox = getDriver().findElement(By.id(id));

		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String script = "arguments[0].removeAttribute('readonly','readonly')";
		js.executeScript(script, upldBox);

		upldBox.sendKeys(filePath);
	}

}