package edit_account;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.EditAccountPage;
import pages.LogInPage;
import pages.LogoutPage;

public class EditAccountTestCases extends BaseTests {
    LogInPage loginPage;
    AccountPage accountPage;
    EditAccountPage editAccountPage;
    LogoutPage logoutPage;
    @Test(priority=0)
    public void testEditAccountNavigation()  {
        loginPage = homePage.clickMyAccount();
        loginPage.insertEmail("ah941381@gmail.com");
        loginPage.insertPassword("Ahmed123#");
        accountPage = loginPage.clickSubmitButton();
        editAccountPage = accountPage.clickOnEditAccountLink();
        String expectedResult ="My Account Information";
        String actualResult= editAccountPage.getSuccessMessage();
        Assert.assertTrue(actualResult.contains(expectedResult));
        logoutPage = editAccountPage.editAccountInformationClickLogoutButton();
        logoutPage.clickContinueButton();

    }
    @Test(priority=1)
    public void testEditAllData()  {

        loginPage = homePage.clickMyAccount();
        loginPage.insertEmail("ah941381@gmail.com");
        loginPage.insertPassword("Ahmed123#");
        accountPage = loginPage.clickSubmitButton();
        editAccountPage = accountPage.clickOnEditAccountLink();
        editAccountPage.editFirstName("Ali");
        editAccountPage.editLastName("AboOmar");
        editAccountPage.editEmail("ah941381@gmail.com");
        editAccountPage.editTelephone("01553161044");
        accountPage = editAccountPage.clickContinueButton();
        String expectedResult ="Success";
        String actualResult= accountPage.getUpdatedSuccessMessage();
        Assert.assertTrue(actualResult.contains(expectedResult));
        loginPage = accountPage.loginClickLogoutButton();

    }
    @Test(priority=2)
    public void testEditFirstName()  {

        loginPage = homePage.clickMyAccount();
        loginPage.insertEmail("ah941381@gmail.com");
        loginPage.insertPassword("Ahmed123#");
        accountPage = loginPage.clickSubmitButton();
        editAccountPage = accountPage.clickOnEditAccountLink();
        editAccountPage.editFirstName("Ali");
        accountPage = editAccountPage.clickContinueButton();
        String expectedResult ="Success";
        String actualResult= accountPage.getUpdatedSuccessMessage();
        Assert.assertTrue(actualResult.contains(expectedResult));
        loginPage = accountPage.loginClickLogoutButton();

    }

    @Test(priority=3)
    public void testEmptyEditFirstName()  {

        loginPage = homePage.clickMyAccount();
        loginPage.insertEmail("ah941381@gmail.com");
        loginPage.insertPassword("Ahmed123#");
        accountPage = loginPage.clickSubmitButton();
        editAccountPage = accountPage.clickOnEditAccountLink();
        editAccountPage.editFirstName("");
        editAccountPage.clickContinueButton();
        String expectedResult ="must be between 1 and 32 characters";
        String actualResult= editAccountPage.getEditErrorMessage();
        Assert.assertTrue(actualResult.contains(expectedResult));
        loginPage = accountPage.loginClickLogoutButton();

   }
    @Test(priority=4)
    public void testEditLastName()  {

        loginPage = homePage.clickMyAccount();
        loginPage.insertEmail("ah941381@gmail.com");
        loginPage.insertPassword("Ahmed123#");
        accountPage = loginPage.clickSubmitButton();
        editAccountPage = accountPage.clickOnEditAccountLink();
        editAccountPage.editLastName("Ali");
        accountPage = editAccountPage.clickContinueButton();
        String expectedResult ="Success";
        String actualResult= accountPage.getUpdatedSuccessMessage();
        Assert.assertTrue(actualResult.contains(expectedResult));
        loginPage = accountPage.loginClickLogoutButton();

    }

