package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    WebDriver driver;
    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private By successMessage = By.xpath("//li[@aria-current='page']");
    private By logoutButton = By.linkText("Logout");
    private By newsletterLink = By.linkText("Newsletter");
    private By transactionLink = By.linkText("Transactions");
    private By returnLink = By.linkText("Returns");
    private By rewardPoinsLink = By.linkText("Reward Points");
    private By downloadsPointsLink = By.linkText("Downloads");
    private By orderHistoryLink = By.linkText("Order History");
    private By wishlistLink = By.linkText("Wish List");
    private By editaccountLink = By.linkText("Edit Account");
    private By successUpdatedAccountMessage = By.cssSelector(".alert.alert-success.alert-dismissible");
    private By addressBookLink = By.linkText("Address Book");
    private By changePasswordLink = By.linkText("Password");


    public String getSuccessMessage() {
        String message = driver.findElement(successMessage).getText();
        return message;
    }

    public LogInPage loginClickLogoutButton() {
        driver.findElement(logoutButton).click();
        return new LogInPage(driver);
    }

    public NewsletterPage clickOnNewsletterLink() {
        driver.findElement(newsletterLink).click();
        return new NewsletterPage(driver);
    }

    public TransactionPage clickOnTransactionButton() {
        driver.findElement(transactionLink).click();
        return new TransactionPage(driver);
    }

    public ReturnsPage clickOnReturnLink() {
        driver.findElement(returnLink).click();
        return new ReturnsPage(driver);
    }

    public RewardPointsPage clickOnRewardPoinsLink() {
        driver.findElement(rewardPoinsLink).click();
        return new RewardPointsPage(driver) ;
    }

    public DownloadsPage clickOnDownloadsPointsLink() {
        driver.findElement(downloadsPointsLink).click();
        return new DownloadsPage(driver);
    }

    public OrderHistoryPage clickOnOrderHistoryLink() {
        driver.findElement(orderHistoryLink).click();
        return new OrderHistoryPage(driver);
    }

    public WishListPage clickOnWishlistLink() {
        driver.findElement(wishlistLink).click();
        return new WishListPage(driver);
    }

    public EditAccountPage clickOnEditAccountLink() {
        driver.findElement(editaccountLink).click();
        return new EditAccountPage(driver);
    }

    public String getUpdatedSuccessMessage() {
        String updatedAccountSuccessMessage = driver.findElement(successUpdatedAccountMessage).getText();
        return updatedAccountSuccessMessage;
    }

    public AddressBookPage clickOnAddressBookLink() {
        driver.findElement(addressBookLink).click();
        return new AddressBookPage(driver);
    }

    public ChangePasswordPage clickOnChangePasswordLink() {
        driver.findElement(changePasswordLink).click();
        return new ChangePasswordPage(driver);
    }


}
