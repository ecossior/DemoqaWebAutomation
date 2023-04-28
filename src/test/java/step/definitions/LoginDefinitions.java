package step.definitions;

import entity.User;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page.objects.LoginPage;

import java.io.IOException;

import static utils.StoreData.SData;

public class LoginDefinitions {
    LoginPage login;
    User user;

    public LoginDefinitions() throws IOException {
        user =new User(SData("userName"),SData("pwd"));
        login = new LoginPage();
    }

    @When("the user login to web with valid credentials")
    public void theUserLoginToWebWithValidCredentials() throws IOException {
        login.loadPage();
        login.loginToWeb(user);
    }

    @Then("^the user should see: (.*$)")
    public void theUserShouldSeeEd(String expecUsername) {
        String actual = login.getUserName();
        Assert.assertEquals(actual,expecUsername);
        Assert.assertTrue(login.isDisplayedUserName());
    }
}
