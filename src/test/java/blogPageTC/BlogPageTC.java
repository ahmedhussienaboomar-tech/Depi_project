package blogPageTC;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class BlogPageTC extends BaseTests {
    BlogPage blogPage;
    AutherPage autherPage;
    BusinessPage businessPage;
    DetailBlogPage detailBlogPage;
    ElectronicsPage electronicsPage;
    FashionPage fashionPage;
    TechnologyPage technologyPage;
    @BeforeMethod
    public void NavigateToBlogPage(){
        blogPage= homePage.navigateToBlogPage();
    }
    @Test (priority = 6)
    public void TestAutherNavigation(){
        autherPage= blogPage.AutherNvigation();
        String actualResult = autherPage.CheckAutherName();
        String expectedResult = "Jolio Balia";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
    @Test (priority = 1)
    public void TestBusinessNavigate(){
        businessPage=blogPage.BusinessNavigation();
        String actualResult = businessPage.CheckSucessMsg();
        String expectedResult = "Business";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
    @Test (priority = 5)
    public void TestDetailNavigation(){
        detailBlogPage=blogPage.DetailBlogNavigation();
        String actualResult = detailBlogPage.CheckSucessMsg();
        String expectedResult = "amet volutpat consequat mauris nunc congue nisi vitae suscipit tellus";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
    @Test (priority = 2)
    public void TestElectronicNavigation(){
        electronicsPage=blogPage.ElectronicsNavigation();
        String actualResult = electronicsPage.CheckSucessMsg();
        String expectedResult = "Electronics";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
    @Test (priority = 3)
    public void TestFashionNavigation(){
        fashionPage=blogPage.FashionNavigation();
        String actualResult = fashionPage.CheckSucessMsg();
        String expectedResult = "Fashion";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
    @Test (priority = 4)
    public void TestTechnologyNavigation(){
        technologyPage=blogPage.TechnologyNavigation();
        String actualResult = technologyPage.CheckSucessMsg();
        String expectedResult = "Technology";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
    @Test (priority = 7)
    public void TestAddProductToWhishList(){
        blogPage.AddProductToWishList();
        String actualResult = blogPage.CheckSucessMsg();
        String expectedResult = "Success: ";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }


}
