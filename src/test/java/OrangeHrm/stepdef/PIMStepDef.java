package OrangeHrm.stepdef;

import OrangeHrm.core.DriverManager;
import OrangeHrm.pages.LoginPage;
import OrangeHrm.pages.PIMPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static OrangeHrm.pages.PIMPage.savedEmpId;

public class PIMStepDef 
{

    PIMPage pimPage;
    String fName;
    String lName;
    public PIMStepDef()
    {
        pimPage= new PIMPage(DriverManager.getDriver());
    }
    @Given("I am logged in as a user with role {string}")
    public void iAmLoggedInAsAUserWithRole(String admin)
    {
//        LoginStepDef loginStepDef= new LoginStepDef();
//        loginStepDef.user_enters_user_name_and_password();
//        loginStepDef.userClicksOnTheLoginButton();
//        loginStepDef.verifyTheDashboardIsDisplayed();

    }

    @And("navigate to the PIM tab")
    public void navigateToThePIMTab()
    {
         pimPage.clickPimTab();

    }

    @Given("click on add employee menu item")
    public void clickOnAddEmployeeMenuItem()
    {
        pimPage.clickAddEmployee();
    }

    @And("current highest Employee ID should be present")
    public void currentHighestEmployeeIDShouldBePresent()
    {
        pimPage.captureEmployeeId();
    }

    @When("I enter a First Name {string} and Last Name {string}")
    public void iEnterAFirstNameAndLastName(String firstName, String lastName)
    {
        fName=firstName;
        lName=lastName;
        pimPage.enterFirstName(firstName);
        pimPage.enterLastName(lastName);
    }

    @And("I click the {string} button")
    public void iClickTheButton(String arg0)
    {
        pimPage.clickSaveBtn();
    }

    @Then("I should see a success message containing {string}")
    public void iShouldSeeASuccessMessageContaining(String arg0)
    {
        pimPage.getToastMsg();

    }

    @And("I should be navigated to the Employee List page")
    public void iShouldBeNavigatedToTheEmployeeListPage()
    {
        pimPage.personalDetailsTab();
    }

    @Then("the personal details of employee list should display the details entered during the creation")
    public void thePersonalDetailsOfEmployeeListShouldDisplayTheDetailsEnteredDuringTheCreation() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals(fName,pimPage.getEmpListFirstName());
        Assert.assertEquals(lName,pimPage.getEmpListLasName());
        Assert.assertEquals(savedEmpId,pimPage.getEmpListEmpId());

    }
}
