package ConfermOrder;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckOutPage;
import pages.ConfermOrderPage;

public class ConfermOrderTC extends BaseTests {
    CheckOutPage checkOutPage;
    CartPage cartPage;
    ConfermOrderPage confermOrderPage;

    @Test
    public void TestEditOnTheOrder(){
        homePage.AddToCart();
        cartPage = homePage.NavigateToCartPageViaIcon();
        checkOutPage = cartPage.NavigateToCheckoutByIcon();
        checkOutPage.BillingAddress("Aya","Hany","gg@j.v","123456","102gesrElSueze","123"
                ,"Cairo", "Algeria","Ain Defla");
        confermOrderPage=checkOutPage.Confirm();
        confermOrderPage.EditTheOrder();
        String actual = checkOutPage.SucessNavigation();
        String expected = "Checkout";
        Assert.assertTrue(actual.contains(expected));
    }
    @Test
    public void TestConfermation(){
        homePage.AddToCart();
        cartPage = homePage.NavigateToCartPageViaIcon();
        checkOutPage = cartPage.NavigateToCheckoutByIcon();
        checkOutPage.BillingAddress("Aya","Hany","gg@j.v","123456","102gesrElSueze","123"
                ,"Cairo", "Algeria","Ain Defla");
        confermOrderPage=checkOutPage.Confirm();
        confermOrderPage.Confermation();
        String actual = confermOrderPage.ConfermationMsg();
        String expected = "Your order has been placed!";
        Assert.assertTrue(actual.contains(expected));
    }
    @Test
    public void TestContinuToHomePage(){
        homePage.AddToCart();
        cartPage = homePage.NavigateToCartPageViaIcon();
        checkOutPage = cartPage.NavigateToCheckoutByIcon();
        checkOutPage.BillingAddress("Aya","Hany","gg@j.v","123456","102gesrElSueze","123"
                ,"Cairo", "Algeria","Ain Defla");
        confermOrderPage=checkOutPage.Confirm();
        confermOrderPage.Confermation();
        homePage=confermOrderPage.returnToHomepageAndContinue();
        String actual = homePage.HomeSucess();
        String expected = "SHOP NOW";
        Assert.assertTrue(actual.contains(expected));
    }


}
