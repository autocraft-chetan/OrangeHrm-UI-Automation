package OrangeHrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class PIMPage
{

    public final WebDriver driver;
    public static String savedEmpId;
    public PIMPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    public final By pimTab=By.xpath("//a[contains(@href,'viewPimModule')]");
    private final By addEmployeeMenu =By.xpath("//a[text()='Add Employee']");
    private final By firstName=By.xpath("//input[@placeholder='First Name']");
    private final By lastName=By.xpath("//input[@placeholder='Last Name']");
    private final By createLoginToggle=By.xpath("//span[contains(@class,'oxd-switch-input')]");
    private final By userName=By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]");
    private final By password=By.xpath("(//input[@type='password'])[1]");
    private final By saveBtn=By.xpath("//button[normalize-space()='Save']");
    private final By empIdTextBox=By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div//input");
    private final By toastMsg= By.xpath("//p[contains(@class,'oxd-text--toast-message')]");
    private final By personalDetails=By.xpath("(//*[text()='Personal Details'])[1]");
    public final By empListFirstName=By.xpath("//input[@name='firstName']");
    public final By empListLastName=By.xpath("//input[@name='lastName']");
    public final By empListEmpId=By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div//input");

    // Class-level variable to store the ID for later validation


    public void captureEmployeeId() {
        WebElement employeeIdTextBox = driver.findElement(empIdTextBox);
        savedEmpId = employeeIdTextBox.getAttribute("value");

        if (savedEmpId == null || savedEmpId.isEmpty()) {
            throw new AssertionError("Employee ID was not generated or captured.");
        }

        System.out.println("Captured Employee ID: " + savedEmpId);
    }
    public void clickPimTab()
    {
        //waitForElementVisibility(driver,pimTab,10);
        driver.findElement(pimTab).click();
    }
    public void clickAddEmployee()
    {
        //waitForElementVisibility(driver,addEmployeeMenu,10);
        driver.findElement(addEmployeeMenu).click();
    }
    public void enterFirstName(String fName)
    {
        driver.findElement(firstName).sendKeys(fName);
    }
    public void enterLastName(String lName)
    {
        driver.findElement(lastName).sendKeys(lName);
    }
    public void clickCreateLoginTab()
    {
        driver.findElement(createLoginToggle).click();
    }
    public void enterUserName(String uName)
    {
        driver.findElement(userName).sendKeys(uName);
    }
    public void enterPassword(String pwd)
    {
        driver.findElement(password).sendKeys(pwd);
    }
    public void clickSaveBtn()
    {
        driver.findElement(saveBtn).click();
    }
    public void getToastMsg()
    {
        String successMsg=driver.findElement(toastMsg).getText();
        System.out.println("msg- "+successMsg);
    }

    public void personalDetailsTab()
    {
        driver.findElement(personalDetails).isDisplayed();
    }

    public String getEmpListFirstName()
    {
        return driver.findElement(empListFirstName).getText();
    }
    public String getEmpListLasName()
    {
        return driver.findElement(empListLastName).getText();
    }
    public String getEmpListEmpId()
    {
        return driver.findElement(empListEmpId).getText();
    }




}
