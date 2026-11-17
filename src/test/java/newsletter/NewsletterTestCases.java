package newsletter;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LogInPage;
import pages.NewsletterPage;

public class NewsletterTestCases extends BaseTests {
    LogInPage loginPage;
    AccountPage accountPage;
    NewsletterPage newsletterPage;
    @Test
    public void testValidNewsletter()  {
        loginPage = homePage.clickMyAccount();
        loginPage.insertEmail("ah941381@gmail.com");
        loginPage.insertPassword("Ahmed123#");
        accountPage=loginPage.clickSubmitButton();
        newsletterPage =accountPage.clickOnNewsletterLink();
        String expectedlResult="Newsletter Subscription";
        String actualResult = newsletterPage.getSuccessMessage();
        Assert.assertTrue(actualResult.contains(expectedlResult));
    }
}
