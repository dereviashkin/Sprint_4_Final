package pageobject.pages;

import org.junit.Test;

public class OrderPageTest extends BaseTest{

    @Test
    public void createNewOrderSuccess(){
        OrderPage orderPage = new OrderPage();
        orderPage
                .open()
                .fullOrderForm();
    }
}