package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;

// readme
// search works according to category so the solution is only by counting the keyword in all categories
// then validate that number with the actual results appeared number
public class SearchTest extends BaseTest{
    HomePage homePage;
    ProductsPage productsPage;
    CartPage cartPage;
    public String productName = "blue top";
    @BeforeClass
    public void navigateToProductsPage() {
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        // navigate to products page
        homePage.clickOnProducts();
    }
    @Test
    public void testSearchFunctionality() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(productsPage.checkAllProductsHeaderIsDisplayed(), "all products title didn't appear");
        productsPage.getAllProductsNames();
        productsPage.enterSearchKeyWord(productName);
        productsPage.clickOnSearchIcon();
        softAssert.assertTrue(productsPage.checkSearchedProductsTitleDisplayed(), "searched products title didn't appear");
        softAssert.assertTrue(productsPage.checkIfAllSearchRelatedProductsAppeared(productName), "search related products didn't appear");
        softAssert.assertAll();
    }
}
