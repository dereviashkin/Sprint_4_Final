package pageobject.pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static drivermanager.DriverManager.getDriver;
import static drivermanager.DriverManager.getDriverWait;
import static pageobject.Locators.*;
import static pageobject.Urls.MAIN_PAGE;

public class MainPage {

    /**
     * Метод открытия главной страницы
     */
    public MainPage open() {
        getDriver().get(MAIN_PAGE);
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(TRAINING_SIMULATOR));
        Assert.assertEquals("Похоже, главная страница не загрузилась", "УЧЕБНЫЙ ТРЕНАЖЕР", getDriver().findElement(TRAINING_SIMULATOR).getText());
        if (getDriver().findElements(ACCEPT_COOKIE_BUTTON).size() != 0) {
            getDriver().findElement(ACCEPT_COOKIE_BUTTON).click();
        }
        return this;
    }

    /**
     * Метод клика по верхней кнопке Заказать
     */
    public MainPage orderButtonTopClick() {
        getDriver().findElement(ORDER_BUTTON_TOP).click();
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ORDER_HEADER));
        Assert.assertEquals("Похоже, страница заказа не загрузилась", "Для кого самокат", getDriver().findElement(ORDER_HEADER).getText());
        return this;
    }

    /**
     * Метод клика по нижней кнопке Заказать
     */
    public MainPage orderButtonBottomClick() {
        getDriver().findElement(ORDER_BUTTON_BOTTOM).click();
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ORDER_HEADER));
        Assert.assertEquals("Похоже, страница заказа не загрузилась", "Для кого самокат", getDriver().findElement(ORDER_HEADER).getText());
        return this;
    }

    /**
     * Получаем список вопросов в FAQ на сайте. Хотел сделать проверку пары с сайта с ключ/значением из эталона, но
     * ассерт по хашмапе не заработал, не успеваю допилить
     */
    public MainPage getTextFromFaqList() {
        //Скроллим до FAQ
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", getDriver().findElement(FAQ_QUESTIONS));
        //Инициализируем мапу эталонов FAQ
        List<String> idealFaqValues = List.of("Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                "Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                "Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                "Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                "Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                "Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                "Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                "Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области.");

        //Формируем список веб-элементов вопросов в FAQ
        List<WebElement> elementsQuestions = getDriver().findElements(FAQ_QUESTIONS);
        //Формируем текстовый список вопросов в FAQ
        List<String> elementsQuestionsStrings = List.of(getDriver().findElement(FAQ_QUESTIONS_TEXT).getText().split("\n"));
        //Проверяем, что текст вопроса с сайта найден в нашем эталоне
        elementsQuestionsStrings.forEach(el -> Assert.assertTrue(idealFaqValues.contains(el)));
        for (WebElement element : elementsQuestions) {
            //Кликаем по элементу вопроса из FAQ
            element.click();
            //Ждём, когда элемент ответа после клика станет видим
            getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(FAQ_ANSWER_VISIBLE));
            //Проверяем, что текст ответа с сайта найден в нашем эталоне
            Assert.assertTrue(idealFaqValues.contains(getDriver().findElement(FAQ_ANSWER_VISIBLE).getText()));
        }
        return this;
    }
}
