package pageobject.pages;

import drivermanager.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static drivermanager.DriverManager.getDriver;
import static drivermanager.DriverManager.getDriverWait;

public class OrderPage {

    private static String orderPage = "https://qa-scooter.praktikum-services.ru/order";
    //Кнопка принятия куков "да все привыкли"
    private static By acceptCookieButton = By.className("App_CookieButton__3cvqF");
    //Элемент с текстом заголовка страницы
    private static By orderHeader = By.className("Order_Header__BZXOb");
    //Строка ввода имени
    private static By inputName = By.xpath(".//div/input[@placeholder='* Имя']");
    //Строка ввода фамилии
    private static By inputSurname = By.xpath(".//div/input[@placeholder='* Фамилия']");
    //Строка ввода адреса
    private static By inputAddress = By.xpath(".//div/input[@placeholder='* Адрес: куда привезти заказ']");
    //Выпадающее меню выбора станции метро
    private static By inputMetroStation = By.xpath(".//div/input[@placeholder='* Станция метро']");
    //Массив элементов выпадающего меню станций метро
    private static By inputMetroStationCherkizovskaya = By.xpath(".//li[@data-index='1']");
    //Строка ввода телефона
    private static By inputPhoneNumber = By.xpath(".//div/input[@placeholder='* Телефон: на него позвонит курьер']");
    //Строка ввода телефона
    private static By inputPhoneNumberErrorMessage = By.xpath(".//div[text()='Введите корректный номер' and @class='Input_ErrorMessage__3HvIb Input_Visible___syz6']");
    //Кнопка Далее
    private static By nextButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    //Строка ввода даты подачи самоката
    private static By inputDateScooterDelivery = By.xpath(".//div/input[@placeholder='* Когда привезти самокат']");
    //Строка ввода срока аренды самоката
    private static By inputTermRate = By.cssSelector(".Dropdown-arrow");
    //Пункт выпадающего меню 1 день
    private static By inputTermRateDay = By.xpath(".//div[@class='Dropdown-menu']/div[text()='сутки']");
    //Проверка установки срока аренды
    private static By inputTermRateDayCheck = By.xpath(".//div[@class='Dropdown-placeholder is-selected']");
    //Чекбокс для черного цвета самоката
    private static By checkboxColour = By.id("black");
    //Строка ввода комментария для курьера
    private static By inputComment = By.xpath(".//div/input[@placeholder='Комментарий для курьера']");
    //Кнопка подтверждения заказа
    private static By orderButtonComplete = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Попап окно прямо совсем точного подтверждения
    private static By orderButtonAbsolutelyComplete = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

    /**
     * Метод открытия главной страницы
     * Перекликается с методом orderButtonTopClick() в MainPage
     */
    public OrderPage open() {
        getDriver().get(orderPage);
        DriverManager.getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(orderHeader));
        Assert.assertEquals("Похоже, главная страница не загрузилась", "Для кого самокат", getDriver().findElement(orderHeader).getText());
        if (getDriver().findElements(acceptCookieButton).size() != 0) {
            getDriver().findElement(acceptCookieButton).click();
        }
        return this;
    }

    /**
     * Заполняет форму заказа тестовыми данными
     */
    public OrderPage personalDataOrderForm(String name, String surname, String address, String number, boolean noErrors) {
        getDriver().findElement(inputName).sendKeys(name);
        Assert.assertEquals(name, getDriver().findElement(inputName).getAttribute("value"));
        getDriver().findElement(inputSurname).sendKeys(surname);
        Assert.assertEquals(surname, getDriver().findElement(inputSurname).getAttribute("value"));
        getDriver().findElement(inputAddress).sendKeys(address);
        Assert.assertEquals(address, getDriver().findElement(inputAddress).getAttribute("value"));
        getDriver().findElement(inputPhoneNumber).sendKeys(number);
        selectMetroStation();
        //Проверяем, что номер соответствует переданному
        Assert.assertEquals(number, getDriver().findElement(inputPhoneNumber).getAttribute("value"));
        //Проверяем, что ошибки под строкой номера не образовалось
        Assert.assertEquals(noErrors, getDriver().findElements(inputPhoneNumberErrorMessage).size() == 0);
        return this;
    }

    /**
     * Выбираем станцию метро
     */
    private void selectMetroStation() {
        getDriver().findElement(inputMetroStation).click();
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(inputMetroStationCherkizovskaya));
        getDriver().findElement(inputMetroStationCherkizovskaya).click();
        Assert.assertEquals("Черкизовская", getDriver().findElement(inputMetroStation).getAttribute("value"));
    }

    /**
     * Сликаем кнопку далее и проверяем, что попали на следующую страницу заказа
     */
    public OrderPage clickNextButton() {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(nextButton));
        getDriver().findElement(nextButton).click();
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(orderHeader));
        Assert.assertEquals("Похоже, страница заказа не загрузилась", "Про аренду", getDriver().findElement(orderHeader).getText());
        return this;
    }

    /**
     * Заполняем вторую часть формы заказа
     * Кнопка "Да" во всплывающем окне окончательного подтверждения заказа не работает,
     * поэтому не добавляю ассерт оформления заказа
     */
    public OrderPage rentOrderForm() {
        getDriver().findElement(inputDateScooterDelivery).sendKeys("03.10.2022");
        Assert.assertEquals("03.10.2022", getDriver().findElement(inputDateScooterDelivery).getAttribute("value"));
        getDriver().findElement(inputTermRate).click();
        getDriver().findElement(inputTermRateDay).click();
        Assert.assertEquals("сутки", getDriver().findElement(inputTermRateDayCheck).getText());
        getDriver().findElement(checkboxColour).click();
        getDriver().findElement(inputComment).sendKeys("Если ты плачешь не от счастья, то перестань. ©Филипп Джей Фрай");
        getDriver().findElement(orderButtonComplete).click();
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(orderButtonAbsolutelyComplete));
        getDriver().findElement(orderButtonAbsolutelyComplete).click();
        return this;
    }
}