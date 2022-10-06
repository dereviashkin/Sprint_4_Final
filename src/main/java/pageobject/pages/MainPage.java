package pageobject.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static drivermanager.DriverManager.getDriver;
import static drivermanager.DriverManager.getDriverWait;

public class MainPage {

    private static String mainPage = "https://qa-scooter.praktikum-services.ru/";
    //Элемент с текстом заголовка страницы
    private static By orderHeader = By.className("Order_Header__BZXOb");
    //Элемент с текстом "Учебный тренажер"
    private static By trainingSimulator = By.className("Header_Disclaimer__3VEni");
    //Кнопка принятия куков "да все привыкли"
    private static By acceptCookieButton = By.className("App_CookieButton__3cvqF");
    //Элемент окна принятия кукуков
    private static By cookieWindows = By.className(".App_CookieConsent__1yUIN");
    //Кнопка "Заказать" вверху страницы
    private static By orderButtonTop = By.className("Button_Button__ra12g");
    //Кнопка "Заказать" внизу страницы
    private static By orderButtonBottom = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");
    //Список "Вопросы о важном" веб-элементы вопросов
    private static By faqQuestions = By.xpath(".//div[@class='accordion__item']");
    //Список "Вопросы о важном" вопрос 1
    private static By faqQuestionOne = By.xpath(".//div[@class='accordion__item'][1]//div[@class='accordion__button']");
    //Список "Вопросы о важном" вопрос 2
    private static By faqQuestionTwo = By.xpath(".//div[@class='accordion__item'][2]//div[@class='accordion__button']");
    //Список "Вопросы о важном" вопрос 3
    private static By faqQuestionThree = By.xpath(".//div[@class='accordion__item'][3]//div[@class='accordion__button']");
    //Список "Вопросы о важном" вопрос 4
    private static By faqQuestionFour = By.xpath(".//div[@class='accordion__item'][4]//div[@class='accordion__button']");
    //Список "Вопросы о важном" вопрос 5
    private static By faqQuestionFive = By.xpath(".//div[@class='accordion__item'][5]//div[@class='accordion__button']");
    //Список "Вопросы о важном" вопрос 6
    private static By faqQuestionSix = By.xpath(".//div[@class='accordion__item'][6]//div[@class='accordion__button']");
    //Список "Вопросы о важном" вопрос 7
    private static By faqQuestionSeven = By.xpath(".//div[@class='accordion__item'][7]//div[@class='accordion__button']");
    //Список "Вопросы о важном" вопрос 8
    private static By faqQuestionEight = By.xpath(".//div[@class='accordion__item'][8]//div[@class='accordion__button']");
    //Список "Вопросы о важном" текст вопросов
    private static By faqQuestionsText = By.xpath(".//div[@class='accordion']");
    //Список "Вопросы о важном" видимые ответы
    private static By faqAnswerVisible = By.xpath(".//p/parent::div[not(@hidden)]");
    //Список эталонов FAQ, элемент списка n (вопрос) соответствует элементу списка n+1 (ответ)
    List<String> idealFaqValues = List.of("Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области.");