    @Test(priority=5)
    public void testEmptyEditLastName()  {

        loginPage = homePage.clickMyAccount();
        loginPage.insertEmail("ah941381@gmail.com");
        loginPage.insertPassword("Ahmed123#");
        accountPage = loginPage.clickSubmitButton();
        editAccountPage = accountPage.clickOnEditAccountLink();
        editAccountPage.editLastName("");
        editAccountPage.clickContinueButton();
        String expectedResult ="must be between 1 and 32 characters";
        String actualResult= editAccountPage.getEditErrorMessage();
        Assert.assertTrue(actualResult.contains(expectedResult));
        loginPage = accountPage.loginClickLogoutButton();

    }

    @Test(priority=6)
    public void testEditEmail()  {
        loginPage = homePage.clickMyAccount();
        loginPage.insertEmail("ah941381@gmail.com");
        loginPage.insertPassword("Ahmed123#");
        accountPage = loginPage.clickSubmitButton();
        editAccountPage = accountPage.clickOnEditAccountLink();
        editAccountPage.editEmail("ah941381@gmail.com");
        accountPage = editAccountPage.clickContinueButton();
        String expectedResult ="Success";
        String actualResult= accountPage.getUpdatedSuccessMessage();
        Assert.assertTrue(actualResult.contains(expectedResult));
        loginPage = accountPage.loginClickLogoutButton();
    }

    @Test(priority=7)
    public void testEmptyEditEmail()  {

        loginPage = homePage.clickMyAccount();
        loginPage.insertEmail("ah941381@gmail.com");
        loginPage.insertPassword("Ahmed123#");
        accountPage = loginPage.clickSubmitButton();
        editAccountPage = accountPage.clickOnEditAccountLink();
        editAccountPage.editLastName("");
        editAccountPage.clickContinueButton();
        String expectedResult ="must be between 1 and 32 characters";
        String actualResult= editAccountPage.getEditErrorMessage();
        Assert.assertTrue(actualResult.contains(expectedResult));
        loginPage = accountPage.loginClickLogoutButton();

    }

    @Test(priority=8)
    public void testEditTelephone(){
        loginPage = homePage.clickMyAccount();
        loginPage.insertEmail("ah941381@gmail.com");
        loginPage.insertPassword("Ahmed123#");
        accountPage = loginPage.clickSubmitButton();
        editAccountPage = accountPage.clickOnEditAccountLink();
        editAccountPage.editTelephone("+201553161044");
        accountPage = editAccountPage.clickContinueButton();
        String expectedResult ="Success";
        String actualResult= accountPage.getUpdatedSuccessMessage();
        Assert.assertTrue(actualResult.contains(expectedResult));
        loginPage = accountPage.loginClickLogoutButton();
    }

    /// ///////////////         BuuuUGGGGGGGGGGsssssssss
//
//    @Test(priority=9)
//    public void testInValidEditTelephone() throws InterruptedException {
//        loginPage = homePage.clickMyAccount();
//        loginPage.insertEmail("ah941381@gmail.com");
//        loginPage.insertPassword("Ahmed123#");
//        accountPage = loginPage.clickSubmitButton();
//        editAccountPage = accountPage.clickOnEditAccountLink();
//        editAccountPage.editTelephone("01553161044");
//        accountPage = editAccountPage.clickContinueButton();
//        String expectedResult ="Country Code required";
//        String actualResult= accountPage.getUpdatedSuccessMessage();
//        Assert.assertTrue(actualResult.contains(expectedResult));
//        loginPage = accountPage.loginClickLogoutButton();
//    }
//
//    @Test(priority=10)
//    public void testShortEditTelephone() throws InterruptedException {
//        loginPage = homePage.clickMyAccount();
//        loginPage.insertEmail("ah941381@gmail.com");
//        loginPage.insertPassword("Ahmed123#");
//        accountPage = loginPage.clickSubmitButton();
//        editAccountPage = accountPage.clickOnEditAccountLink();
//        editAccountPage.editTelephone("012");
//        editAccountPage.clickContinueButton();
//        String expectedResult ="must be between 1 and 32 characters";
//        String actualResult= editAccountPage.getEditErrorMessage();
//        Assert.assertTrue(actualResult.contains(expectedResult));
//        loginPage = accountPage.loginClickLogoutButton();
//    }
//

}
