package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutPage {
    WebDriver driver;
    WebDriverWait wait;
    Select select;
    public CheckOutPage(WebDriver driver) {
        this.driver=driver;
    }
    private By sucessMsg=By.cssSelector(".breadcrumb-item.active");
    private By warning=By.cssSelector(".alert.alert-warning.alert-dismissible");
    private By firstName=By.id("input-payment-firstname");//allvalied
    private By firstNameShipping=By.id("input-shipping-firstname");
    private By lastName=By.id("input-payment-lastname");//allvalid
    private By lastNameShipping=By.id("input-shipping-lastname");
    private By email=By.id("input-payment-email");
    private By phone=By.id("input-payment-telephone");
    private By Adress1=By.id("input-payment-address-1");//Address 1 must be between 3 and 128 characters!
    private By AdrressShipping=By.id("input-shipping-address-1");
    private By City=By.id("input-payment-city");//City must be between 2 and 128 characters!City must be between 2 and 128 characters!
    private By CityShipping=By.id("input-shipping-city");
    private By country=By.id("input-payment-country");
    private By countryShipping=By.id("input-shipping-country");
    private By state=By.id("input-payment-zone");
    private By stateShipping=By.id("input-shipping-zone");
    private By guestOption=By.xpath("(//label[@class='custom-control-label'])[3]");
    private By shipping_address_same=By.xpath("(//label[@class='custom-control-label'])[5]");
    private By InValidMsg=By.cssSelector(".invalid-feedback.d-block");
    private By TermsChickButton=By.xpath("(//label[@class='custom-control-label'])[10]");
    private By submit=By.id("button-save");
    private By postalcode=By.id("input-payment-postcode");
    private By postalcodeShipping=By.id("input-shipping-postcode");


    public String SucessNavigation(){
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(sucessMsg));
        return driver.findElement(sucessMsg).getText();
    }
    public void BillingAddress(String FN, String LN,String Email , String Phone ,String Add1,String PC, String city, String Country, String State){
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(sucessMsg)));
        driver.findElement(guestOption).click();
        driver.findElement(firstName).sendKeys(FN);
        driver.findElement(lastName).sendKeys(LN);
        driver.findElement(email).sendKeys(Email);
        driver.findElement(phone).sendKeys(Phone);
        driver.findElement(Adress1).sendKeys(Add1);
        driver.findElement(postalcode).sendKeys(PC);
        driver.findElement(City).sendKeys(city);
        select = new Select(driver.findElement(country));
        select.selectByContainsVisibleText(Country);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(country,Country));
        select = new Select(driver.findElement(state));
        select.selectByContainsVisibleText(State);
    }
    public void DiffAddress(String FN, String LN ,String Add1,String PC, String city, String Country, String State){
        driver.findElement(shipping_address_same).click();
        driver.findElement(firstNameShipping).sendKeys(FN);
        driver.findElement(lastNameShipping).sendKeys(LN);
        driver.findElement(AdrressShipping).sendKeys(Add1);
        driver.findElement(postalcodeShipping).sendKeys(PC);
        driver.findElement(CityShipping).sendKeys(city);
        select = new Select(driver.findElement(countryShipping));
        select.selectByContainsVisibleText(Country);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(countryShipping,Country));
        select = new Select(driver.findElement(stateShipping));
        select.selectByContainsVisibleText(State);
    }

    public ConfermOrderPage Confirm(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait.until(ExpectedConditions.presenceOfElementLocated(TermsChickButton));
        var termsElement = driver.findElement(TermsChickButton);
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", termsElement);
        js.executeScript("arguments[0].click();", termsElement);
        var submitElement = wait.until(ExpectedConditions.elementToBeClickable(submit));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", submitElement);
        submitElement.click();
        submitElement.click();
        return new ConfermOrderPage(driver);
    }
    public String InvaliedMsg(){
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(InValidMsg));
        return driver.findElement(InValidMsg).getText();
    }
    public void ConfiremWithoutTermCheck(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        driver.findElement(submit).click();
        driver.findElement(submit).click();
    }
    public String WarningMsg(){
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(warning));
        return driver.findElement(warning).getText();
    }


}
