package OrangeHrm.core;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    private DriverManager() {
        // prevent instantiation
    }

    public static WebDriver getDriver() {
        return driverThread.get();
    }

    static void setDriver(WebDriver driver) {
        driverThread.set(driver);
    }

    public static void cleanupDriver() {
        WebDriver driver = driverThread.get();
        if (driver != null) {
            driver.quit();
            driverThread.remove();
        }
    }
}


