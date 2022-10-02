package pageobject.pages;

import org.junit.Test;

public class MainPageTest extends BaseTest{

    @Test()
    public void firstOne() {
        MainPage mainPage = new MainPage();
        mainPage
                .open()
                .smthelse();
    }
}