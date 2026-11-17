package order_history;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LogInPage;
import pages.OrderHistoryPage;

public class OrderHistoryTestCases extends BaseTests {
    LogInPage loginPage;
    AccountPage accountPage;
    OrderHistoryPage orderHistoryPage;

    @Test
    public void testValidOrderHistory() {
        loginPage = homePage.clickMyAccount();
        loginPage.insertEmail("ah941381@gmail.com");
        loginPage.insertPassword("Ahmed123#");
        accountPage = loginPage.clickSubmitButton();
        orderHistoryPage=accountPage.clickOnOrderHistoryLink();
        String expectedResult="Order History";
        String actualResult=orderHistoryPage.getSuccessMessage();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
