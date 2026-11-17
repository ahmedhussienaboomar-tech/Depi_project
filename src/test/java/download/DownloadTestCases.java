package download;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.DownloadsPage;
import pages.LogInPage;

public class DownloadTestCases extends BaseTests {
    LogInPage loginPage;
    AccountPage accountPage;
    DownloadsPage downloadsPage;

    @Test
    public void testValidDownloadsPage() throws InterruptedException {
        loginPage = homePage.clickMyAccount();
        loginPage.insertEmail("ah941381@gmail.com");
        loginPage.insertPassword("Ahmed123#");
        accountPage = loginPage.clickSubmitButton();
        downloadsPage = accountPage.clickOnDownloadsPointsLink();
        String expectedResult="Account Downloads";
        String actualResult=downloadsPage.getSuccessMessage();
        Assert.assertTrue(actualResult.contains(expectedResult));

    }
}
