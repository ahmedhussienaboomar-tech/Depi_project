package change_password;


import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.ChangePasswordPage;
import pages.LogInPage;
import pages.LogoutPage;

public class ChangePasswordTestCases extends BaseTests {
    LogInPage loginPage;
    AccountPage accountPage;
    ChangePasswordPage changePasswordPage;
    LogoutPage logoutPage;
    @Test(priority = 1)
    public void testChangePasswordPageNavigation() throws InterruptedException {
        loginPage=homePage.clickMyAccount();
        loginPage.insertEmail("ah941381@gmail.com");
        loginPage.insertPassword("Ahmed123#");
        accountPage = loginPage.clickSubmitButton();
        changePasswordPage =accountPage.clickOnChangePasswordLink();
        String expectedResult="Change Password";
        String actualResult=changePasswordPage.getSuccessMessage();
        Assert.assertTrue(actualResult.contains(expectedResult));
        logoutPage = changePasswordPage.changePasswordClickLogoutButton();
        logoutPage.clickContinueButton();

    }

    @Test(priority = 2)
    public void testValidChangePassword() throws InterruptedException {
        loginPage=homePage.clickMyAccount();
        loginPage.insertEmail("ah941381@gmail.com");
        loginPage.insertPassword("Ahmed123#");
        accountPage = loginPage.clickSubmitButton();
        changePasswordPage =accountPage.clickOnChangePasswordLink();
        changePasswordPage.insertNewPassword("Ahmed123#");
        changePasswordPage.insertConfirmNewPassword("Ahmed123#");
        accountPage = changePasswordPage.clickContinueButton();
        String expectedResult="Success: Your password has been successfully updated";
        String actualResult=accountPage.getUpdatedSuccessMessage();
        Assert.assertTrue(actualResult.contains(expectedResult));
        loginPage = accountPage.loginClickLogoutButton();

    }

    @Test(priority = 3)
    public void testErrorEmptyChangePassword() throws InterruptedException {
        loginPage=homePage.clickMyAccount();
        loginPage.insertEmail("ah941381@gmail.com");
        loginPage.insertPassword("Ahmed123#");
        accountPage = loginPage.clickSubmitButton();
        changePasswordPage =accountPage.clickOnChangePasswordLink();
        changePasswordPage.insertNewPassword("");
        changePasswordPage.insertConfirmNewPassword("");
        changePasswordPage.clickContinueButton();
        String expectedResult="Password must be between 4 and 20 characters";
        String actualResult=changePasswordPage.getEmptyPasswordErrorMessage();
        Assert.assertTrue(actualResult.contains(expectedResult));
        logoutPage = changePasswordPage.changePasswordClickLogout();
        logoutPage.clickContinueButton();

    }

    @Test(priority =4)
    public void testErrorDifferentPasswordAndConfirm() throws InterruptedException {
        loginPage=homePage.clickMyAccount();
        loginPage.insertEmail("ah941381@gmail.com");
        loginPage.insertPassword("Ahmed123#");
        accountPage = loginPage.clickSubmitButton();
        changePasswordPage =accountPage.clickOnChangePasswordLink();
        changePasswordPage.insertNewPassword("Ahmed123#");
        changePasswordPage.insertConfirmNewPassword("Ahmed123");
        changePasswordPage.clickContinueButton();
        Thread.sleep(2000);
        String expectedResult="Password confirmation does not match password";
        String actualResult=changePasswordPage.getDifferentPasswordErrorMessage();
        Assert.assertTrue(actualResult.contains(expectedResult));
        logoutPage = changePasswordPage.changePasswordClickLogout();
        logoutPage.clickContinueButton();

    }

}
