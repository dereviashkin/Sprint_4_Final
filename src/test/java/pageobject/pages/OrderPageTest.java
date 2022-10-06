package pageobject.pages;

import org.junit.Test;

public class OrderPageTest extends BaseTest {

    @Test
    public void createNewOrderSuccess() {
        OrderPage orderPage = new OrderPage("Акакий", "Башмачков", "Питер", "Черкизовская", "88005553535", "03.10.2022", "Comment");
        orderPage
                .openOrderPage()
                .checkIfOrderPageOpenedPersonInfo()
                .clickAcceptCookieButton()
                .fillPersonalDataOrderForm()
                .checkIfPesonalDataFormFilledCorrect()
                .checkIfNoErrors(true)
                .clickNextButton()
                .checkIfOrderPageOpenedScooterInfo()
                .fillRentOrderForm()
                .checkIfScooterDataFormFilledCorrect()
                .clickOrderButton()
                .clickConfirmOrderButton();
    }

    @Test
    public void createNewOrderFail() {
        OrderPage orderPage = new OrderPage("Акакий", "Башмачков", "Питер", "Черкизовская", "asdafdafasd");
        orderPage
                .openOrderPage()
                .checkIfOrderPageOpenedPersonInfo()
                .clickAcceptCookieButton()
                .fillPersonalDataOrderForm()
                .checkIfPesonalDataFormFilledCorrect()
                .checkIfNoErrors(false);
    }
}