package OrangeHrm.stepdef;

import OrangeHrm.core.DriverManager;
import OrangeHrm.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef
{

    private LoginPage loginPage;

    @Given("user is not navigated to HRMS login page")
    public void user_is_not_navigated_to_hrms_login_page() {
        loginPage = new LoginPage(DriverManager.getDriver());
        //String currentUrl = DriverManager.getDriver().getCurrentUrl();
        //System.out.println("url "+currentUrl);
    }
    @When("user enters userName and Password")
    public void user_enters_user_name_and_password()
    {
        loginPage.enterUserName("Admin");
        loginPage.enterPwd("admin123");
    }

    @When("user clicks on the login button")
    public void userClicksOnTheLoginButton()
    {
        loginPage.clickLogin();
    }

    @Then("verify the dashboard is displayed")
    public void verifyTheDashboardIsDisplayed()
    {

    }

}
