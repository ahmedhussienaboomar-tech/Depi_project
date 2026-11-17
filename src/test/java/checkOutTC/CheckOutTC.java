package checkOutTC;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckOutPage;
import pages.ConfermOrderPage;
import pages.LogInPage;

public class CheckOutTC extends BaseTests {
    CartPage cartPage;
    CheckOutPage checkOutPage;
    LogInPage loginPage;
    ConfermOrderPage confermOrderPage;
    @Test
    public void TestNavigationToLoginPageAndThenCheckout() {
        loginPage = homePage.NavigateToLogInPage();
        loginPage.EnterTheLoginData("a1a2a3a@gmail.com","1234");
        homePage=loginPage.NavigateToHomePage();
        homePage.AddToCart();
        cartPage = homePage.NavigateToCartPageViaIcon();
        checkOutPage = cartPage.NavigateToCheckoutByIcon();
        String actual = checkOutPage.SucessNavigation();
        String expected = "Checkout";
        Assert.assertTrue(actual.contains(expected));
    }
    @Test
    public void TestValidDateInBuildAddress()  {
        homePage.AddToCart();
        cartPage = homePage.NavigateToCartPageViaIcon();
        checkOutPage = cartPage.NavigateToCheckoutByIcon();
        checkOutPage.BillingAddress("Aya","Hany","gg@j.v","123456","102gesrElSueze","123"
                ,"Cairo", "Algeria","Ain Defla");
        confermOrderPage=checkOutPage.Confirm();
        String actual = confermOrderPage.SucessNavigation();
        String expected = "Confirm Order";
        Assert.assertTrue(actual.contains(expected));
    }
    @Test
    public void TestInvalidAddInBuildAddress(){
        homePage.AddToCart();
        cartPage = homePage.NavigateToCartPageViaIcon();
        checkOutPage = cartPage.NavigateToCheckoutByIcon();
        checkOutPage.BillingAddress("Aya","Hany","gg@j.v","123456","10","123",
                "Cairo", "Algeria","Ain Defla");
        confermOrderPage=checkOutPage.Confirm();
        String actual = checkOutPage.InvaliedMsg();
        String expected = "Address 1 must be between 3 and 128 characters!";
        Assert.assertTrue(actual.contains(expected));
    }
    @Test
    public void TestInvalidCityInBuildAddress(){
        homePage.AddToCart();
        cartPage = homePage.NavigateToCartPageViaIcon();
        checkOutPage = cartPage.NavigateToCheckoutByIcon();
        checkOutPage.BillingAddress("Aya","Hany","gg@j.v","123456","102gesrElSueze","123",
                "C", "Algeria","Ain Defla");
        confermOrderPage=checkOutPage.Confirm();
        String actual = checkOutPage.InvaliedMsg();
        String expected = "City must be between 2 and 128 characters!";
        Assert.assertTrue(actual.contains(expected));
    }
    @Test
    public void TestInvalidLastNameInBuildAddress(){
        homePage.AddToCart();
        cartPage = homePage.NavigateToCartPageViaIcon();
        checkOutPage = cartPage.NavigateToCheckoutByIcon();
        checkOutPage.BillingAddress("Aya","","gg@j.v","123456","102gesrElSueze","123",
                "Cairo", "Algeria","Ain Defla");
        confermOrderPage=checkOutPage.Confirm();
        String actual = checkOutPage.InvaliedMsg();
        String expected = "Last Name must be between 1 and 32 characters!";
        Assert.assertTrue(actual.contains(expected));
    }
    @Test
    public void TestInvalidFirstNameInBuildAddress(){
        homePage.AddToCart();
        cartPage = homePage.NavigateToCartPageViaIcon();
        checkOutPage = cartPage.NavigateToCheckoutByIcon();
        checkOutPage.BillingAddress("","Hany","gg@j.v","123456","102gesrElSueze","123",
                "Cairo", "Algeria","Ain Defla");
        confermOrderPage=checkOutPage.Confirm();
        String actual = checkOutPage.InvaliedMsg();
        String expected = "First Name must be between 1 and 32 characters!";
        Assert.assertTrue(actual.contains(expected));
    }
    @Test
    public void TestInvalidEmailInBuildAddress(){
        homePage.AddToCart();
        cartPage = homePage.NavigateToCartPageViaIcon();
        checkOutPage = cartPage.NavigateToCheckoutByIcon();
        checkOutPage.BillingAddress("Aya","Hany","gg@jv","123456","102gesrElSueze","123",
                "Cairo", "Algeria","Ain Defla");
        confermOrderPage=checkOutPage.Confirm();
        String actual = checkOutPage.InvaliedMsg();
        String expected = "E-Mail address does not appear to be valid!";
        Assert.assertTrue(actual.contains(expected));
    }
    @Test
    public void TestInvalidPhoneInBuildAddress(){
        homePage.AddToCart();
        cartPage = homePage.NavigateToCartPageViaIcon();
        checkOutPage = cartPage.NavigateToCheckoutByIcon();
        checkOutPage.BillingAddress("Aya","Hany","gg@j.v","12","102gesrElSueze","123",
                "Cairo", "Algeria","Ain Defla");
        confermOrderPage=checkOutPage.Confirm();
        String actual = checkOutPage.InvaliedMsg();
        String expected = "Telephone must be between 3 and 32 characters!";
        Assert.assertTrue(actual.contains(expected));
    }
    @Test
    public void TestValidDateInOtherAddress()  {
        homePage.AddToCart();
        cartPage = homePage.NavigateToCartPageViaIcon();
        checkOutPage = cartPage.NavigateToCheckoutByIcon();
        checkOutPage.BillingAddress("Aya","Hany","gg@j.v","123456","102gesrElSueze","123",
                "Cairo", "Algeria","Ain Defla");
        checkOutPage.DiffAddress("Salma","Ahmad","22nasrcity","1234","Cairo","Algeria","Ain Defla");
        confermOrderPage=checkOutPage.Confirm();
        String actual = confermOrderPage.SucessNavigation();
        String expected = "Confirm Order";
        Assert.assertTrue(actual.contains(expected));
    }
    @Test
    public void TestContinueWithoutCheckTerms(){
        homePage.AddToCart();
        cartPage = homePage.NavigateToCartPageViaIcon();
        checkOutPage = cartPage.NavigateToCheckoutByIcon();
        checkOutPage.BillingAddress("Aya","Hany","gg@j.v","123456","102gesrElSueze","123",
                "Cairo", "Algeria","Ain Defla");
        checkOutPage.ConfiremWithoutTermCheck();
        String actual = checkOutPage.WarningMsg();
        String expected = "Warning: You must agree to the Terms & Conditions!";
        Assert.assertTrue(actual.contains(expected));
    }

}
