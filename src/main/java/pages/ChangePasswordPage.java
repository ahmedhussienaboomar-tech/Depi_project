package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePasswordPage {
    WebDriver driver;
    public ChangePasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    private By successMessage = By.xpath("//h1");
    private By logoutButton = By.linkText("Logout");
    private By newPassword = By.xpath("//input[@name='password']");
    private By confirmNewPassword = By.xpath("//input[@name='confirm']");
    private By continueButton = By.xpath("//input[@type='submit']");
    private By emptyPasswordMessage =  By.xpath("//input[@name='password']/following-sibling::div");
    private By differentPasswordMessage =  By.xpath("//input[@name='confirm']/following-sibling::div");
    private By logoutLink = By.linkText("Logout");


    public String getSuccessMessage() {
        String Message = driver.findElement(successMessage).getText();
        return Message ;
    }

    public LogoutPage changePasswordClickLogoutButton() {
        driver.findElement(logoutButton).click();
        return new LogoutPage(driver);
    }

    public void insertNewPassword(String password) {
        driver.findElement(newPassword).sendKeys(password);
    }
    public void insertConfirmNewPassword(String confirmPassword) {
        driver.findElement(confirmNewPassword).sendKeys(confirmPassword);
    }

    public AccountPage clickContinueButton() {
        driver.findElement(continueButton).click();
        return new AccountPage(driver);
    }

    public String getEmptyPasswordErrorMessage() {
        return driver.findElement(emptyPasswordMessage).getText();
    }

    public String getDifferentPasswordErrorMessage() {
        return driver.findElement(differentPasswordMessage).getText();
    }

    public LogoutPage changePasswordClickLogout(){
        driver.findElement(logoutLink).click();
        return new LogoutPage(driver);
    }

}
