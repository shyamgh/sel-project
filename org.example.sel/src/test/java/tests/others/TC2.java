/**
 * @shyamhushangabadkar
 */
package tests.others;

import selenium_base.Constants;
import selenium_base.TestBase;
import org.testng.annotations.Test;
import utils.FileUtils;
import java.io.File;

public class TC2 extends TestBase {

	@Test
	public void t1(){
		String filePath = Constants.Path_TestData+ File.separator+"f1.txt";
		new FileUtils().uploadFile(filePath);
	}

	@Test
	public void t2() throws InterruptedException {
		clearCache();
	}

}