package pageobject.pages;

import drivermanager.DriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public abstract class BaseTest {

    /**
     * Инициализируем вебдрайвер. Подходящие имена бразуера: chrome, firefox.
     */
    @BeforeClass
    public static void initChromeDriver() {
        DriverManager.setDriver("chrome");
    }

    /**
     * Инициализируем вебдрайвервейт
     */
    @BeforeClass
    public static void initWebDriverWait() {
        DriverManager.setDriverWait();
    }

    /**
     * Закрываем сессию и окна браузера
     */
    @AfterClass
    public static void quitBrowser() {
        DriverManager.quitDriver();
    }
}