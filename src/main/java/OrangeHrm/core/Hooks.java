package OrangeHrm.core;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks
{
    @Before
    public void setUp()
    {
        String browser = System.getProperty("browser", "chrome").trim().toLowerCase();
        WebDriver driver;

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        // Register driver in ThreadLocal storage
        DriverManager.setDriver(driver);

        String appUrl = System.getProperty("app.url", "https://opensource-demo.orangehrmlive.com/");
        driver.get(appUrl);

    }

    @After
    public void tearDown() {
        //DriverManager.cleanupDriver();
    }
}
