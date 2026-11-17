package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfermOrderPage {
    WebDriver driver;
    WebDriverWait wait;
    public ConfermOrderPage(WebDriver driver) {
        this.driver=driver;
    }
    private By sucessMsg=By.cssSelector(".breadcrumb-item.active");
    private By editButton=By.linkText("Edit");
    private By confermMsg=By.cssSelector(".page-title.my-3");
    private By ConfermButton=By.id("button-confirm");
    private By continuButton=By.linkText("Continue");

    public String SucessNavigation(){
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(sucessMsg)));
        return driver.findElement(sucessMsg).getText();
    }
    public void Confermation(){
        driver.findElement(ConfermButton).click();
    }
    public HomePage returnToHomepageAndContinue(){
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(confermMsg));
        driver.findElement(continuButton).click();
        return new HomePage(driver);
    }
    public String ConfermationMsg(){
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(confermMsg));
        return driver.findElement(confermMsg).getText();
    }
    public CheckOutPage EditTheOrder(){
        driver.findElement(editButton).click();
        return new CheckOutPage(driver);
    }
}
