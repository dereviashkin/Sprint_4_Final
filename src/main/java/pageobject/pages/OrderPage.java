package pageobject.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static drivermanager.DriverManager.getDriver;
import static drivermanager.DriverManager.getDriverWait;

public class OrderPage {

    private String orderPage = "https://qa-scooter.praktikum-services.ru/order";
    //Кнопка принятия куков "да все привыкли"
    private By acceptCookieButton = By.className("App_CookieButton__3cvqF");
    //Элемент окна принятия кукуков
    private By cookieWindows = By.className(".App_CookieConsent__1yUIN");
    //Элемент с текстом заголовка страницы
    private By orderHeader = By.className("Order_Header__BZXOb");
    //Строка ввода имени
    private By inputName = By.xpath(".//div/input[@placeholder='* Имя']");
    //Строка ввода фамилии
    private By inputSurname = By.xpath(".//div/input[@placeholder='* Фамилия']");
    //Строка ввода адреса
    private By inputAddress = By.xpath(".//div/input[@placeholder='* Адрес: куда привезти заказ']");
    //Выпадающее меню выбора станции метро
    private By inputMetroStation = By.xpath(".//div/input[@placeholder='* Станция метро']");
    //Массив элементов выпадающего меню станций метро
    private By inputMetroStationCherkizovskaya = By.xpath(".//li[@data-index='1']");
    //Строка ввода телефона
    private By inputPhoneNumber = By.xpath(".//div/input[@placeholder='* Телефон: на него позвонит курьер']");
    //Строка ввода телефона
    private By inputFormErrorMessage = By.xpath(".//div[@class='Input_ErrorMessage__3HvIb Input_Visible___syz6']");
    //Кнопка Далее
    private By nextButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    //Строка ввода даты подачи самоката
    private By inputDateScooterDelivery = By.xpath(".//div/input[@placeholder='* Когда привезти самокат']");
    //Строка ввода срока аренды самоката
    private By inputTermRate = By.cssSelector(".Dropdown-arrow");
    //Пункт выпадающего меню 1 день
    private By inputTermRateDay = By.xpath(".//div[@class='Dropdown-menu']/div[text()='сутки']");
    //Проверка установки срока аренды
    private By inputTermRateDayCheck = By.xpath(".//div[@class='Dropdown-placeholder is-selected']");
    //Чекбокс для черного цвета самоката
    private By checkboxColour = By.id("black");
    //Строка ввода комментария для курьера
    private By inputComment = By.xpath(".//div/input[@placeholder='Комментарий для курьера']");
    //Кнопка подтверждения заказа
    private By orderButtonComplete = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Элемент попап окна прямо совсем точного подтверждения
    private By orderPopupWindowAbsolutelyComplete = By.xpath(".//div[@class='Order_Modal__YZ-d3']");
    //Кнопка "да" в попап окне прямо совсем точного подтверждения
    private By orderButtonAbsolutelyComplete = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

    /**
     * Метод открытия страницы заказа
     */
    public OrderPage openOrderPage() {
        getDriver().get(orderPage);
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(orderHeader));
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
     * Метод проверки открытия страницы заказа с вводом данных покупателя
     */
    public OrderPage checkIfOrderPageOpenedPersonInfo() {
        checkIfPageOpened("Для кого самокат", orderHeader);
        return this;
    }

    /**
     * Метод проверки открытия страницы заказа с вводом данных о самокате
     */
    public OrderPage checkIfOrderPageOpenedScooterInfo() {
        checkIfPageOpened("Про аренду", orderHeader);
        return this;
    }

    /**
     * Метод нажимания кнопки "принять куки"
     */
    public OrderPage clickAcceptCookieButton() {
        if (getDriver().findElements(acceptCookieButton).size() != 0) {
            getDriver().findElement(acceptCookieButton).click();
        }
        getDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(cookieWindows));
        return this;
    }

    /**
     * Заполняет форму заказа тестовыми данными покупателя
     */
    public OrderPage fillPersonalDataOrderForm(String name, String surname, String address, String number) {
        getDriver().findElement(inputName).sendKeys(name);
        getDriver().findElement(inputSurname).sendKeys(surname);
        getDriver().findElement(inputAddress).sendKeys(address);
        getDriver().findElement(inputPhoneNumber).sendKeys(number);
        selectMetroStation();
        return this;
    }

    /**
     * Выбираем станцию метро
     */
    private void selectMetroStation() {
        getDriver().findElement(inputMetroStation).click();
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(inputMetroStationCherkizovskaya));
        getDriver().findElement(inputMetroStationCherkizovskaya).click();
    }

//    /**
//     * Метод проверки правильного заполнения полей формы данных покупателя
//     */
//    public OrderPage checkIfPesonalDataFormFilledCorrect() {
//        checkIfInputFilledCorrect(name, inputName);
//        checkIfInputFilledCorrect(surname, inputSurname);
//        checkIfInputFilledCorrect(address, inputAddress);
//        checkIfInputFilledCorrect(number, inputPhoneNumber);
//        checkIfInputFilledCorrect(metroStation, inputMetroStation);
//        return this;
//    }

    /**
     * Общий метод проверки, что полученное из поля для ввода значение соответствует передаваемому
     *
     * @param inputText отправляемый текст
     * @param locator   локатор поля для ввода
     */
    private void checkIfInputFilledCorrect(String inputText, By locator) {
        Assert.assertEquals(inputText, getDriver().findElement(locator).getAttribute("value"));
    }

    /**
     * Метод проверки отстутствия сообщений об ошибках после ввода значений в текстовые поля формы
     *
     * @param noErrors ожидаемый результат проверки
     */
    public OrderPage checkIfNoErrors(boolean noErrors) {
        Assert.assertEquals(noErrors, getDriver().findElements(inputFormErrorMessage).size() == 0);
        return this;
    }

    /**
     * Метод клика кнопки далее
     */
    public OrderPage clickNextButton() {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(nextButton));
        getDriver().findElement(nextButton).click();
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(orderHeader));
        return this;
    }

    /**
     * Заполняем вторую часть формы заказа
     */
    public OrderPage fillRentOrderForm(String date, String comment) {
        getDriver().findElement(inputDateScooterDelivery).sendKeys(date);
        getDriver().findElement(inputTermRate).click();
        getDriver().findElement(inputTermRateDay).click();
        getDriver().findElement(checkboxColour).click();
        getDriver().findElement(inputComment).sendKeys(comment);
        return this;
    }

//    /**
//     * Метод проверки правильного заполнения полей формы выбора самоката
//     */
//    public OrderPage checkIfScooterDataFormFilledCorrect() {
//        checkIfInputFilledCorrect(date, inputDateScooterDelivery);
//        Assert.assertEquals("сутки", getDriver().findElement(inputTermRateDayCheck).getText());
//        checkIfInputFilledCorrect(comment, inputComment);
//        return this;
//    }

    /**
     * Метод клика по кнопке "Заказать"
     */
    public OrderPage clickOrderButton() {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(orderButtonComplete));
        getDriver().findElement(orderButtonComplete).click();
        return this;
    }

    /**
     * Метод клика по кнопке "Да" во всплывшем окне "Хотите оформить заказ?"
     */
    public OrderPage clickConfirmOrderButton() {
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(orderButtonAbsolutelyComplete));
        getDriver().findElement(orderButtonAbsolutelyComplete).click();
        return this;
    }

    public OrderPage checkIfConfirmOrderWindowClosed() {
        Assert.assertEquals("Похоже, окно подтверждения заказа не закрылось.", 0, getDriver().findElements(orderPopupWindowAbsolutelyComplete).size());
        return this;
    }
}