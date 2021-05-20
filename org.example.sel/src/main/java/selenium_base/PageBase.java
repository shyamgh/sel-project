/**
 * @shyamhushangabadkar
 */
package selenium_base;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class PageBase extends SeleniumBase {

    private static Logger logger = Logger.getLogger(PageBase.class);
    public static int TIMEOUT_SECONDS = 60;

    public void selectDropdownItem(WebElement element, String valueToSelect) {
        try {
            Select dropdown = new Select(element);
            dropdown.selectByVisibleText(valueToSelect);
        }
        catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public WebElement waitForVisibilityOfElement(By locator, long timeoutSeconds) {
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), timeoutSeconds);
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
        catch (Exception e) {
            logger.error(e.getMessage());
        }
        return element;
    }

    public void hover(WebElement element) {
        sleepms(200);
        Actions action = new Actions(getDriver());
        // move to the element to hover
        action.moveToElement(element).build().perform();
        sleepms(500);
    }

    public void sleepms(long milliseconds) {
        long end_time = System.currentTimeMillis() + milliseconds;
        while (System.currentTimeMillis() < end_time) {}
    }

    public static Boolean waitTillEnabled(final By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT_SECONDS);
        Boolean enabled = wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.findElement(locator).isEnabled();
            }
        });
        return enabled;
    }

    public void waitAndClick(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT_SECONDS);
            WebElement readyToClick = wait.until(ExpectedConditions.elementToBeClickable(locator));
            readyToClick.click();
        }
        catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public static void waitForElementPresent(final By by, long timeoutSeconds) {
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(getDriver(), timeoutSeconds)
                .ignoring(StaleElementReferenceException.class);
        wait.until(new ExpectedCondition<Boolean>() {

            @Override
            public Boolean apply(WebDriver webDriver) {
                WebElement element = webDriver.findElement(by);
                return element != null && element.isDisplayed();
            }
        });
    }

    public static void waitForIframeAndSwitchToIt(String iframeID) {
        logger.info(String.format("waitForIframeAndSwitchToIt(%s)", iframeID));
        try {
            getDriver().switchTo().defaultContent();
            getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            List<WebElement> frames = getDriver().findElements(By.id(iframeID));
            getDriver().manage().timeouts().implicitlyWait(TIMEOUT_SECONDS, TimeUnit.SECONDS);
            if (frames.size() > 0)
                getDriver().switchTo().frame(frames.get(0));
            else {
                WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT_SECONDS);
                wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeID));
            }
        }
        catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public void switchToDefaultContentAndFrame() {
        getDriver().switchTo().defaultContent();
    }

}


