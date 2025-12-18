package OrangeHrm.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils
{

    public static void waitForElementVisibility(WebDriver driver, By locator, int timeout)
    {
        new WebDriverWait(driver,Duration.ofSeconds(timeout)).
                until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
