package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;
    Select select;
    public CartPage(WebDriver driver) {
        this.driver=driver;
    }

    //locators
    private By cartSuccessMsg= By.cssSelector(".breadcrumb-item.active");
    private By productName=By.linkText("HP LP3065");
    private By cartDetails =By.linkText("Edit cart");
    private By textTap=By.xpath("//div[@class='input-group flex-nowrap']/input[@type='text']");
    private By updateButton=By.xpath("//div[@class='input-group-append']/button[@type='submit']");
    private By updateSucess=By.cssSelector(".alert.alert-success.alert-dismissible");
    private By deleteButton=By.xpath("//div[@class='input-group-append']/button[@type='button']");
    private By deleteSucess=By.linkText("Continue");
    private By contToHome=By.linkText("Continue Shopping");
    private By checkoutButton=By.linkText("Checkout");
    private By couponFild=By.xpath("(//h5[contains(@class,'card-header') and contains(@class,'collapsed')])[1]");
    private By couponInput=By.xpath("//input[@name='coupon']");
    private By couponSubmit=By.id("button-coupon");
    private By EstimateShippingFild=By.xpath("(//h5[contains(@class,'card-header') and contains(@class,'collapsed')])[2]");
    private By EstimateShippingInputPostalCode=By.xpath("//input[@name='postcode']");
    private By EstimateShippingInputCountry=By.id("input-country");
    private By EstimateShippingInputRegion=By.id("input-zone");
    private By EstimateShippingSubmit=By.id("button-quote");
    private By giftFild=By.xpath("(//h5[contains(@class,'card-header') and contains(@class,'collapsed')])[3]");
    private By giftInput=By.xpath("//input[@name='voucher']");
    private By giftSubmit=By.id("button-voucher");
    private By verficationMsg=By.cssSelector(".alert.alert-danger.alert-dismissible");
    private By ratioButton=By.xpath("//input[@type='radio']");
    private By confirmration=By.id("button-shipping");
    private By checkOutButton=By.linkText("Checkout");
    //actions
    public String checkSuccesNavigationToCartPage(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(cartSuccessMsg)));
        return driver.findElement(cartSuccessMsg).getText();
    }
    public ProductDetailPage productDetailsPageNavigation(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(productName)));
        driver.findElement(productName).click();
        return new ProductDetailPage(driver);
    }
    public void NvigateToCartPage(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(cartDetails)));
        driver.findElement(cartDetails).click();
    }
    public void updateTheProduct(int number){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(cartSuccessMsg)));
        driver.findElement(textTap).clear();
        driver.findElement(textTap).sendKeys(String.valueOf(number));
        driver.findElement(updateButton).click();
    }
    public String checkSuccesUpdateProduct(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(updateSucess)));
        return driver.findElement(updateSucess).getText();
    }
    public String checkSuccesShippingProduct(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(updateSucess));
        return driver.findElement(updateSucess).getText();
    }

    public void deleteTheProduct(){
        driver.findElement(deleteButton).click();
    }
    public String checkSuccesdeleteTheProduct(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteSucess));
        return driver.findElement(deleteSucess).getText();
    }
    public HomePage ReturnToHomePage(){
        driver.findElement(contToHome).click();
        return new HomePage(driver);
    }
    public CheckOutPage NavigateToCheckOut(){
        driver.findElement(checkoutButton).click();
        return new CheckOutPage(driver);
    }

    public void CouponCheck(String input){
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(couponFild).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(couponInput));
        driver.findElement(couponInput).sendKeys(input);
        driver.findElement(couponSubmit).click();
    }
    public String VerficationMsg(){
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(verficationMsg));
        return driver.findElement(verficationMsg).getText();
    }

    public void GiftCheck(String input){
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(giftFild).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(giftInput));
        driver.findElement(giftInput).sendKeys(input);
        driver.findElement(giftSubmit).click();
    }

    public void ShippingCheck(String postal,String country , String Region){
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(EstimateShippingFild).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(EstimateShippingInputPostalCode));
        driver.findElement(EstimateShippingInputPostalCode).sendKeys(postal);
        select=new Select(driver.findElement(EstimateShippingInputCountry));
        select.selectByContainsVisibleText(country);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(EstimateShippingInputCountry, country));
        select=new Select(driver.findElement(EstimateShippingInputRegion));
        select.selectByContainsVisibleText(Region);
        driver.findElement(EstimateShippingSubmit).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(ratioButton));
        driver.findElement(ratioButton).click();
        driver.findElement(confirmration).click();
    }

    public CheckOutPage NavigateToCheckoutByIcon(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(checkOutButton)));
        driver.findElement(checkOutButton).click();
        return new CheckOutPage(driver);
    }


}
