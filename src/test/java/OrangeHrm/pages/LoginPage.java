package OrangeHrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static OrangeHrm.core.WaitUtils.waitForElementVisibility;

public class LoginPage
{
    private  final WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public final By userName=By.xpath("//input[@name='username']");
    private final By password=By.xpath("//input[@name='password']");
    private final By loginBtn=By.cssSelector("button[type='submit']");
    private final By dashBoard=By.xpath("//h6[normalize-space()='Dashboard']");

    public void enterUserName(String uName)
    {
        waitForElementVisibility(driver,userName,5);
        driver.findElement(userName).sendKeys(uName);
    }

    public void enterPwd(String pwd)
    {
        waitForElementVisibility(driver,password,5);
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickLogin()
    {
        driver.findElement(loginBtn).click();
    }
    public void dashBoardTab()
    {
        driver.findElement(dashBoard).isDisplayed();
    }



}
