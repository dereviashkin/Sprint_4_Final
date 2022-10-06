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
    //Инициализируем список эталонов FAQ
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
    public MainPage open() {
        getDriver().get(mainPage);
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(trainingSimulator));
        Assert.assertEquals("Похоже, главная страница не загрузилась", "УЧЕБНЫЙ ТРЕНАЖЕР", getDriver().findElement(trainingSimulator).getText());
        if (getDriver().findElements(acceptCookieButton).size() != 0) {
            getDriver().findElement(acceptCookieButton).click();
        }
        return this;
    }

    /**
     * Метод клика по верхней кнопке Заказать
     */
    public MainPage orderButtonTopClick() {
        getDriver().findElement(orderButtonTop).click();
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(orderHeader));
        Assert.assertEquals("Похоже, страница заказа не загрузилась", "Для кого самокат", getDriver().findElement(orderHeader).getText());
        return this;
    }

    /**
     * Метод клика по нижней кнопке Заказать
     */
    public MainPage orderButtonBottomClick() {
        getDriver().findElement(orderButtonBottom).click();
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(orderHeader));
        Assert.assertEquals("Похоже, страница заказа не загрузилась", "Для кого самокат", getDriver().findElement(orderHeader).getText());
        return this;
    }

    /**
     * Получаем список вопросов в FAQ на сайте. Хотел сделать проверку пары с сайта с ключ/значением из эталона, но
     * ассерт по хашмапе не заработал, не успеваю допилить
     */
    public MainPage checkTextFromFaqList() {
        //Скроллим до FAQ
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", getDriver().findElement(faqQuestions));
        //Формируем список веб-элементов вопросов в FAQ
        List<WebElement> elementsQuestions = getDriver().findElements(faqQuestions);
        //Формируем текстовый список вопросов в FAQ
        List<String> elementsQuestionsStrings = List.of(getDriver().findElement(faqQuestionsText).getText().split("\n"));
        //Проверяем, что текст вопроса с сайта найден в нашем эталоне
        elementsQuestionsStrings.forEach(el -> Assert.assertTrue(idealFaqValues.contains(el)));
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

    /**
     * Метод сверки вопроса и ответа со страницы с эталоном, метод соответствия вопроса ответу
     *
     * @param questionNumber номер вопроса со страницы, допустимые значения 1-8
     */
    public MainPage questionMatchesAnswer(int questionNumber) {
        //Скроллим до FAQ
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", getDriver().findElement(faqQuestions));
        switch (questionNumber) {
            case 1:
                //Получаем и сверяем текст вопроса с эталонным
                Assert.assertEquals(idealFaqValues.get(questionNumberInIdealList(questionNumber)), getDriver().findElement(faqQuestionOne).getText());
                /*
                либо вот такой вариант, но тогда локатор не в отдельном классе
                Assert.assertEquals(idealFaqValues.get(questionNumberInIdealList(questionNumber)), getDriver().findElement(By.xpath(".//div[@class='accordion__item'][" + questionNumber + "]")).getText());
                 */
                //Кликаем по вопросу, чтобы появился ответ
                getDriver().findElement(faqQuestionOne).click();
                //Ждём, когда элемент ответа после клика станет видим
                getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(faqAnswerVisible));
                //Получаем и сверяем текст ответа с ответом
                Assert.assertEquals(idealFaqValues.get(answerNumberInIdealList(questionNumber)), getDriver().findElement(faqAnswerVisible).getText());
                return this;
            case 2:
                //Стоило бы вынести всё внутри case в отдельный метод, но проблема с локаторами
                Assert.assertEquals(idealFaqValues.get(questionNumberInIdealList(questionNumber)), getDriver().findElement(faqQuestionTwo).getText());
                getDriver().findElement(faqQuestionTwo).click();
                getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(faqAnswerVisible));
                Assert.assertEquals(idealFaqValues.get(answerNumberInIdealList(questionNumber)), getDriver().findElement(faqAnswerVisible).getText());
                return this;
            case 3:
                Assert.assertEquals(idealFaqValues.get(questionNumberInIdealList(questionNumber)), getDriver().findElement(faqQuestionThree).getText());
                getDriver().findElement(faqQuestionThree).click();
                getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(faqAnswerVisible));
                Assert.assertEquals(idealFaqValues.get(answerNumberInIdealList(questionNumber)), getDriver().findElement(faqAnswerVisible).getText());
                return this;
            case 4:
                Assert.assertEquals(idealFaqValues.get(questionNumberInIdealList(questionNumber)), getDriver().findElement(faqQuestionFour).getText());
                getDriver().findElement(faqQuestionFour).click();
                getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(faqAnswerVisible));
                Assert.assertEquals(idealFaqValues.get(answerNumberInIdealList(questionNumber)), getDriver().findElement(faqAnswerVisible).getText());
                return this;
            case 5:
                Assert.assertEquals(idealFaqValues.get(questionNumberInIdealList(questionNumber)), getDriver().findElement(faqQuestionFive).getText());
                getDriver().findElement(faqQuestionFive).click();
                getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(faqAnswerVisible));
                Assert.assertEquals(idealFaqValues.get(answerNumberInIdealList(questionNumber)), getDriver().findElement(faqAnswerVisible).getText());
                return this;
            case 6:
                Assert.assertEquals(idealFaqValues.get(questionNumberInIdealList(questionNumber)), getDriver().findElement(faqQuestionSix).getText());
                getDriver().findElement(faqQuestionSix).click();
                getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(faqAnswerVisible));
                Assert.assertEquals(idealFaqValues.get(answerNumberInIdealList(questionNumber)), getDriver().findElement(faqAnswerVisible).getText());
                return this;
            case 7:
                Assert.assertEquals(idealFaqValues.get(questionNumberInIdealList(questionNumber)), getDriver().findElement(faqQuestionSeven).getText());
                getDriver().findElement(faqQuestionSeven).click();
                getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(faqAnswerVisible));
                Assert.assertEquals(idealFaqValues.get(answerNumberInIdealList(questionNumber)), getDriver().findElement(faqAnswerVisible).getText());
                return this;
            case 8:
                Assert.assertEquals(idealFaqValues.get(questionNumberInIdealList(questionNumber)), getDriver().findElement(faqQuestionEight).getText());
                getDriver().findElement(faqQuestionEight).click();
                getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(faqAnswerVisible));
                Assert.assertEquals(idealFaqValues.get(answerNumberInIdealList(questionNumber)), getDriver().findElement(faqAnswerVisible).getText());
                return this;
        }
        throw new IllegalArgumentException("Заданный номер вопроса задан некорректно: " + questionNumber + ". Допустимые значения: 1-8");
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
}