    /**
     * Метод открытия главной страницы
     */
    public MainPage openMainPage() {
        getDriver().get(mainPage);
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(trainingSimulator));
        return this;
    }

    /**
     * Общий метод проверки открытия страницы
     *
     * @param expected ожидаемый текст заголовка
     * @param locator  локатор заголовка на странице
     */
    private void checkIfPageOpened(String expected, By locator) {
        Assert.assertEquals("Похоже, ожидаемая страница не загрузилась", expected, getDriver().findElement(locator).getText());
    }

    /**
     * Метод проверки открытия главной страницы
     */
    public MainPage checkIfMainPageOpened() {
        checkIfPageOpened("УЧЕБНЫЙ ТРЕНАЖЕР", trainingSimulator);
        return this;
    }

    /**
     * Метод проверки открытия страницы заказа
     */
    public MainPage checkIfOrderPageOpened() {
        checkIfPageOpened("Для кого самокат", orderHeader);
        return this;
    }

    /**
     * Метод нажимания кнопки "принять куки"
     */
    public MainPage clickAcceptCookieButton() {
        if (getDriver().findElements(acceptCookieButton).size() != 0) {
            getDriver().findElement(acceptCookieButton).click();
        }
        getDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(cookieWindows));
        return this;
    }

    /**
     * Метод клика по верхней кнопке Заказать
     */
    public MainPage clickOrderButtonTop() {
        getDriver().findElement(orderButtonTop).click();
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(orderHeader));
        return this;
    }

    /**
     * Метод клика по нижней кнопке Заказать
     */
    public MainPage clickOrderButtonBottom() {
        getDriver().findElement(orderButtonBottom).click();
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(orderHeader));
        return this;
    }

    /**
     * Метод скролла до FAQ с помощью JS
     */
    public MainPage scrollFaqIntoView() {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", getDriver().findElement(faqQuestions));
        return this;
    }

    /**
     * Метод возвращает локатор по номеру вопроса
     *
     * @param questionNumber номер вопроса
     * @return объект локатора
     */
    private By questionLocator(int questionNumber) {
        switch (questionNumber) {
            case 1:
                return faqQuestionOne;
            case 2:
                return faqQuestionTwo;
            case 3:
                return faqQuestionThree;
            case 4:
                return faqQuestionFour;
            case 5:
                return faqQuestionFive;
            case 6:
                return faqQuestionSix;
            case 7:
                return faqQuestionSeven;
            case 8:
                return faqQuestionEight;
            default:
                throw new IllegalArgumentException("Номер вопроса задан некорректно: " + questionNumber + ". Допустимые значения: 1-8");
        }
    }

    /**
     * Метод сверки полученного текста вопроса FAQ с эталоном
     *
     * @param questionNumber номер вопроса из FAQ
     */
    public MainPage realQuestionMatchesIdeal(int questionNumber) {
        Assert.assertEquals(idealFaqValues.get(questionNumberInIdealList(questionNumber)),
                getDriver()
                        .findElement(questionLocator(questionNumber))
                        .getText());
        return this;
    }

    /**
     * Метод клика по телу вопроса, чтобы открыть ответ
     * @param questionNumber номер вопроса
     */
    public MainPage clickQuestionToOpenAnswer(int questionNumber){
        getDriver().findElement(questionLocator(questionNumber)).click();
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(faqAnswerVisible));
        return this;
    }

    /**
     * Метод сверки полученного текста ответа с эталоном
     * @param questionNumber номер вопроса
     */
    public MainPage realAnswerMatchesIdeal(int questionNumber){
        Assert.assertEquals(idealFaqValues.get(answerNumberInIdealList(questionNumber)), getDriver().findElement(faqAnswerVisible).getText());
        return this;
    }

    /**
     * Метод подсчета номера вопроса со страницы в эталонном списке
     *
     * @param questionNumber переданный номер вопроса со страницы
     * @return номер вопроса в эталонном списке
     */
    private int questionNumberInIdealList(int questionNumber) {
        return (questionNumber - 1) * 2;
    }

    /**
     * Метод подсчета номера ответа со страницы в эталонном списке
     *
     * @param questionNumber переданный номер вопроса со страницы
     * @return номер вопроса в эталонном списке
     */
    private int answerNumberInIdealList(int questionNumber) {
        return (questionNumber * 2) - 1;
    }

    /**
     * Получаем список вопросов в FAQ на сайте. Хотел сделать проверку пары с сайта с ключ/значением из эталона, но
     * ассерт по хашмапе не заработал, не успеваю допилить
     */
    public MainPage checkTextFromFaqList() {
        //Формируем список веб-элементов вопросов в FAQ
        List<WebElement> elementsQuestions = getDriver().findElements(faqQuestions);
        //Формируем текстовый список вопросов в FAQ
        List<String> elementsQuestionsStrings = List.of(getDriver().findElement(faqQuestionsText).getText().split("\n"));
        //Проверяем, что текст вопроса с сайта найден в нашем эталоне
        elementsQuestionsStrings.forEach(el -> Assert.assertTrue(idealFaqValues.contains(el)));
        //Цикл для всех веб-элементов вопросов FAQ: нажать на вопрос, дождаться отрисовки ответа, сверить ответ с эталоном
        for (WebElement element : elementsQuestions) {
            //Кликаем по элементу вопроса из FAQ
            element.click();
            //Ждём, когда элемент ответа после клика станет видим
            getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(faqAnswerVisible));
            //Проверяем, что текст ответа с сайта найден в нашем эталоне
            Assert.assertTrue(idealFaqValues.contains(getDriver().findElement(faqAnswerVisible).getText()));
        }
        return this;
    }
}