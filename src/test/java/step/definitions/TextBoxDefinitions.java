package step.definitions;

import Convert.DataTableConvert;
import entity.User;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page.objects.LeftPannel;
import page.objects.TextBoxPage;

import java.util.Map;

public class TextBoxDefinitions {
    TextBoxPage textBoxPage;
    LeftPannel leftPannel;

    @DataTableType
    public User convertToUser(Map<String,String> entry){
        return DataTableConvert.convertToUser(entry);
    }
    public TextBoxDefinitions() {
        textBoxPage = new TextBoxPage();
        leftPannel = new LeftPannel();
    }

    @Given("^the user navigates in Left panel: select (.*) > (.*)$")
    public void theUserNavigatesToTextBoxPage(String category, String subCategory) {
        leftPannel.clickCategory(category);
        leftPannel.clickSubCategory(subCategory);
    }

    @When("the user enters all information about user")
    public void theUserEntersAllInformationAboutUser(User user) {
        textBoxPage.fillTextBoxForm(user);
    }

    @Then("the user should see the user details")
    public void theUserShouldSeeTheUserDetails(User expecUser) {
        Assert.assertTrue(textBoxPage.isTextDisplayed(expecUser.getUserName()));
        Assert.assertTrue(textBoxPage.isTextDisplayed(expecUser.getEmail()));
        Assert.assertTrue(textBoxPage.isTextDisplayed(expecUser.getPermanentAddress()));
    }
}
