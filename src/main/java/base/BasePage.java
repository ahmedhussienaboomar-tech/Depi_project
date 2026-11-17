package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BlogPage;
import pages.HomePage;
import pages.LaptopsCategoryPage;
import pages.ProductListPage;

import java.time.Duration;
import java.util.Map;

public abstract class BasePage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected HomePage homePage;
	private final By logo = By.cssSelector("a[href*='route=common/home']");
    private final By homeLink = By.linkText("Home");
    private final By specialLink = By.partialLinkText("Special");
    private final By blogLink = By.linkText("Blog");
    private final By megaMenuLink = By.linkText("Mega Menu");
    private final By categoryLink = By.linkText("Shop by Category");
    private final By laptopsCategoryLink = By.linkText("Laptops & Notebooks");
    private final By footer = By.cssSelector("footer");
    private final By searchInput = By.name("search");
    private final By searchButton = By.cssSelector("#search button, div#search button, button.type-submit, .button-search");

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
     protected WebElement waitVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
     public boolean isLogoDisplayed() {
        return waitVisible(logo).isDisplayed();
    }

    public boolean isHomeLinkDisplayed() {
        return waitVisible(homeLink).isDisplayed();
    }

    public boolean isSpecialLinkDisplayed() {
        return waitVisible(specialLink).isDisplayed();
    }

    public boolean isBlogLinkDisplayed() {
        return waitVisible(blogLink).isDisplayed();
    }

    public boolean isMegaMenuDisplayed() {
        return waitVisible(megaMenuLink).isDisplayed();
    }

    public boolean isMenuDisplayed() {
        return isHomeLinkDisplayed()
                && isSpecialLinkDisplayed()
                && isBlogLinkDisplayed()
                && isMegaMenuDisplayed();
    }

    public String getFooterText() {
        return waitVisible(footer).getText();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

     public HomePage clickLogo() {
        waitVisible(logo).click();
        return new HomePage(driver);
    }

    public HomePage clickHomeLink() {
        waitVisible(homeLink).click();
        return new HomePage(driver);
    }

    public BlogPage clickBlogLink() {
        waitVisible(blogLink).click();
        return new BlogPage(driver);
    }

     public LaptopsCategoryPage clickLaptopsCategory() {
        driver.findElement(categoryLink).click();
        waitVisible(laptopsCategoryLink).click();
        return new LaptopsCategoryPage(driver);
    }

     public abstract boolean isDisplayed();


    private static final Map<String, String> CATEGORY_PATHS = Map.of(
            "desktop", "20",
            "laptop", "18",
            "notebook", "18",
            "component", "25",
            "tablet", "57",
            "software", "17",
            "phone", "24",
            "pda", "24",
            "camera", "33",
            "mp3", "34"
    );


    protected WebElement waitClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement waitPresent(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public ProductListPage searchFor(String keyword) {
        WebElement input = waitVisible(searchInput);
        input.clear();
        input.sendKeys(keyword, Keys.ENTER);

        try {
            driver.findElement(searchButton).click();
        } catch (Exception ignored) {
            // ENTER already triggered the search; the button click is just a backup
        }
        return new ProductListPage(driver);
    }

     public ProductListPage clickCategory(String categoryName) {
        driver.findElement(categoryLink).click();
        try {
            waitClickable(By.linkText(categoryName)).click();
        } catch (Exception e) {
            navigateToCategoryByPath(categoryName);
        }
        return new ProductListPage(driver);
    }

    private void navigateToCategoryByPath(String categoryName) {
        String lower = categoryName.toLowerCase();
        String path = CATEGORY_PATHS.entrySet().stream()
                .filter(entry -> lower.contains(entry.getKey()))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(() -> new RuntimeException(
                        "Category not found and no URL fallback available: " + categoryName));

        String baseUrl = utils.ConfigReader.getProperty("baseUrl");
        String indexUrl = baseUrl.contains("index.php")
                ? baseUrl.substring(0, baseUrl.indexOf("index.php") + "index.php".length())
                : (baseUrl.endsWith("/") ? baseUrl : baseUrl + "/") + "index.php";

        driver.get(indexUrl + "?route=product/category&path=" + path);
    }
}
