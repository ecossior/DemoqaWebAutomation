package utils;

import driver.DemoqaDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Common {
    public static void clickButtonJS(WebElement webElement) throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor) DemoqaDriver.getInstance().getWebDriver();
        executor.executeScript("arguments[0].click();", webElement);
        Thread.sleep(2000);
    }
}
