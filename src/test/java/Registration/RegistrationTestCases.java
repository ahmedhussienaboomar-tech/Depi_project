package Registration;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.RegistrationPage;
import pages.SuccessRegistrationPage;

public class RegistrationTestCases extends BaseTests {

    RegistrationPage registrationPage;
    LogInPage loginPage;
    SuccessRegistrationPage successRegistrationPage;
    @Test(priority=1)
    public void validRegistration()  {
        loginPage = homePage.clickMyAccount();
        registrationPage = loginPage.clickOnRegistrationLink();
        registrationPage.insertFirstName("Ahmed");
        registrationPage.insertLastName("Kumar");
        registrationPage.insertEmail("adrdv91603@bbyko.net");
        registrationPage.insertTelephone("01553161044");
        registrationPage.insertPassword("1234");
        registrationPage.insertConfirmPassword("1234");
        registrationPage.clickOnPrivacyPolicyBox();
        successRegistrationPage =registrationPage.clickOnSubmitButton();
        String expectedResult = "Your Account Has Been Created!";
        String actualResult = successRegistrationPage.getSuccessMessage();
        Assert.assertTrue(actualResult.contains(expectedResult));
        successRegistrationPage.registrationClickOnLogoutButton();
        successRegistrationPage.clickOnContinueButton();

    }

    @Test(priority=2)
    public void testErrorWhenEmptyFirstName()  {
        loginPage = homePage.clickMyAccount();
        registrationPage = loginPage.clickOnRegistrationLink();
        registrationPage.insertFirstName("");
        registrationPage.insertLastName("Kumar");
        registrationPage.insertEmail("bumtv22682@minitts.net");
        registrationPage.insertTelephone("01553161044");
        registrationPage.insertPassword("1234");
        registrationPage.insertConfirmPassword("1234");
        registrationPage.clickOnPrivacyPolicyBox();
        registrationPage.clickOnSubmitButton();
        String expectedResult = "First Name must be between 1 and 32 characters";
        String actualResult = registrationPage.getEmptyFirstNameErrorMessage();
        Assert.assertTrue(actualResult.contains(expectedResult));

    }

    @Test(priority=3)
    public void testErrorWhenEmptyLastName()  {
        loginPage = homePage.clickMyAccount();
        registrationPage = loginPage.clickOnRegistrationLink();
        registrationPage.insertFirstName("Kumar");
        registrationPage.insertLastName("");
        registrationPage.insertEmail("bumtv22682@minitts.net");
        registrationPage.insertTelephone("01553161044");
        registrationPage.insertPassword("1234");
        registrationPage.insertConfirmPassword("1234");
        registrationPage.clickOnPrivacyPolicyBox();
        registrationPage.clickOnSubmitButton();
        String expectedResult = "Last Name must be between 1 and 32 characters";
        String actualResult = registrationPage.getEmptyLastNameErrorMessage();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test(priority=4)
    public void testErrorWhenEmptyEmail() {
        loginPage = homePage.clickMyAccount();
        registrationPage = loginPage.clickOnRegistrationLink();
        registrationPage.insertFirstName("Kumar");
        registrationPage.insertLastName("Ali");
        registrationPage.insertEmail("");
        registrationPage.insertTelephone("01553161044");
        registrationPage.insertPassword("1234");
        registrationPage.insertConfirmPassword("1234");
        registrationPage.clickOnPrivacyPolicyBox();
        registrationPage.clickOnSubmitButton();
        String expectedResult = "E-Mail Address does not appear to be valid";
        String actualResult = registrationPage.getEmptyEmailErrorMessage();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test(priority=5)
    public void testErrorWhenEmptyTelephone()  {
        loginPage = homePage.clickMyAccount();
        registrationPage = loginPage.clickOnRegistrationLink();
        registrationPage.insertFirstName("Kumar");
        registrationPage.insertLastName("Kumar");
        registrationPage.insertEmail("bumtv22682@minitts.net");
        registrationPage.insertTelephone("");
        registrationPage.insertPassword("1234");
        registrationPage.insertConfirmPassword("1234");
        registrationPage.clickOnPrivacyPolicyBox();
        registrationPage.clickOnSubmitButton();
        String expectedResult = "Telephone must be between 3 and 32 characters";
        String actualResult = registrationPage.getEmptyEmailErrorMessage();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test(priority=6)
    public void testErrorWhenEmptyPassword()  {
        loginPage = homePage.clickMyAccount();
        registrationPage = loginPage.clickOnRegistrationLink();
        registrationPage.insertFirstName("Kumar");
        registrationPage.insertLastName("Kumar");
        registrationPage.insertEmail("bumtv22682@minitts.net");
        registrationPage.insertTelephone("01553161044");
        registrationPage.insertPassword("");
        registrationPage.insertConfirmPassword("1234");
        registrationPage.clickOnPrivacyPolicyBox();
        registrationPage.clickOnSubmitButton();
        String expectedResult = "Password must be between 4 and 20 characters";
        String actualResult = registrationPage.getEmptyPasswordErrorMessage();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test(priority=6)
    public void testErrorWhenEmptyConfirmPassword() {
        loginPage = homePage.clickMyAccount();
        registrationPage = loginPage.clickOnRegistrationLink();
        registrationPage.insertFirstName("Kumar");
        registrationPage.insertLastName("Kumar");
        registrationPage.insertEmail("bumtv22682@minitts.net");
        registrationPage.insertTelephone("01553161044");
        registrationPage.insertPassword("1234");
        registrationPage.insertConfirmPassword("");
        registrationPage.clickOnPrivacyPolicyBox();
        registrationPage.clickOnSubmitButton();
        String expectedResult = "Password confirmation does not match password";
        String actualResult = registrationPage.getEmptyPasswordConfirmErrorMessage();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test(priority=7)
    public void testErrorWhenDifferentPasswords() {
        loginPage = homePage.clickMyAccount();
        registrationPage = loginPage.clickOnRegistrationLink();
        registrationPage.insertFirstName("Kumar");
        registrationPage.insertLastName("Kumar");
        registrationPage.insertEmail("bumtv22682@minitts.net");
        registrationPage.insertTelephone("01553161044");
        registrationPage.insertPassword("1234");
        registrationPage.insertConfirmPassword("123");
        registrationPage.clickOnPrivacyPolicyBox();
        registrationPage.clickOnSubmitButton();
        String expectedResult = "Password confirmation does not match password";
        String actualResult = registrationPage.getEmptyPasswordConfirmErrorMessage();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

}
