package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage {
    WebDriver driver;
    WebDriverWait wait;
    public LogInPage(WebDriver driver) {
        this.driver=driver;
    }
    //locators
    private By emailTap = By.id("input-email");
    private By passwordTap = By.id("input-password");
    private By loginButton=By.xpath("//input[@class='btn btn-primary']");
    private By HomeTap=By.linkText("Home");
    private By emailField = By.xpath("//input[@name='email']");
    private By passwordField = By.xpath("//input[@name='password']");
    private By submitButton = By.xpath("//input[@type='submit']");

    private By errorMessage = By.cssSelector(".alert.alert-danger.alert-dismissible");

    private By forgotPasswordLink = By.linkText("Forgotten Password");

    private By successMessage = By.cssSelector(".alert.alert-success.alert-dismissible");

    private By RegistrationLink = By.linkText("Register");


    //actions
    public void EnterTheLoginData(String email, String pass){
        driver.findElement(emailTap).sendKeys(email);
        driver.findElement(passwordTap).sendKeys(pass);
        driver.findElement(loginButton).click();
    }
    public HomePage NavigateToHomePage(){
        driver.findElement(HomeTap).click();
        return new HomePage(driver);
    }
    public void insertEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    public void insertPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public AccountPage clickSubmitButton(){
        driver.findElement(submitButton).click();
        return new AccountPage(driver);
    }

    public String getErrorMessage()
    {
        return driver.findElement(errorMessage).getText();

    }

    public ForgotPasswordPage clickOnForgotPasswordLink(){
        driver.findElement(forgotPasswordLink).click();
        return new ForgotPasswordPage(driver);
    }

    public String getSuccessMessage()
    {
        String message = driver.findElement(successMessage).getText();
        return message;
    }

    public RegistrationPage clickOnRegistrationLink(){
        driver.findElement(RegistrationLink).click();
        return new RegistrationPage(driver);
    }
}
