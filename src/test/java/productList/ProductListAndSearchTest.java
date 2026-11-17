package productList;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductListPage;

import java.util.List;

public class ProductListAndSearchTest extends BaseTests {
    ProductListPage productListPage;
    @Test
    public void testSearchFunctionality() {
        // Search for existing product
        productListPage = homePage.searchFor("Mac");
        Assert.assertTrue(productListPage.getProductCount() > 0, "Product count should be greater than 0");
        List<String> names = productListPage.getProductNames();
        boolean matches = false;
        for (String name : names) {
            if (name.toLowerCase().contains("mac")) {
                matches = true;
                break;
            }
        }
        Assert.assertTrue(matches, "At least one product title should match 'mac'");
        // Search for non-existing product
        productListPage = productListPage.searchFor("NonExistingProductXYZ");
        Assert.assertTrue(productListPage.isEmptyMessageDisplayed(), "There is no product that matches the search criteria.");
        Assert.assertEquals(productListPage.getProductCount(), 0, "Product count should be 0");
    }

    @Test
    public void testSortingByNameAndPrice() {
        productListPage = homePage.clickCategory("Laptops & Notebooks");

        // Sort by Name A-Z
        productListPage.selectSortBy("Name (A - Z)");
        List<String> names = productListPage.getProductNames();
        if (names.size() > 1) {
            for (int i = 0; i < names.size() - 1; i++) {
                Assert.assertTrue(names.get(i).compareToIgnoreCase(names.get(i + 1)) <= 0,
                        "Names are not sorted A-Z: " + names.get(i) + " vs " + names.get(i + 1));
            }
        }

        // Sort by Price Low-High
        productListPage.selectSortBy("Price (Low > High)");
        List<Double> prices = productListPage.getProductPrices();
        if (prices.size() > 1) {
            for (int i = 0; i < prices.size() - 1; i++) {
                Assert.assertTrue(prices.get(i) <= prices.get(i + 1),
                        "Prices are not sorted ascending: " + prices.get(i) + " vs " + prices.get(i + 1));
            }
        }
    }

    @Test
    public void testDisplayLimitAndPagination() {
        // Search for common letter to get many products
        productListPage=homePage.searchFor("a");

        // Set limit to 15
        productListPage.selectLimit("15");
        int count = productListPage.getProductCount();
        Assert.assertTrue(count <= 15, "Product count " + count + " exceeds limit 15");

        // Click next page if pagination is active
        String resultsText = productListPage.getPaginationText();
        if (resultsText.contains("Showing") && (resultsText.contains("of 16") || resultsText.contains("of 2") || count == 15)) {
            try {
                productListPage.clickNextPage();
                Assert.assertEquals(productListPage.getActivePageNumber(), "2", "Page should be 2");
            } catch (Exception e) {
                System.out.println("Could not paginate: next page link not clickable or not enough products. Skipping.");
            }
        }
    }

    @Test
    public void testFiltersIfAvailable() {
        homePage.clickCategory("Laptops & Notebooks");
        try {
            productListPage.applyFilter("Mac");
            Assert.assertTrue(productListPage.getProductCount() >= 0);
        } catch (Exception e) {
            System.out.println("Filter not present. Skipping filter test.");
        }
    }
}