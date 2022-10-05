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

    /**
     * Тестирование FAQ с приседаниями
     */
    @Test()
    public void textFaqQuestionAnswerCorrectSuccess() {
        mainPage
                .open()
                .checkTextFromFaqList();
    }

    /**
     * Тестирование FAQ согласно заданию
     */
    @Test()
    public void firstFaqQuestionAnswerCorrectSuccess() {
        mainPage.open()
                .questionMatchesAnswer(1);
    }

    @Test()
    public void secondFaqQuestionAnswerCorrectSuccess() {
        mainPage.open()
                .questionMatchesAnswer(2);
    }

    @Test()
    public void thirdFaqQuestionAnswerCorrectSuccess() {
        mainPage.open()
                .questionMatchesAnswer(3);
    }

    @Test()
    public void fourthFaqQuestionAnswerCorrectSuccess() {
        mainPage.open()
                .questionMatchesAnswer(4);
    }

    @Test()
    public void fifthFaqQuestionAnswerCorrectSuccess() {
        mainPage.open()
                .questionMatchesAnswer(5);
    }

    @Test()
    public void sixthFaqQuestionAnswerCorrectSuccess() {
        mainPage.open()
                .questionMatchesAnswer(6);
    }

    @Test()
    public void seventhFaqQuestionAnswerCorrectSuccess() {
        mainPage.open()
                .questionMatchesAnswer(7);
    }

    @Test()
    public void eighthFaqQuestionAnswerCorrectSuccess() {
        mainPage.open()
                .questionMatchesAnswer(8);
    }
}