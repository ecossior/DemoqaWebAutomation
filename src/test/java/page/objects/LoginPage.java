package page.objects;

import base.BasePage;
import driver.DemoqaDriver;
import entity.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.StoreData.SData;

import java.io.IOException;

public class LoginPage extends BasePage {
    @FindBy(id = "userName")
    private WebElement userNameTxt;
    @FindBy(id = "password")
    private WebElement passwordTxt;
    @FindBy(id = "login")
    private WebElement loginBtn;
    @FindBy(id="userName-value")
    private WebElement userNameValueLbl;

    public LoginPage() {
        super(DemoqaDriver.getInstance().getWebDriver());
        PageFactory.initElements(this.driver,this);
    }
    public void loadPage() throws IOException {
        driver.get(SData("url"));
    }

    public void loginToWeb(User user){
        wait.until(ExpectedConditions.visibilityOf(userNameTxt));
        userNameTxt.sendKeys(user.getUserName());
        passwordTxt.sendKeys(user.getPassword());
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();
    }
    public String getUserName(){
        wait.until(ExpectedConditions.visibilityOf(userNameValueLbl));
        return userNameValueLbl.getText();
    }

    public Boolean isDisplayedUserName(){
        wait.until(ExpectedConditions.visibilityOf(userNameValueLbl));
        return userNameValueLbl.isDisplayed();
    }
}
