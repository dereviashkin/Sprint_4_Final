package pageobject.pages;

import org.junit.Test;

public class OrderPageTest extends BaseTest {

    @Test
    public void createNewOrderSuccess() {
        OrderPage orderPage = new OrderPage();
        orderPage
                .open()
                .personalDataOrderForm("Акакий", "Башмачков", "Питер", "88005553535", true)
                .clickNextButton()
                .rentOrderForm();
    }

    @Test
    public void createNewOrderFail() {
        OrderPage orderPage = new OrderPage();
        orderPage
                .open()
                .personalDataOrderForm("Акакий", "Башмачков", "Питер", "asdafdafasd", false);
    }
}