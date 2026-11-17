package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import base.BasePage;

public class HomePage extends BasePage {

    Actions actions;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // ---- Locators: checkout flow (existing, خاصة بالـ HomePage بس) ----
    private By product = By.linkText("HP LP3065");
    private By arrow = By.className("swiper-button-next");
    private By cartButton = By.cssSelector(".btn.btn-cart.cart-47");
    private By CartPageButton = By.linkText("View Cart");
    private By successMsg = By.cssSelector("#notification-box-top p");
    private By cartIcon = By.className("cart-icon");
    private By homeLogo = By.linkText("SHOP NOW");
    private By mYAccountTap = By.xpath("(//a[@class='icon-left both nav-link dropdown-toggle'])[3]");
    private By loginLink = By.linkText("Login");
    private By MyAccount = By.linkText("My account");

    private final By topTrendingCategoriesHeading =
            By.xpath("//*[contains(text(),'Top Trending Categories')]");

    @Override
    public boolean isDisplayed() {
        return waitVisible(topTrendingCategoriesHeading).isDisplayed();
    }

    public LogInPage clickMyAccount() {
        driver.findElement(MyAccount).click();
        return new LogInPage(driver);
    }

    public BlogPage navigateToBlogPage() {
        return clickBlogLink();
    }

    public void AddToCart() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        while (true) {
            try {
                WebElement productEl = driver.findElement(product);
                if (productEl.isDisplayed()) {
                    js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", productEl);
                    wait.until(ExpectedConditions.visibilityOf(productEl));
                    break;
                }
            } catch (Exception ignored) {
            }
            driver.findElement(arrow).click();
            wait.until(ExpectedConditions.elementToBeClickable(arrow));
        }

        WebElement productEl = driver.findElement(product);
        WebElement productContainer = productEl.findElement(By.xpath("./ancestor::div[contains(@class,'product')][1]"));

        actions = new Actions(driver);
        actions.moveToElement(productContainer).perform();

        wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        WebElement cartBtn = driver.findElement(cartButton);

        try {
            cartBtn.click();
        } catch (org.openqa.selenium.ElementNotInteractableException e) {
            js.executeScript("arguments[0].click();", cartBtn);
        }
    }

    public String CheckSucessMsg() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg));
        return driver.findElement(successMsg).getText();
    }

    public CartPage NavigateToCartPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CartPageButton));
        driver.findElement(CartPageButton).click();
        return new CartPage(driver);
    }

    public CartPage NavigateToCartPageViaIcon() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartIcon));
        driver.findElement(cartIcon).click();
        return new CartPage(driver);
    }

    public String HomeSucess() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(homeLogo)));
        return driver.findElement(homeLogo).getText();
    }

    public LogInPage NavigateToLogInPage() {
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(mYAccountTap)).perform();
        driver.findElement(loginLink).click();
        return new LogInPage(driver);
    }
}


