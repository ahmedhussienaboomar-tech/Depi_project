package blogDetailsTC;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AutherPage;
import pages.BlogPage;
import pages.DetailBlogPage;

public class BlogDetailsTC extends BaseTests {
    BlogPage blogPage;
    DetailBlogPage detailBlogPage;
    AutherPage autherPage;
    @BeforeMethod
    public void NavigateToBlogDetail(){
        blogPage= homePage.navigateToBlogPage();
        detailBlogPage=blogPage.DetailBlogNavigation();
    }
    @Test
    public void TestWritCommentWithValidData(){
        detailBlogPage.WritComment("aya","aya@gmail.com","very good device, so I was very happy");
        String actual=detailBlogPage.CheckSuccessComment();
        String expected="Thank you for your comment. It has been submitted to the webmaster for approval.";
        Assert.assertTrue(actual.contains(expected));
    }
    @Test
    public void TestWritCommentWithInValidName(){
        detailBlogPage.WritComment("ay","aya@gmail.com","very good device, so I was very happy");
        String actual=detailBlogPage.InValidCommentName();
        String expected="Warning: Comment Name must be between 3 and 25 characters!";
        Assert.assertTrue(actual.contains(expected));
    }
    @Test
    public void TestWritCommentWithInValidEmail(){
        detailBlogPage.WritComment("aya","ayagmail.com","very good device, so I was very happy");
        String actual=detailBlogPage.InValidCommentEmail();
        String expected="Warning: Invalid email id!";
        Assert.assertTrue(actual.contains(expected));
    }
    @Test
    public void TestWritCommentWithInValidComment(){
        detailBlogPage.WritComment("aya","aya@gmail.com","");
        String actual=detailBlogPage.InValidCommentContent();
        String expected="Warning: Comment Text must be between 25 and 1000 characters!";
        Assert.assertTrue(actual.contains(expected));
    }
    @Test
    public void TestAutherNavigation(){
        autherPage= detailBlogPage.AutherNavigation();
        String actualResult = autherPage.CheckAutherName();
        String expectedResult = "Mark Jecno";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
    @Test
    public void TestReplyButton()  {
        String actual = detailBlogPage.CheckReply();
        String expected = "CANCEL REPLY";
        Assert.assertTrue(actual.contains(expected));
    }
    @Test (dependsOnMethods = "TestReplyButton")
    public void TestCancelReplyButton() {
        String actual = detailBlogPage.CheckReply();
        String expected = "REPLY";
        Assert.assertTrue(actual.contains(expected));
    }
    @Test
    public void TestNavigateToDetailsPage(){
        detailBlogPage.NavigateToNewBlogDetailPage();
        String actualResult = detailBlogPage.CheckSucessMsg();
        String expectedResult = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }


}
