package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishListPage {
    WebDriver driver;
    public WishListPage(WebDriver driver) {
        this.driver = driver;
    }

    private By successMessage = By.xpath("//h1");

    public String getSuccessMessage() {
        String Message = driver.findElement(successMessage).getText();
        return Message ;
    }
}
