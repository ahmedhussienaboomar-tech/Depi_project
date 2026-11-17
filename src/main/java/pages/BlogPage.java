package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogPage extends BasePage {

    public BlogPage(WebDriver driver) {
        super(driver);
    }

    private By businessNavigation = By.linkText("Business (16)");
    private By electronicsNavigation = By.linkText("Electronics (16)");
    private By technologyNavigation = By.linkText("Technology (16)");
    private By fashionNavigation = By.linkText("Fashion (16)");
    private By navigateToDetails = By.linkText("amet volutpat consequat mauris nunc congue nisi vitae suscipit tellus");
    private By addProductToWishListFromLatest = By.cssSelector(".btn.btn-wishlist.wishlist-107");
    private By wishListSucessMsg = By.cssSelector(".d-flex.mb-3.align-items-start");
    private By autherNavigation = By.linkText("Jolio Balia");
    private final By latestArticlesHeading = By.xpath("//*[contains(text(),'Latest Articles')]");

    @Override
    public boolean isDisplayed() {
        return waitVisible(latestArticlesHeading).isDisplayed();
    }

    public BusinessPage BusinessNavigation() {
        driver.findElement(businessNavigation).click();
        return new BusinessPage(driver);
    }

    public AutherPage AutherNvigation() {
        driver.findElement(autherNavigation).click();
        return new AutherPage(driver);
    }

    public ElectronicsPage ElectronicsNavigation() {
        driver.findElement(electronicsNavigation).click();
        return new ElectronicsPage(driver);
    }

    public TechnologyPage TechnologyNavigation() {
        driver.findElement(technologyNavigation).click();
        return new TechnologyPage(driver);
    }

    public FashionPage FashionNavigation() {
        driver.findElement(fashionNavigation).click();
        return new FashionPage(driver);
    }

    public DetailBlogPage DetailBlogNavigation() {
        driver.findElement(navigateToDetails).click();
        return new DetailBlogPage(driver);
    }

    public void AddProductToWishList() {
        driver.findElement(addProductToWishListFromLatest).click();
    }

    public String CheckSucessMsg() {
        return driver.findElement(wishListSucessMsg).getText();
    }
}