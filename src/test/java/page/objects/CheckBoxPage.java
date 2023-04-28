package page.objects;

import base.BasePage;
import driver.DemoqaDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CheckBoxPage extends BasePage {
    @FindBy(xpath = "//button[@aria-label='Expand all']")
    private WebElement expandAll;
    public CheckBoxPage() {
        super(DemoqaDriver.getInstance().getWebDriver());
        PageFactory.initElements(this.driver, this);
    }
    public void clickExpandAll(){
        wait.until(ExpectedConditions.visibilityOf(expandAll));
        expandAll.click();
    }
    private void ckeckNode(String name){
        String locator = String.format("//span[@class='rct-title' and .='%s']", name);
        WebElement webElement = driver.findElement(By.xpath(locator));
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();
    }

    public void checkNodes(List<String> names){
        for (String name: names ) {
            ckeckNode(name);
        }
    }
    public String getActualNodesChecked(){
        List<WebElement> nodesChecked = driver.findElements(By.xpath("//span[@class='text-success']"));
        String actual = "";
        Integer i=0;
        for (WebElement e:nodesChecked ) {
            if (i==0) {
                actual = String.format("%s", e.getText());
                i=1;
            }
            else{
            actual = String.format("%s %s",actual, e.getText());
            }
        }
        return actual;
    }
}
