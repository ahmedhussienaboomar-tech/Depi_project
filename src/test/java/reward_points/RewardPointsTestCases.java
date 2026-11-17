package reward_points;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LogInPage;
import pages.RewardPointsPage;

public class RewardPointsTestCases extends BaseTests {
    LogInPage loginPage;
    AccountPage accountPage;
    RewardPointsPage rewardPointsPage;
    @Test
    public void testRewardPointsPageNavigation() {
        loginPage=homePage.clickMyAccount();
        loginPage.insertEmail("ah941381@gmail.com");
        loginPage.insertPassword("Ahmed123#");
        accountPage = loginPage.clickSubmitButton();
        rewardPointsPage=accountPage.clickOnRewardPoinsLink();
        String expectedResult="Your Reward Points";
        String actualResult=rewardPointsPage.getSuccessMessage();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
