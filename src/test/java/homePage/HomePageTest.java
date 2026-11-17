package homePage;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlogPage;
import pages.LaptopsCategoryPage;

public class HomePageTest extends BaseTests {

    @Test
    public void verifyPageTitle() {
        String title = homePage.getPageTitle();
        Assert.assertEquals(title, "Your Store", "Page title did not match!");
    }

    @Test
    public void verifyLogoIsDisplayed() {
        Assert.assertTrue(homePage.isLogoDisplayed(), "Logo is not displayed!");
    }

    @Test
    public void verifyMenuIsDisplayed() {
        Assert.assertTrue(homePage.isMenuDisplayed(), "Menu is not displayed!");
    }

    @Test
    public void verifyHomeLinkIsDisplayed() {
        Assert.assertTrue(homePage.isHomeLinkDisplayed(), "Home link is not displayed!");
    }

    @Test
    public void verifyBlogLinkIsDisplayed() {
        Assert.assertTrue(homePage.isBlogLinkDisplayed(), "Blog link is not displayed!");
    }

    @Test
    public void verifyMegaMenuIsDisplayed() {
        Assert.assertTrue(homePage.isMegaMenuDisplayed(), "Mega Menu is not displayed!");
    }

    @Test
    public void verifyFooterTextContainsCopyright() {
        String footerText = homePage.getFooterText();
        Assert.assertTrue(footerText.contains("LambdaTest"), "Footer does not contain expected text!");
    }

    @Test
    public void verifyClickingBlogNavigatesCorrectly() {
        BlogPage blogPage = homePage.clickBlogLink();
        Assert.assertTrue(blogPage.isDisplayed(), "Blog page was not displayed after clicking Blog!");
    }

    @Test
    public void verifyClickingLogoReturnsToHomePage() {
        BlogPage blogPage = homePage.clickBlogLink();
        homePage = blogPage.clickLogo();
        Assert.assertTrue(homePage.isDisplayed(), "Logo did not navigate back to the home page!");
    }

    @Test
    public void verifyClickingLaptopsCategoryNavigatesCorrectly() {
        // Random navigation example: Home -> "Laptops & Notebooks" category
        LaptopsCategoryPage laptopsPage = homePage.clickLaptopsCategory();
        Assert.assertTrue(laptopsPage.isDisplayed(), "Laptops & Notebooks page was not displayed!");
        Assert.assertTrue(laptopsPage.isMenuDisplayed(), "Menu is not displayed on the Laptops page!");
    }
}
