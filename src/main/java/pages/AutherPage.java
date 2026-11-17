package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AutherPage {
    WebDriver driver;
    public AutherPage(WebDriver driver) {
        this.driver = driver;
    }
    //locators
    private By autherName =By.cssSelector("#entry_210926 > h1");
    //Actions
    public String CheckAutherName(){
        String name = driver.findElement(autherName).getText();
        return name;
    }
}
