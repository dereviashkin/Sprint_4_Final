package pageobject.pages;

import org.junit.Test;

public class MainPageTest extends BaseTest {
    private final MainPage mainPage = new MainPage();

    /**
     * Тест работоспособности верхней кнопки "Заказать"
     */
    @Test()
    public void clickOrderButtonTopSuccess() {
        mainPage
                .openMainPage()
                .clickAcceptCookieButton()
                .checkIfMainPageOpened()
                .clickOrderButtonTop()
                .checkIfOrderPageOpened();
    }

    /**
     * Тест работоспособности нижней кнопки "Заказать"
     */
    @Test()
    public void clickOrderButtonBottomSuccess() {
        mainPage
                .openMainPage()
                .clickAcceptCookieButton()
                .checkIfMainPageOpened()
                .clickOrderButtonBottom()
                .checkIfOrderPageOpened();
    }

    /**
     * Тестирование FAQ согласно заданию
     */
    @Test()
    public void firstFaqQuestionAnswerCorrectSuccess() {
        mainPage.openMainPage()
                .clickAcceptCookieButton()
                .checkIfMainPageOpened()
                .scrollFaqIntoView()
                .realQuestionMatchesIdeal(1)
                .clickQuestionToOpenAnswer(1)
                .realAnswerMatchesIdeal(1);
    }

    @Test()
    public void secondFaqQuestionAnswerCorrectSuccess() {
        mainPage.openMainPage()
                .clickAcceptCookieButton()
                .checkIfMainPageOpened()
                .scrollFaqIntoView()
                .realQuestionMatchesIdeal(2)
                .clickQuestionToOpenAnswer(2)
                .realAnswerMatchesIdeal(2);
    }

    @Test()
    public void thirdFaqQuestionAnswerCorrectSuccess() {
        mainPage.openMainPage()
                .clickAcceptCookieButton()
                .checkIfMainPageOpened()
                .scrollFaqIntoView()
                .realQuestionMatchesIdeal(3)
                .clickQuestionToOpenAnswer(3)
                .realAnswerMatchesIdeal(3);
    }

    @Test()
    public void fourthFaqQuestionAnswerCorrectSuccess() {
        mainPage.openMainPage()
                .clickAcceptCookieButton()
                .checkIfMainPageOpened()
                .scrollFaqIntoView()
                .realQuestionMatchesIdeal(4)
                .clickQuestionToOpenAnswer(4)
                .realAnswerMatchesIdeal(4);
    }

    @Test()
    public void fifthFaqQuestionAnswerCorrectSuccess() {
        mainPage.openMainPage()
                .clickAcceptCookieButton()
                .checkIfMainPageOpened()
                .scrollFaqIntoView()
                .realQuestionMatchesIdeal(5)
                .clickQuestionToOpenAnswer(5)
                .realAnswerMatchesIdeal(5);
    }

    @Test()
    public void sixthFaqQuestionAnswerCorrectSuccess() {
        mainPage.openMainPage()
                .clickAcceptCookieButton()
                .checkIfMainPageOpened()
                .scrollFaqIntoView()
                .realQuestionMatchesIdeal(6)
                .clickQuestionToOpenAnswer(6)
                .realAnswerMatchesIdeal(6);
    }

    @Test()
    public void seventhFaqQuestionAnswerCorrectSuccess() {
        mainPage.openMainPage()
                .clickAcceptCookieButton()
                .checkIfMainPageOpened()
                .scrollFaqIntoView()
                .realQuestionMatchesIdeal(7)
                .clickQuestionToOpenAnswer(7)
                .realAnswerMatchesIdeal(7);
    }

    @Test()
    public void eighthFaqQuestionAnswerCorrectSuccess() {
        mainPage.openMainPage()
                .clickAcceptCookieButton()
                .checkIfMainPageOpened()
                .scrollFaqIntoView()
                .realQuestionMatchesIdeal(8)
                .clickQuestionToOpenAnswer(8)
                .realAnswerMatchesIdeal(8);
    }

    /**
     * Тестирование FAQ с приседаниями
     */
    @Test()
    public void textFaqQuestionAnswerCorrectSuccess() {
        mainPage
                .openMainPage()
                .checkTextFromFaqList();
    }
}