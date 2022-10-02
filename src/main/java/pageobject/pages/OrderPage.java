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
        return this;
    }

    /**
     * Заполняет форму заказа тестовыми данными
     */
    public OrderPage fullOrderForm()   {
        getDriver().findElement(INPUT_NAME).sendKeys("Акакий");
        getDriver().findElement(INPUT_SURNAME).sendKeys("Башмачкин");
        getDriver().findElement(INPUT_ADDRESS).sendKeys("Петербург, н-ский департамент");
        selectMetroStation();
        getDriver().findElement(INPUT_PHONE_NUMBER).sendKeys("+79101234567");
        return this;
    }

    /**
     * Выбираем станцию метро
     */
    private void selectMetroStation(){
        getDriver().findElement(INPUT_METRO_STATION).click();
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(INPUT_METRO_STATION_CHERKIZOVSKAYA));
        getDriver().findElement(INPUT_METRO_STATION_CHERKIZOVSKAYA).click();
    }
}
