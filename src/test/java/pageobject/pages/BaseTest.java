package pageobject.pages;

import drivermanager.DriverManager;
import org.junit.AfterClass;

public abstract class BaseTest {

    @AfterClass
    public static void closeBrowser() {
        DriverManager.quitDriver();
    }
}
