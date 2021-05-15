package tests;

import selenium_base.TestBase;
import org.testng.annotations.Test;
import utils.FileUtils;

public class TC2 extends TestBase {

	@Test
	public void t1(){
		String filePath = "D:\\Development\\Selenium Project\\org.example.sel\\src\\main\\java\\f1.txt";
		new FileUtils().uploadFile(filePath);
	}

	@Test
	public void t2() throws InterruptedException {
		clearCache();
	}

}