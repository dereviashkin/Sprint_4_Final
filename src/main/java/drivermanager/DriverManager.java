package drivermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class DriverManager {

    private static WebDriver driver;

    private static WebDriver init(String browserName) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        File driverPath = new File("");
        if (browserName.toLowerCase().contains("chrome")) {
            System.setProperty("webdriver.chrome.driver", driverPath.getAbsolutePath() + "\\src\\main\\resources\\webdrivers\\chromedriver.exe");
        } else if (browserName.toLowerCase().contains("firefox")) {
            System.setProperty("webdriver.chrome.driver", driverPath.getAbsolutePath() + "\\src\\main\\resources\\webdrivers\\geckodriver.exe");
        }
        return driver;
    }

    public static WebDriver getDriver(String browserName) {
        if (driver == null) {
            driver = init(browserName);
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}