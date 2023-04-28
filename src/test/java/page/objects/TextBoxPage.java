package page.objects;

import base.BasePage;
import driver.DemoqaDriver;
import entity.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TextBoxPage extends BasePage {

    @FindBy(id="userName")
    private WebElement userNameTxt;

    @FindBy(id="userEmail")
    private WebElement userEmailTxt;

    @FindBy(id="currentAddress")
    private WebElement currentAddressTxt;

    @FindBy(id="permanentAddress")
    private WebElement permanentAddressTxt;

    @FindBy(id="submit")
    private WebElement submitBtn;

    public TextBoxPage() {
        super(DemoqaDriver.getInstance().getWebDriver());
        PageFactory.initElements(this.driver, this);
    }
    public void fillTextBoxForm(User u){
        this.userNameTxt.sendKeys(u.getUserName());
        this.userEmailTxt.sendKeys(u.getEmail());
        this.currentAddressTxt.sendKeys(u.getCurrentAddress());
        this.permanentAddressTxt.sendKeys(u.getPermanentAddress());
        this.submitBtn.click();
    }

    public String getText(String value){
        String locator = String.format("//p[contains(.,'%s')]",value);
        WebElement webElement = driver.findElement(By.xpath(locator));
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }
    public Boolean isTextDisplayed(String value){
        String locator = String.format("//p[contains(.,'%s')]",value);
        WebElement webElement = driver.findElement(By.xpath(locator));
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.isDisplayed();
    }
}
