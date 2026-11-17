package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class ForgotPasswordPage {
    WebDriver driver;
    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;    }

    private By emailBox = By.xpath("//input[@name='email']");
    private By retrieveButton = By.xpath("(//button[@type='submit'])[3]");

    public void insertEmail(String email){
        driver.findElement(emailBox).sendKeys(email);
    }

    public LogInPage clickRetrieveButton(){
        driver.findElement(retrieveButton).click();
        return new LogInPage(driver);
    }

}
