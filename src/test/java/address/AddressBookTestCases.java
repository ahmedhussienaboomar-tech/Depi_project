package address;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.AddressBookPage;
import pages.LogInPage;


public class AddressBookTestCases extends BaseTests {
    LogInPage loginPage;
    AccountPage accountPage;
    AddressBookPage addressBookPage;
    @Test
    public void testAddressBookPageNavigation() {
        loginPage=homePage.clickMyAccount();
        loginPage.insertEmail("ah941381@gmail.com");
        loginPage.insertPassword("Ahmed123#");
        accountPage = loginPage.clickSubmitButton();
        addressBookPage =accountPage.clickOnAddressBookLink();
        String expectedResult="Address Book Entries";
        String actualResult=addressBookPage.getSuccessMessage();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

}
