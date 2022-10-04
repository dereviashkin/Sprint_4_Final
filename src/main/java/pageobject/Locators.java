package pageobject;

import org.openqa.selenium.By;

public class Locators {
    //Главная страница
    //Элемент с текстом "Учебный тренажер"
    public static final By TRAINING_SIMULATOR = By.className("Header_Disclaimer__3VEni");
    //Кнопка принятия куков "да все привыкли"
    public static final By ACCEPT_COOKIE_BUTTON = By.className("App_CookieButton__3cvqF");
    //Кнопка "Заказать" вверху страницы
    public static final By ORDER_BUTTON_TOP = By.className("Button_Button__ra12g");
    //Кнопка "Заказать" внизу страницы
    public static final By ORDER_BUTTON_BOTTOM = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");
    //Список "Вопросы о важном" веб-элементы вопросов
    public static final By FAQ_QUESTIONS = By.xpath(".//div[@class='accordion__item']");
    //Список "Вопросы о важном" текст вопросов
    public static final By FAQ_QUESTIONS_TEXT = By.xpath(".//div[@class='accordion']");
    //Список "Вопросы о важном" видимые ответы
    public static final By FAQ_ANSWER_VISIBLE = By.xpath(".//p/parent::div[not(@hidden)]");

    //Страница заказа
    //Элемент с текстом заголовка страницы
    public static final By ORDER_HEADER = By.className("Order_Header__BZXOb");
    //Строка ввода имени
    public static final By INPUT_NAME = By.xpath(".//div/input[@placeholder='* Имя']");
    //Строка ввода фамилии
    public static final By INPUT_SURNAME = By.xpath(".//div/input[@placeholder='* Фамилия']");
    //Строка ввода адреса
    public static final By INPUT_ADDRESS = By.xpath(".//div/input[@placeholder='* Адрес: куда привезти заказ']");
    //Выпадающее меню выбора станции метро
    public static final By INPUT_METRO_STATION = By.xpath(".//div/input[@placeholder='* Станция метро']");
    //Массив элементов выпадающего меню станций метро
    public static final By INPUT_METRO_STATION_CHERKIZOVSKAYA = By.xpath(".//li[@data-index='1']");
    //Строка ввода телефона
    public static final By INPUT_PHONE_NUMBER = By.xpath(".//div/input[@placeholder='* Телефон: на него позвонит курьер']");
    //Строка ввода телефона
    public static final By INPUT_PHONE_NUMBER_ERROR_MESSAGE = By.xpath(".//div[text()='Введите корректный номер' and @class='Input_ErrorMessage__3HvIb Input_Visible___syz6']");
    //Кнопка Далее
    public static final By NEXT_BUTTON = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    //Строка ввода даты подачи самоката
    public static final By INPUT_DATE_SCOOTER_DELIVERY = By.xpath(".//div/input[@placeholder='* Когда привезти самокат']");
    //Строка ввода срока аренды самоката
    public static final By INPUT_TERM_RATE = By.cssSelector(".Dropdown-arrow");
    //Пункт выпадающего меню 1 день
    public static final By INPUT_TERM_RATE_DAY = By.xpath(".//div[@class='Dropdown-menu']/div[text()='сутки']");
    //Проверка установки срока аренды
    public static final By INPUT_TERM_RATE_DAY_CHECK = By.xpath(".//div[@class='Dropdown-placeholder is-selected']");
    //Чекбокс для черного цвета самоката
    public static final By CHECKBOX_COLOUR = By.id("black");
    //Строка ввода комментария для курьера
    public static final By INPUT_COMMENT = By.xpath(".//div/input[@placeholder='Комментарий для курьера']");
    //Кнопка подтверждения заказа
    public static final By ORDER_BUTTON_COMPLETE = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Попап окно прямо совсем точного подтверждения
    public static final By ORDER_BUTTON_ABSOLUTELY_COMPLETE = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

}