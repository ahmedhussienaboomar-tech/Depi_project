package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditAccountPage {
    WebDriver driver;
    public EditAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    private By successMessage = By.xpath("//h1");
    private By editFirstName = By.xpath("//input[@name='firstname']");
    private By editLastName = By.xpath("//input[@name='lastname']");
    private By editEmail = By.xpath("//input[@name='email']");
    private By editTelephone = By.xpath("//input[@name='telephone']");
    private By continueButton = By.xpath("//input[@type='submit']");
    private By logoutButton = By.linkText("Logout");

    private By editErrorMessage = By.xpath("//div[@class='text-danger']");



    public String getSuccessMessage() {
        String Message = driver.findElement(successMessage).getText();
        return Message ;
    }

    public void editFirstName(String newFirstName){
        driver.findElement(editFirstName).clear();
        driver.findElement(editFirstName).sendKeys(newFirstName);
    }

    public void editLastName(String newLastName){
        driver.findElement(editLastName).clear();
        driver.findElement(editLastName).sendKeys(newLastName);
    }

    public void editEmail(String newEmail){
        driver.findElement(editEmail).clear();
        driver.findElement(editEmail).sendKeys(newEmail);
    }

    public void editTelephone(String newTelephone){
        driver.findElement(editTelephone).clear();
        driver.findElement(editTelephone).sendKeys(newTelephone);
    }

    public AccountPage clickContinueButton(){
        driver.findElement(continueButton).click();
        return new AccountPage(driver);
    }

    public LogoutPage editAccountInformationClickLogoutButton() {
        driver.findElement(logoutButton).click();
        return new LogoutPage(driver);
    }

    public String getEditErrorMessage(){
        String ErrorMessage =driver.findElement(editErrorMessage).getText();
        return ErrorMessage ;
    }
}
