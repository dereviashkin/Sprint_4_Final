package pageobject.pages;

import org.junit.Test;

public class OrderPageTest extends BaseTest {

    /**
     * Всегда будет падать, т.к. попап окно подтверждения заказа после нажатия кнопки "Да" не закрывается
     */
    @Test
    public void createNewOrderSuccess() {
        OrderPage orderPage = new OrderPage();
        orderPage
                .openOrderPage()
                .checkIfOrderPageOpenedPersonInfo()
                .clickAcceptCookieButton()
                .fillPersonalDataOrderForm("Акакий", "Башмачков", "Питер", "88005553535")
                .clickNextButton()
                .checkIfOrderPageOpenedScooterInfo()
                .fillRentOrderForm("03.10.2022", "Comment")
                .clickOrderButton()
                .clickConfirmOrderButton()
                .checkIfConfirmOrderWindowClosed();
    }

    @Test
    public void createNewOrderIncorrectNumberFail() {
        OrderPage orderPage = new OrderPage();
        orderPage
                .openOrderPage()
                .checkIfOrderPageOpenedPersonInfo()
                .clickAcceptCookieButton()
                .fillPersonalDataOrderForm("Акакий", "Башмачков", "Питер", "asdafdafasd")
                .checkIfNoErrors(false);
    }
}