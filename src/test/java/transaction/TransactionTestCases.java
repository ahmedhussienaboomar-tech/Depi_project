package transaction;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LogInPage;
import pages.TransactionPage;

public class TransactionTestCases extends BaseTests {
    LogInPage loginPage;
    AccountPage accountPage;
    TransactionPage transactionPage;
    @Test
	public void testValidTransaction(){
        loginPage = homePage.clickMyAccount();
        loginPage.insertEmail("ah941381@gmail.com");
        loginPage.insertPassword("Ahmed123#");
        accountPage = loginPage.clickSubmitButton();
        transactionPage = accountPage.clickOnTransactionButton();
        String expectedResult="Your Transactions";
        String actualResult=transactionPage.getSuccessMessage();
        Assert.assertTrue(actualResult.contains(expectedResult));

    }

}
