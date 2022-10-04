package pageobject.pages;

import drivermanager.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static drivermanager.DriverManager.getDriver;
import static drivermanager.DriverManager.getDriverWait;
import static pageobject.Locators.*;
import static pageobject.Urls.ORDER_PAGE;

public class OrderPage {

    /**
     * Метод открытия главной страницы
     * Перекликается с методом orderButtonTopClick() в MainPage
     */
    public OrderPage open() {
        getDriver().get(ORDER_PAGE);
        DriverManager.getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ORDER_HEADER));
        Assert.assertEquals("Похоже, главная страница не загрузилась", "Для кого самокат", getDriver().findElement(ORDER_HEADER).getText());
        if (getDriver().findElements(ACCEPT_COOKIE_BUTTON).size() != 0) {
            getDriver().findElement(ACCEPT_COOKIE_BUTTON).click();
        }
        return this;
    }

    /**
     * Заполняет форму заказа тестовыми данными
     */
    public OrderPage personalDataOrderForm(String name, String surname, String address, String number, boolean noErrors) {
        getDriver().findElement(INPUT_NAME).sendKeys(name);
        Assert.assertEquals(name, getDriver().findElement(INPUT_NAME).getAttribute("value"));
        getDriver().findElement(INPUT_SURNAME).sendKeys(surname);
        Assert.assertEquals(surname, getDriver().findElement(INPUT_SURNAME).getAttribute("value"));
        getDriver().findElement(INPUT_ADDRESS).sendKeys(address);
        Assert.assertEquals(address, getDriver().findElement(INPUT_ADDRESS).getAttribute("value"));
        getDriver().findElement(INPUT_PHONE_NUMBER).sendKeys(number);
        selectMetroStation();
        //Проверяем, что номер соответствует переданному
        Assert.assertEquals(number, getDriver().findElement(INPUT_PHONE_NUMBER).getAttribute("value"));
        //Проверяем, что ошибки под строкой номера не образовалось
        Assert.assertEquals(noErrors, getDriver().findElements(INPUT_PHONE_NUMBER_ERROR_MESSAGE).size() == 0);
        return this;
    }

    /**
     * Выбираем станцию метро
     */
    private void selectMetroStation() {
        getDriver().findElement(INPUT_METRO_STATION).click();
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(INPUT_METRO_STATION_CHERKIZOVSKAYA));
        getDriver().findElement(INPUT_METRO_STATION_CHERKIZOVSKAYA).click();
        Assert.assertEquals("Черкизовская", getDriver().findElement(INPUT_METRO_STATION).getAttribute("value"));
    }

    /**
     * Сликаем кнопку далее и проверяем, что попали на следующую страницу заказа
     */
    public OrderPage clickNextButton() {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(NEXT_BUTTON));
        getDriver().findElement(NEXT_BUTTON).click();
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ORDER_HEADER));
        Assert.assertEquals("Похоже, страница заказа не загрузилась", "Про аренду", getDriver().findElement(ORDER_HEADER).getText());
        return this;
    }

    /**
     * Заполняем вторую часть формы заказа
     * Кнопка "Да" во всплывающем окне окончательного подтверждения заказа не работает,
     * поэтому не добавляю ассерт оформления заказа
     */
    public OrderPage rentOrderForm() {
        getDriver().findElement(INPUT_DATE_SCOOTER_DELIVERY).sendKeys("03.10.2022");
        Assert.assertEquals("03.10.2022", getDriver().findElement(INPUT_DATE_SCOOTER_DELIVERY).getAttribute("value"));
        getDriver().findElement(INPUT_TERM_RATE).click();
        getDriver().findElement(INPUT_TERM_RATE_DAY).click();
        Assert.assertEquals("сутки", getDriver().findElement(INPUT_TERM_RATE_DAY_CHECK).getText());
        getDriver().findElement(CHECKBOX_COLOUR).click();
        getDriver().findElement(INPUT_COMMENT).sendKeys("Если ты плачешь не от счастья, то перестань. ©Филипп Джей Фрай");
        getDriver().findElement(ORDER_BUTTON_COMPLETE).click();
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ORDER_BUTTON_ABSOLUTELY_COMPLETE));
        getDriver().findElement(ORDER_BUTTON_ABSOLUTELY_COMPLETE).click();
        return this;
    }


}
