/**
 * @shyamhushangabadkar
 */
package tests.others;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;
import selenium_base.TestBase;

public class TC1 extends TestBase {
	
	@Test
	public void test1() {
		System.out.println("This is test1");
		getDriver().get("http://www.google.com");

		GoogleSearchPage gsp = new GoogleSearchPage();
		gsp.searchBtn().sendKeys("Selenium");
		gsp.searchBtn().submit();

		WebElement w = getDriver().findElement(By.partialLinkText("Selenium"));
		Assert.assertNotEquals(w, null);
	}
	
	@Test
	public void test2() {
		System.out.println("This is test2");
		getDriver().get("http://www.google.com");

		GoogleSearchPage gsp = new GoogleSearchPage();
		gsp.searchBtn().sendKeys("Testing");
		gsp.searchBtn().submit();

		WebElement w = getDriver().findElement(By.partialLinkText("Testing"));
		Assert.assertNotEquals(w, null);
	}

	@Test
	public void test3() {
		System.out.println("This is test3");
		getDriver().get("http://www.google.com");

		GoogleSearchPage gsp = new GoogleSearchPage();
		gsp.searchBtn().sendKeys("Automation");
		gsp.searchBtn().submit();

		WebElement w = getDriver().findElement(By.partialLinkText("Automation"));
		Assert.assertNotEquals(w, null);
	}

}
