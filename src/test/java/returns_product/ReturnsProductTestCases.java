package returns_product;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LogInPage;
import pages.ReturnsPage;

public class ReturnsProductTestCases extends BaseTests {
    LogInPage loginPage;
    AccountPage accountPage;
    ReturnsPage returnsPage;
    @Test
    public void testValidReturnsProduct() throws InterruptedException {
        loginPage = homePage.clickMyAccount();
        loginPage.insertEmail("ah941381@gmail.com");
        loginPage.insertPassword("Ahmed123#");
        accountPage = loginPage.clickSubmitButton();
        returnsPage=accountPage.clickOnReturnLink();
        String expectedResult="Product Returns";
        String actualResult=returnsPage.getSuccessMessage();
        Assert.assertTrue(actualResult.contains(expectedResult));
        Thread.sleep(5000);

    }
}
