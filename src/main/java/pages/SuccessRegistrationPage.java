package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SuccessRegistrationPage {
    WebDriver driver;
    SuccessRegistrationPage(WebDriver driver){
        this.driver=driver;
    }

    private By continueButton = By.xpath("//a[text()='Continue']");

    private By logoutButton = By.linkText("Logout");

    private By successMessage = By.xpath("//h1");



    public void clickOnContinueButton (){
        driver.findElement(continueButton).click();
    }

    public HomePage registrationClickOnLogoutButton(){
        driver.findElement(logoutButton).click();
        return new HomePage(driver);
    }

    public String getSuccessMessage(){
        String Message = driver.findElement(successMessage).getText();
        return Message;
    }
}
