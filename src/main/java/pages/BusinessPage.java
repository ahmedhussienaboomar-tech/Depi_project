package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BusinessPage {
    WebDriver driver;
    public BusinessPage(WebDriver driver) {
        this.driver=driver;
    }
    private By successMsg= By.cssSelector("#entry_210943 > h1");

    public String CheckSucessMsg(){
        String msg = driver.findElement(successMsg).getText();
        return msg;
    }
}
