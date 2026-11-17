package cartTC;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckOutPage;
import pages.ProductDetailPage;

public class CartTC extends BaseTests {
    CartPage cartPage;
    ProductDetailPage detailPage;
    CheckOutPage checkOutPage;
    @Test
    public void TestNavigationToCartPageViaProduct() {
        homePage.AddToCart();
        String actual = homePage.CheckSucessMsg();
        String expected = "Success: ";
        Assert.assertTrue(actual.contains(expected));
        cartPage = homePage.NavigateToCartPage();
        String actual2 = cartPage.checkSuccesNavigationToCartPage();
        String expected2 = "Shopping Cart";
        Assert.assertTrue(actual2.contains(expected2));
    }

    @Test
    public void TestNavigationToDetailPage(){
        cartPage = homePage.NavigateToCartPageViaIcon();
        detailPage = cartPage.productDetailsPageNavigation();
        String actual = detailPage.checkSuccesNavigationToDetailPage();
        String expected = "HP LP3065";
        Assert.assertTrue(actual.contains(expected));
    }

    @Test
    public void TestNavigationToDetailCartPage(){
        cartPage = homePage.NavigateToCartPageViaIcon();
        cartPage.NvigateToCartPage();
        String actual2 = cartPage.checkSuccesNavigationToCartPage();
        String expected2 = "Shopping Cart";
        Assert.assertTrue(actual2.contains(expected2));
    }

    @Test
    public void TestUpdateTheProductQuantaty() {
        homePage.AddToCart();
        cartPage = homePage.NavigateToCartPageViaIcon();
        cartPage.NvigateToCartPage();
        cartPage.updateTheProduct(3);
        String actual = cartPage.checkSuccesUpdateProduct();
        String expected = "Success: ";
        Assert.assertTrue(actual.contains(expected));

    }

    @Test
    public void TestDeleteTheProduct() {
        homePage.AddToCart();
        cartPage = homePage.NavigateToCartPageViaIcon();
        cartPage.NvigateToCartPage();
        cartPage.deleteTheProduct();
        String actual = cartPage.checkSuccesdeleteTheProduct();
        String expected = "Continue";
        Assert.assertTrue(actual.contains(expected));

    }

    @Test
    public void TestReturnToHome(){
        homePage.AddToCart();
        cartPage = homePage.NavigateToCartPageViaIcon();
        cartPage.NvigateToCartPage();
        cartPage.ReturnToHomePage();
        String actual = homePage.HomeSucess();
        String expected = "SHOP NOW";
        Assert.assertTrue(actual.contains(expected));
    }

    @Test
    public void TestCheckOutNavigation(){
        homePage.AddToCart();
        cartPage = homePage.NavigateToCartPageViaIcon();
        cartPage.NvigateToCartPage();
        checkOutPage = cartPage.NavigateToCheckOut();
        String actual = checkOutPage.SucessNavigation();
        String expected = "Checkout";
        Assert.assertTrue(actual.contains(expected));
    }

    @Test
    public void TestCouponFild(){
        homePage.AddToCart();
        cartPage = homePage.NavigateToCartPageViaIcon();
        cartPage.NvigateToCartPage();
        cartPage.CouponCheck("nnn123");
        String actual = cartPage.VerficationMsg();
        String expected = "Warning";
        Assert.assertTrue(actual.contains(expected));
    }

    @Test
    public void TestgiftFild(){
        homePage.AddToCart();
        cartPage = homePage.NavigateToCartPageViaIcon();
        cartPage.NvigateToCartPage();
        cartPage.GiftCheck("nnn123");
        String actual = cartPage.VerficationMsg();
        String expected = "Warning";
        Assert.assertTrue(actual.contains(expected));
    }
    @Test
    public void TestShippingFild(){
        homePage.AddToCart();
        cartPage = homePage.NavigateToCartPageViaIcon();
        cartPage.NvigateToCartPage();
        cartPage.ShippingCheck("nnn123","American Samoa","Eastern");
        String actual = cartPage.checkSuccesShippingProduct();
        String expected = "Success: ";
        Assert.assertTrue(actual.contains(expected));
    }

}
