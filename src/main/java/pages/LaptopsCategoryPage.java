package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LaptopsCategoryPage extends BasePage {
    public LaptopsCategoryPage(WebDriver driver) {
        super(driver);
    }

    private final By categoryHeading = By.xpath("//h1[contains(text(),'Laptops')]");

    @Override
    public boolean isDisplayed() {
        return waitVisible(categoryHeading).isDisplayed();
    }
}