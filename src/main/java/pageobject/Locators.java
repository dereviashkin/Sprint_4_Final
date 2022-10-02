package pageobject;

import org.openqa.selenium.By;

public class Locators {
    //Главная страница
    //Кнопка "Заказать" вверху страницы
    private static final By ORDER_BUTTON_TOP = By.className("Button_Button__ra12g");
    //Кнопка "Заказать" внизу страницы
    private static final By ORDER_BUTTON_DOWN = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");
    //Список "Вопросы о важном"
    private static final By IMPORTANT_QUESTIONS = By.cssSelector(".accordion");

}
