package page.objects;

import base.BasePage;
import driver.DemoqaDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LeftPannel extends BasePage {
    public LeftPannel() {
        super(DemoqaDriver.getInstance().getWebDriver());
        PageFactory.initElements(driver,this);
    }
    public void clickCategory(String name){
        String locator = String.format("//div[.='%s']", name);
        WebElement category = driver.findElement(By.xpath(locator));
        wait.until(ExpectedConditions.visibilityOf(category));
        category.click();
    }
    public void clickSubCategory(String name){
        String locator = String.format("//span[.='%s']", name);
        WebElement subCategory = driver.findElement(By.xpath(locator));
        wait.until(ExpectedConditions.visibilityOf(subCategory));
        subCategory.click();
    }
}
