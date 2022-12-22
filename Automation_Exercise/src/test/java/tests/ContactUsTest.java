package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CartPage;
import pages.ContactUsPage;
import pages.HomePage;
import pages.ProductsPage;

public class ContactUsTest extends BaseTest{
    HomePage homePage;
    ProductsPage productsPage;
    CartPage cartPage;
    ContactUsPage contactUsPage;
    public String name = "mina";
    public String filePath = "C:\\Users\\GhalyM2\\Downloads\\birds.jpg";
    public String subject = "contact";
    public String email = "mina@home.com";
    public String message = "message";
    @BeforeClass
    public void navigateToProductsPage() {
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        contactUsPage = new ContactUsPage(driver);
        // navigate to contact us page
        homePage.clickOnContactUs();
    }
    @Test
    public void testContactUsFunctionality() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(contactUsPage.checkGetInTouchTitleIsDisplayed(), "get in touch title didn't appear");
        contactUsPage.enterName(name);
        contactUsPage.enterEmail(email);
        contactUsPage.enterSubject(subject);
        contactUsPage.enterMessage(message);
        contactUsPage.uploadFile(filePath);
        contactUsPage.clickOnSubmit();
        driver.switchTo().alert().accept();
        softAssert.assertTrue(contactUsPage.checkGetInTouchTitleIsDisplayed(), "get in touch title didn't appear");
        contactUsPage.clickOnHomeBtn();
        softAssert.assertTrue(driver.getCurrentUrl().equals(homePage.getTheUrl()), "incorrect url");
        softAssert.assertTrue(homePage.checkTheSiteLogoExist(), "logo didn't appear");
        softAssert.assertAll();
    }
}
