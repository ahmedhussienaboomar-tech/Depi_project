package wishlist;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LogInPage;
import pages.WishListPage;

public class WishListTestCases extends BaseTests {
    LogInPage loginPage;
    AccountPage accountPage;
    WishListPage wishListPage;
    @Test
    public void testValidWishList() {
        loginPage = homePage.clickMyAccount();
        loginPage.insertEmail("ah941381@gmail.com");
        loginPage.insertPassword("Ahmed123#");
        accountPage = loginPage.clickSubmitButton();
        wishListPage = accountPage.clickOnWishlistLink();
        String expectedResult="My Wish List";
        String actualResult=wishListPage.getSuccessMessage();
        Assert.assertTrue(actualResult.contains(expectedResult));

    }
}
