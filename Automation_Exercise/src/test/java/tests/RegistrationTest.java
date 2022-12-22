package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistrationTest extends BaseTest{
    public HomePage homePage;
    public Signup_LoginPage signup_LoginPage;
    public SignUpPage signUpPage;
    public AccountCreated_ModifiedPage accountCreatedModifiedPage;
    public HomePage.SignedInUserHomePage signedInUserHomePage;
    //test data
    public static String name = "mina";
    public static String successfulSignUpEmail = "mois2@mina.com";
    public static String unsuccessfulSignUpEmail = "mina@home.com";
    public static String password = "P@ssw0rd";
    public static String lastname = "hydro";
    public static String company = "VOIS";
    public static String address1 = "Alex,VOIS";
    public static String address2 = "Egypt";
    public static String country = "Canada";
    public static String state = "State";
    public static String city = "city";
    public static String zipcode = "81223";
    public static String day = "30";
    public static String month = "December";
    public static String year = "1999";
    public static String mobileNumber = "012345678";
    public String currentTime;
    @BeforeClass
    public void navigateToSignUpPage() {
        homePage = new HomePage(driver);
        currentTime = new SimpleDateFormat("ddMMyyyyHHmmssSSS").format(new Date());
        successfulSignUpEmail = currentTime.toLowerCase() + successfulSignUpEmail;
        signup_LoginPage = new Signup_LoginPage(driver);
        signUpPage = new SignUpPage(driver);
        accountCreatedModifiedPage = new AccountCreated_ModifiedPage(driver);
        signedInUserHomePage = new HomePage.SignedInUserHomePage(driver);
        // go to sign up page
        homePage.clickOnSignUp();
    }
    @Test
    public void testSuccessfulSignUp() {
        SoftAssert softAssert = new SoftAssert();
        signup_LoginPage.enterSignUpUserName(name);
        signup_LoginPage.enterSignUpEmail(successfulSignUpEmail);
        signup_LoginPage.clickOnSignUpBtn();
        softAssert.assertTrue(signUpPage.checkEnterAccountInfoTitleAppeared(), "enter account info title didn't appear");
        signUpPage.clickOnGenderMale();
        signUpPage.enterName(name);
        signUpPage.enterPassword(password);
        signUpPage.selectBirthDay(day);
        signUpPage.selectBirthMonth(month);
        signUpPage.selectBirthYear(year);
        signUpPage.clickOnNewsLetterCheckBox();
        signUpPage.clickOnSpecialOfferCheckBox();
        signUpPage.enterFirstName(name);
        signUpPage.enterLastName(lastname);
        signUpPage.enterCompany(company);
        signUpPage.enterAddress1(address1);
        signUpPage.enterAddress2(address2);
        signUpPage.selectCountry(country);
        signUpPage.enterState(state);
        signUpPage.enterCity(city);
        signUpPage.enterZipCode(zipcode);
        signUpPage.enterMobileNumber(mobileNumber);
        signUpPage.clickOnCreateAccountBtn();
        softAssert.assertTrue(accountCreatedModifiedPage.checkAccountCreatedMessageAppeared(), "account created message didn't appear");
        accountCreatedModifiedPage.clickOnContinueBtn();
        softAssert.assertTrue(signedInUserHomePage.checkIfLoggedInAsHeaderExists(), "logged in as [username] header didn't appear");
        signedInUserHomePage.deleteAccount();
        softAssert.assertTrue(accountCreatedModifiedPage.checkAccountDeletedMessageAppeared(), "account deleted message didn't appear");
        accountCreatedModifiedPage.clickOnContinueBtn();
        softAssert.assertAll();
    }
    @Test
    public void testRegistration() {
        signup_LoginPage.enterSignUpUserName(name);
        signup_LoginPage.enterSignUpEmail(unsuccessfulSignUpEmail);
        signup_LoginPage.clickOnSignUpBtn();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(signup_LoginPage.checkEmailAlreadyExistMessageIsDisplayed(), "email already exist message didn't appear");
        softAssert.assertAll();
    }

}
