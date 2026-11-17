package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage  {
    WebDriver driver;
    public ProductDetailPage(WebDriver driver) {
        this.driver=driver;
    }
    //locators
    private By DetailSuccessMsg=By.cssSelector(".breadcrumb-item.active");

    //actions
    public String checkSuccesNavigationToDetailPage(){
        return driver.findElement(DetailSuccessMsg).getText();
    }
}
