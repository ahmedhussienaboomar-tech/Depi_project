package login;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LogInPage;

public class LoginTestCases extends BaseTests {
    LogInPage loginPage ;
    AccountPage  accountPage;
    @Test(priority=1)
    public void ValidCredentials()  {

        loginPage = homePage.clickMyAccount();
        loginPage.insertEmail("ah941381@gmail.com");
        loginPage.insertPassword("Ahmed123#");
        accountPage = loginPage.clickSubmitButton();

        String actualResult = accountPage.getSuccessMessage();
        String expectedResult ="Account";
        Assert.assertTrue(actualResult.contains(expectedResult));

        loginPage = accountPage.loginClickLogoutButton();

    }
    @Test
    public void inValidPassword() {

        loginPage = homePage.clickMyAccount();
        loginPage.insertEmail("ah941381@gmail.com");
        loginPage.insertPassword("Ahmed");
        loginPage.clickSubmitButton();

        String actualResult = loginPage.getErrorMessage();
        String expectedResult ="No match for E-Mail Address and/or Password";
        Assert.assertTrue(actualResult.contains(expectedResult));

    }
    @Test
    public void inValidEmail() {
        loginPage = homePage.clickMyAccount();
        loginPage.insertEmail("ah9411381@gmail.com");
        loginPage.insertPassword("Ahmed123#");
        loginPage.clickSubmitButton();

        String actualResult = loginPage.getErrorMessage();
        String expectedResult ="Warning";
        Assert.assertTrue(actualResult.contains(expectedResult));

    }

    @Test
    public void emptyCredentials() {
        loginPage = homePage.clickMyAccount();
        loginPage.insertEmail("");
        loginPage.insertPassword("");
        loginPage.clickSubmitButton();

        String actualResult = loginPage.getErrorMessage();
        String expectedResult ="Warning";
        Assert.assertTrue(actualResult.contains(expectedResult));

    }
    @Test
    public void emptyPassword() {
        loginPage = homePage.clickMyAccount();
        loginPage.insertEmail("ah941381@gmail.com");
        loginPage.insertPassword("");
        loginPage.clickSubmitButton();

        String actualResult = loginPage.getErrorMessage();
        String expectedResult ="Warning";
        Assert.assertTrue(actualResult.contains(expectedResult));

    }
    @Test
    public void emptyEmail() {
        loginPage = homePage.clickMyAccount();
        loginPage.insertEmail("");
        loginPage.insertPassword("Ahmed123#");
        loginPage.clickSubmitButton();

        String actualResult = loginPage.getErrorMessage();
        String expectedResult ="Warning";
        Assert.assertTrue(actualResult.contains(expectedResult));

    }
    @Test
    public void unRegisteredEmail()  {
        loginPage = homePage.clickMyAccount();
        loginPage.insertEmail("ah2593002@gmail.com");
        loginPage.insertPassword("Ahmed123#");
        loginPage.clickSubmitButton();

        String actualResult = loginPage.getErrorMessage();
        String expectedResult ="Warning";
        Assert.assertTrue(actualResult.contains(expectedResult));

    }

}
