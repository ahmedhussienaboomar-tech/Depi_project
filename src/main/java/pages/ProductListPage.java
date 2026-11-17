package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class ProductListPage extends BasePage {

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    // Locators
    private final By productContainers = By.cssSelector(".product-layout, .product-thumb, .product-card");
    private final By productNames = By.cssSelector(".product-layout h4 a, .product-thumb h4 a, .product-card h4 a, .product-thumb .caption h4 a");
    private final By paginationText = By.xpath("//div[contains(text(), 'Showing') or contains(@class, 'results') or contains(@class, 'pagination-text')]");
    private final By sortDropdown = By.cssSelector("select[id^='input-sort']");
    private final By limitDropdown = By.cssSelector("select[id^='input-limit']");
    private final By paginationList = By.xpath("//ul[contains(@class,'pagination')]");
    private By searchResult=By.id("entry_212456");

    //actions
    public List<String> getProductNames() {
        return driver.findElements(productNames).stream()
                .filter(WebElement::isDisplayed)
                .map(el -> el.getText().trim())
                .collect(Collectors.toList());
    }

    public List<Double> getProductPrices() {
        return driver.findElements(productContainers).stream()
                .filter(WebElement::isDisplayed)
                .map(this::getProductPrice)
                .collect(Collectors.toList());
    }

    public int getProductCount() {
        waitVisible(searchResult);
        return getProductNames().size();
    }

    private double getProductPrice(WebElement productElement) {
        String priceText;
        try {
            priceText = productElement.findElement(By.className("price-new")).getText();
        } catch (Exception e) {
            try {
                priceText = productElement.findElement(By.className("price")).getText();
            } catch (Exception ex) {
                return 0.0;
            }
        }

        if (priceText == null || priceText.isBlank()) {
            return 0.0;
        }

        String firstToken = priceText.split("[\\n ]")[0];
        String digitsOnly = firstToken.replaceAll("[^0-9.]", "");

        try {
            return Double.parseDouble(digitsOnly);
        } catch (NumberFormatException nfe) {
            return 0.0;
        }
    }

    public void selectSortBy(String sortOption) {
        WebElement firstProduct = currentFirstProduct();
        selectDropdownOption(sortDropdown, sortOption);
        waitForPageStabilization(firstProduct);
    }

    public void selectLimit(String limitOption) {
        WebElement firstProduct = currentFirstProduct();
        selectDropdownOption(limitDropdown, limitOption);
        waitForPageStabilization(firstProduct);
    }

    private void selectDropdownOption(By dropdownLocator, String optionText) {
        WebElement dropdown = findVisibleDropdown(dropdownLocator);
        try {
            selectOptionByJS(dropdown, optionText);
        } catch (Exception e) {
            new Select(dropdown).selectByVisibleText(optionText);
        }
    }

    private WebElement findVisibleDropdown(By locator) {
        List<WebElement> dropdowns = driver.findElements(locator);
        return dropdowns.stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .orElseGet(() -> dropdowns.isEmpty() ? waitPresent(locator) : dropdowns.get(0));
    }

    private void selectOptionByJS(WebElement selectElement, String visibleText) {
        Select select = new Select(selectElement);
        String targetText = visibleText.trim().toLowerCase();

        String value = select.getOptions().stream()
                .filter(option -> {
                    String optText = option.getText().trim().toLowerCase();
                    return optText.contains(targetText) || targetText.contains(optText);
                })
                .map(option -> option.getAttribute("value"))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Option with text '" + visibleText + "' not found in select."));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].value = arguments[1];" +
                        "var event = document.createEvent('HTMLEvents');" +
                        "event.initEvent('change', true, true);" +
                        "arguments[0].dispatchEvent(event);",
                selectElement, value
        );
    }

    public void clickNextPage() {
        WebElement firstProduct = currentFirstProduct();
        try {
            waitClickable(By.xpath(paginationXpath() + "//a[text()='>']")).click();
        } catch (Exception e) {
            waitClickable(By.xpath("//a[contains(text(), 'Next') or contains(text(), '>') or contains(@class, 'next')]")).click();
        }
        waitForPageStabilization(firstProduct);
    }

    public void clickPageNumber(String pageNum) {
        WebElement firstProduct = currentFirstProduct();
        try {
            waitClickable(By.xpath(paginationXpath() + "//a[text()='" + pageNum + "']")).click();
        } catch (Exception e) {
            waitClickable(By.xpath("//a[contains(@href, 'page=" + pageNum + "') or text()='" + pageNum + "']")).click();
        }
        waitForPageStabilization(firstProduct);
    }

    public String getActivePageNumber() {
        try {
            WebElement activePage = driver.findElement(
                    By.xpath(paginationXpath() + "//li[contains(@class,'active') or contains(@class,'current')]"));
            return activePage.getText().replaceAll("[^0-9]", "").trim();
        } catch (Exception e) {
            return "1";
        }
    }

    public String getPaginationText() {
        try {
            return waitVisible(paginationText).getText().trim();
        } catch (Exception e) {
            try {
                return driver.findElement(By.cssSelector(".pagination-results, .pagination-text, .col-sm-6.text-right")).getText().trim();
            } catch (Exception ex) {
                return "";
            }
        }
    }

    public void applyFilter(String filterOptionName) {
        By checkboxLocator = By.xpath("//label[contains(normalize-space(), '" + filterOptionName + "')]//input[@type='checkbox']");
        WebElement checkbox = waitVisible(checkboxLocator);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }

        try {
            WebElement filterBtn = driver.findElement(By.id("button-filter"));
            if (filterBtn.isDisplayed()) {
                WebElement firstProduct = currentFirstProduct();
                filterBtn.click();
                waitForPageStabilization(firstProduct);
            }
        } catch (Exception e) {
            sleep(1000);
        }
    }

    public boolean isEmptyMessageDisplayed() {
        waitVisible(By.id("button-continue"));
        String bodyText = driver.findElement(By.id("entry_212469")).getText().toLowerCase();
        boolean hasEmptyMessage = bodyText.contains("there is no product")
                || bodyText.contains("empty")
                || bodyText.contains("no products")
                || bodyText.contains("no results")
                || bodyText.contains("no matching");

        if (hasEmptyMessage) {
            return true;
        }

        String currentUrl = driver.getCurrentUrl().toLowerCase();
        return currentUrl.contains("route=common/home") || currentUrl.endsWith("index.php")
                || currentUrl.endsWith(".io/") || currentUrl.endsWith("opencart/");
    }

    private String paginationXpath() {
        return "//ul[contains(@class,'pagination')]";
    }

    private WebElement currentFirstProduct() {
        try {
            return driver.findElement(productNames);
        } catch (Exception e) {
            return null;
        }
    }

    private void waitForPageStabilization(WebElement oldProduct) {
        if (oldProduct != null) {
            try {
                wait.until(ExpectedConditions.stalenessOf(oldProduct));
            } catch (Exception ignored) {
            }
        }
        sleep(1500);
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
            Thread.currentThread().interrupt();
        }
    }
}
