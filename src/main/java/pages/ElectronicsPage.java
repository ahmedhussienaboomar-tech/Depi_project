package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElectronicsPage {
    WebDriver driver;
    public ElectronicsPage(WebDriver driver) {
        this.driver=driver;
    }
    //locators
    private By SucessMsg= By.cssSelector("#entry_210943 > h1");
    //actions
    public String CheckSucessMsg(){
        String msg=driver.findElement(SucessMsg).getText();
        return msg;
    }
}
