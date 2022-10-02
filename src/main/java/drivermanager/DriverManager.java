package drivermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;

public class DriverManager {

    private static WebDriver driver;

    /**
     * Инициация драйвера в зависимости от переданного имени браузера
     */
    private static WebDriver init(String browserName) {
        File driverPath = new File("");
        switch (browserName){
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--no-sandbox",  "--disable-dev-shm-usage");
                System.setProperty("webdriver.chrome.driver", driverPath.getAbsolutePath() + "\\src\\main\\resources\\webdrivers\\chromedriver.exe");
                driver = new ChromeDriver(chromeOptions);
                return driver;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                //TODO перепилить аргументы под лису
                firefoxOptions.setHeadless(true);
                System.setProperty("webdriver.gecko.driver", driverPath.getAbsolutePath() + "\\src\\main\\resources\\webdrivers\\geckodriver.exe");
                driver = new FirefoxDriver(firefoxOptions);
                return driver;
        }
        throw new IllegalArgumentException("Не знаю такой браузер: " + browserName);
    }

    /**
     * Геттер драйвера
     * @param browserName обозначение браузера
     * @return объект драйвера
     */
    public static WebDriver getDriver(String browserName) {
        if (driver == null) {
            driver = init(browserName);
        }
        return driver;
    }

    /**
     * Закрыть текущее окно бразуера
     */
    public static void closeDriver() {
        if (driver != null) {
            driver.close();
        }
    }

    /**
     * Закрыть все сессии браузера
     */
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}