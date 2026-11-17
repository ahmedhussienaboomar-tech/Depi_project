package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
    WebDriver driver;
    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }
    private By continueButton =By.xpath("//a[text()='Continue']");


    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }
}
