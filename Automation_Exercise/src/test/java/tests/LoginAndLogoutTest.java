package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AccountCreated_ModifiedPage;
import pages.HomePage;
import pages.SignUpPage;
import pages.Signup_LoginPage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class LoginAndLogoutTest extends BaseTest{
    public HomePage homePage;
    public Signup_LoginPage signup_LoginPage;
    public SignUpPage signUpPage;
    public AccountCreated_ModifiedPage accountCreatedModifiedPage;
    public HomePage.SignedInUserHomePage signedInUserHomePage;
    public String email = "mmois2@homde.com";
    public String password = "P@ssw0rd";
    public String wrongEmail = "wrongbandjxhdcassn@homde.com";
    public String wrongPassword = "wrongP@ssw0rd";
    public String currentTime;

    @BeforeClass
    public void haveAPreRegisteredUser() {
        homePage = new HomePage(driver);
        currentTime = new SimpleDateFormat("ddMMyyyyHHmmssSSS").format(new Date());
        email = currentTime.toLowerCase() + email;
        signup_LoginPage = new Signup_LoginPage(driver);
        signUpPage = new SignUpPage(driver);
        accountCreatedModifiedPage = new AccountCreated_ModifiedPage(driver);
        signedInUserHomePage = new HomePage.SignedInUserHomePage(driver);
        // now we are going to have a registered user
        signUpData = new ArrayList<>();
        Collections.addAll(signUpData, RegistrationTest.name, password, RegistrationTest.day, RegistrationTest.month, RegistrationTest.year, RegistrationTest.name, RegistrationTest.lastname, RegistrationTest.company, RegistrationTest.address1, RegistrationTest.address2, RegistrationTest.country, RegistrationTest.state, RegistrationTest.city, RegistrationTest.zipcode,RegistrationTest.mobileNumber);
        //navigate to the site URL
        driver.get("https://automationexercise.com/");
        homePage.clickOnSignUp();
        signup_LoginPage.signUp(password, email);
        // sign up
        signUpPage.signUp(signUpData);
        accountCreatedModifiedPage.clickOnContinueBtn();
        signedInUserHomePage.logOut();
    }
    @AfterMethod
    public void navigateToLoginPage() {
        //navigate to login page
        driver.get("https://automationexercise.com/");
        homePage.clickOnSignUp();
    }
    @Test
    public void testSuccessfulLoginAndLogoutFunctionality() {
        signup_LoginPage.enterLogInEmail(email);
        signup_LoginPage.enterLogInPassword(password);
        signup_LoginPage.clickOnLogInBtn();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(signedInUserHomePage.checkIfLoggedInAsHeaderExists(), "logged in as [username] header didn't appear");
        signedInUserHomePage.logOut();
        softAssert.assertTrue(driver.getCurrentUrl().contains("/login"), "url is incorrect");
        softAssert.assertAll();

    }
    @Test
    public void testSuccessfulLoginAndThenDeletingTheAccount() {
        signup_LoginPage.enterLogInEmail(email);
        signup_LoginPage.enterLogInPassword(password);
        signup_LoginPage.clickOnLogInBtn();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(signedInUserHomePage.checkIfLoggedInAsHeaderExists(), "logged in as [username] didn't appear");
        signedInUserHomePage.deleteAccount();
        softAssert.assertTrue(accountCreatedModifiedPage.checkAccountDeletedMessageAppeared(), "account deleted message didn't appear");
        softAssert.assertAll();
    }
    @Test
    public void testUnsuccessfulLogin() {
        signup_LoginPage.enterLogInEmail(wrongEmail);
        signup_LoginPage.enterLogInPassword(wrongPassword);
        signup_LoginPage.clickOnLogInBtn();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(signup_LoginPage.checkIncorrectEmailOrPasswordMessageIsDisplayed(), "incorrect email or password message didn't appear");
        softAssert.assertAll();
    }
}
