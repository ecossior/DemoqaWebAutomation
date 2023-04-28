package step.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page.objects.CheckBoxPage;

import java.util.List;

public class CheckBoxDefinitions {
    CheckBoxPage checkBoxPage;

    public CheckBoxDefinitions() {
        checkBoxPage = new CheckBoxPage();
    }

    @When("the user expands TreeView")
    public void theUserExpandsTreeView() {
        checkBoxPage.clickExpandAll();
    }

    @And("checks a set of nodes:")
    public void checksASetOfNodes(List<String> nodes) {
        checkBoxPage.checkNodes(nodes);
    }

    @Then("^the user should see this message You have selected: (.*)$")
    public void theUserShouldSeeThisMessageYouHaveSelected(String expectedNodesChecked) {
        Assert.assertEquals(expectedNodesChecked, checkBoxPage.getActualNodesChecked());
    }
}
