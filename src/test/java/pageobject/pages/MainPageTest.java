package pageobject.pages;

import org.junit.Test;

public class MainPageTest extends BaseTest {
    private final MainPage mainPage = new MainPage();

    @Test()
    public void clickOrderButtonTopSuccess() {
        mainPage
                .open()
                .orderButtonTopClick();
    }

    @Test()
    public void clickOrderButtonBottomSuccess() {
        mainPage
                .open()
                .orderButtonBottomClick();
    }

    @Test()
    public void textFromFaqExpectedSuccess() {
        mainPage
                .open()
                .getTextFromFaqList();
    }
}