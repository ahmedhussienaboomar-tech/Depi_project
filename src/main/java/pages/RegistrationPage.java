package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    WebDriver driver;
    public RegistrationPage(WebDriver driver){
        this.driver = driver;
    }

    private By firstName = By.xpath("//input[@name='firstname']");
    private By lastName = By.xpath("//input[@name='lastname']");
    private By emailField = By.xpath("//input[@name='email']");
    private By telephoneField = By.xpath("//input[@name='telephone']");
    private By passwordField = By.xpath("//input[@name='password']");
    private By confirmPasswordField = By.xpath("//input[@name='confirm']");
    private By privacyPolicyBox = By.id("input-agree");
    private By submitButton = By.xpath("//input[@type='submit']");
    private By emptyFirstNameMessage =  By.xpath("//div[@class='text-danger']");
    private By emptyLastNameMessage =  By.xpath("//div[@class='text-danger']");
    private By emptyEmailMessage =  By.xpath("//div[@class='text-danger']");
    private By emptyTelephoneMessage =  By.xpath("//div[@class='text-danger']");
    private By emptyPasswordMessage =  By.xpath("//div[@class='text-danger']");
    private By emptyPasswordConfirmMessage =  By.xpath("//div[@class='text-danger']");
    private By differentPasswordMessage =  By.xpath("//div[@class='text-danger']");


    public void insertFirstName(String FirstName){
        driver.findElement(firstName).sendKeys(FirstName);
    }

    public void insertLastName(String LastName){
        driver.findElement(lastName).sendKeys(LastName);
    }

    public void insertEmail(String Email){
        driver.findElement(emailField).sendKeys(Email);
    }

    public void insertTelephone(String Telephone){
        driver.findElement(telephoneField).sendKeys(Telephone);
    }

    public void insertPassword(String Password){
        driver.findElement(passwordField).sendKeys(Password);
    }

    public void insertConfirmPassword(String ConfirmedPassword){
        driver.findElement(confirmPasswordField).sendKeys(ConfirmedPassword);
    }

    public void clickOnPrivacyPolicyBox() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",
                driver.findElement(privacyPolicyBox));
    }
    public SuccessRegistrationPage clickOnSubmitButton(){
        driver.findElement(submitButton).click();
        return new SuccessRegistrationPage(driver);
    }

    public String getEmptyFirstNameErrorMessage() {
        return driver.findElement(emptyFirstNameMessage).getText();
    }

    public String getEmptyLastNameErrorMessage() {
        return driver.findElement(emptyLastNameMessage).getText();
    }

    public String getEmptyEmailErrorMessage() {
        return driver.findElement(emptyEmailMessage).getText();
    }

    public String getEmptyTelephoneErrorMessage() {
        return driver.findElement(emptyTelephoneMessage).getText();
    }

    public String getEmptyPasswordErrorMessage() {
        return driver.findElement(emptyPasswordMessage).getText();
    }

    public String getEmptyPasswordConfirmErrorMessage() {
        return driver.findElement(emptyPasswordConfirmMessage).getText();
    }

    public String getDifferentPasswordErrorMessage() {
        return driver.findElement(differentPasswordMessage).getText();
    }


}
