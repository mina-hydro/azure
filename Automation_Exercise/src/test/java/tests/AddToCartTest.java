package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;

public class AddToCartTest extends BaseTest{
    HomePage homePage;
    ProductsPage productsPage;
    CartPage cartPage;
    @BeforeClass
    public void navigateToProductsPage() {
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        // navigate to products page
        homePage.clickOnProducts();
    }
    @Test
    public void testAddToCartFunctionality() {
        productsPage.hoverOverProduct(1);
        productsPage.clickOnAddToCart(1);
        productsPage.clickOnContinueShopping();
        productsPage.hoverOverProduct(2);
        productsPage.clickOnAddToCart(2);
        productsPage.clickOnViewCartAfterHovering();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(productsPage.getNamesOfProductsAddedToCart().equals(cartPage.getNamesOfProductsInTheCart()), "the added products and products already in the cart not the same");
        softAssert.assertEquals(productsPage.getFirstProductPrice(),cartPage.getFirstProductPrice(), "different price");
        softAssert.assertEquals(productsPage.getSecondProductPrice(), cartPage.getSecondProductPrice(), "different price");
        softAssert.assertEquals(productsPage.getFirstProductQuantity(),cartPage.getFirstProductQuantity(), "different quantity");
        softAssert.assertEquals(productsPage.getSecondProductQuantity(), cartPage.getSecondProductQuantity(), "different quantity");
        softAssert.assertEquals(productsPage.getFirstProductPrice() * productsPage.getFirstProductQuantity(),cartPage.getFirstProductTotal(), "the total is incorrect");
        softAssert.assertEquals(productsPage.getSecondProductPrice() * productsPage.getSecondProductQuantity(),cartPage.getSecondProductTotal(), "total is incorrect");
        softAssert.assertAll();
    }
}
