package pageobject.pages;

import drivermanager.DriverManager;

import static pageobject.Urls.getMainPage;

public class MainPage {

    /**
     * Метод открытия главной страницы. Подходящие имена бразуера: chrome, firefox.
     * @return
     */
    public MainPage open() {
        DriverManager.getDriver("chrome").get(getMainPage());
        return this;
    }

    public MainPage smthelse(){
        return this;
    }
}
