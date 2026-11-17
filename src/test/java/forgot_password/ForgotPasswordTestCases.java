package forgot_password;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.LogInPage;

public class ForgotPasswordTestCases extends BaseTests {
    LogInPage loginPage ;
    ForgotPasswordPage forgotPasswordPage;
    @Test
    public void RetrievePassword(){
        loginPage = homePage.clickMyAccount();
        forgotPasswordPage = loginPage.clickOnForgotPasswordLink();
        forgotPasswordPage.insertEmail("ah941381@gmail.com");
        forgotPasswordPage.clickRetrieveButton();

        String expectedResult = "An email with a confirmation link has been sent your email address";
        String actualResult = loginPage.getSuccessMessage();
        Assert.assertTrue(actualResult.contains(expectedResult));

    }
}
