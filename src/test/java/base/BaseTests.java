package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTests {
    public WebDriver driver;
    public WebDriverWait wait;
    protected HomePage homePage;
    @BeforeClass
    public void setup(){
        driver=new FirefoxDriver();
        driver.manage().window().maximize();
        homePage=new HomePage(driver);
    }

    @BeforeMethod
    public void OpenHomePage(){
        driver.get("https://ecommerce-playground.lambdatest.io/");
    }
    @AfterClass
    public void CloseDriver(){
        driver.quit();
    }
}
