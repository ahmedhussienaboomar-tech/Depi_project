package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class DetailBlogPage {
    WebDriver driver;
    WebDriverWait wait;
    public DetailBlogPage(WebDriver driver) {
        this.driver=driver;
    }
    private By successMsg= By.cssSelector("#entry_210903 > h1");
    private By Cname= By.id("input-name");
    private By Cemail= By.id("input-email");
    private By Ccomment= By.id("input-comment");
    private By Csubmit= By.id("button-comment");
    private By AutherName= By.linkText("Mark Jecno");
    private By NameError=By.xpath("//*[@id=\"form-comment\"]/div[1]/div");
    private By ContantError=By.xpath("//*[@id=\"form-comment\"]/div[3]/div");
    private By EmailError=By.xpath("//*[@id=\"form-comment\"]/div[2]/div");
    private By SuccessComment=By.xpath("//form[@id='form-comment']/div[contains(@class,'alert-success')]");
    private By reply = By.xpath("//a[contains(@class,'reply')]");
    private By CancelReply = By.xpath("//a[contains(@class,'reply')]");
    private By newDetailPage = By.cssSelector("#mz-article-listing-image-79210917-0-0 > a.d-block.carousel-inner > div.carousel-item.active > img");

    public String CheckSucessMsg(){
        String msg = driver.findElement(successMsg).getText();
        return msg;
    }
    public void WritComment(String name,String Email, String Comment){
        driver.findElement(Cname).sendKeys(name);
        driver.findElement(Cemail).sendKeys(Email);
        driver.findElement(Ccomment).sendKeys(Comment);
        driver.findElement(Csubmit).click();
    }
    public String InValidCommentName(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(NameError)));
        String msg=driver.findElement(NameError).getText();
        return msg;
    }
    public String InValidCommentEmail(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(EmailError)));
        String msg=driver.findElement(EmailError).getText();
        return msg;
    }
    public String InValidCommentContent(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(ContantError)));
        String msg=driver.findElement(ContantError).getText();
        return msg;
    }
    public AutherPage AutherNavigation(){
        driver.findElement(AutherName).click();
        return new AutherPage(driver);
    }

    public String CheckSuccessComment() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(SuccessComment));
        String msg = driver.findElement(SuccessComment).getText();
        return msg;
    }

    public String CheckReply() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(reply));
        driver.findElement(reply).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(CancelReply));
        return  driver.findElement(CancelReply).getText();
    }

    public void NavigateToNewBlogDetailPage(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(newDetailPage));
        driver.findElement(newDetailPage).click();
    }



}
