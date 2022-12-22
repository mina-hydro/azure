package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ElementsActions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ProductsPage {
    public By ALL_PRODUCTS = By.xpath("//h2[contains(@class, \"title\")]");
    public By SEARCH_BAR = By.id("search_product");
    public By SEARCH_ICON = By.id("submit_search");
    public By SEARCH_RESULTS = By.className("productinfo");
    public By PRODUCTS = By.className("productinfo");
    public By PRODUCT_NAME = By.xpath("//div[contains(@class, \"productinfo\")]/p");
    public By ADD_TO_CART_BTN = By.xpath("//a[contains(@class, \"add-to-cart\")]");
    public By CONTINUE_SHOPPING_BTN = By.xpath("//button[contains(text(), \"Continue Shopping\")]");
    public By VIEW_CART = By.xpath("//div[@id=\"cartModal\"]//a[contains(@href,\"view_cart\")]");
    public By PRODUCT_PRICE = By.xpath("//div[contains(@class, \"productinfo\")]//h2");
    public By FIRST_PRODUCT_PRICE_LOCATOR = By.xpath("(//div[contains(@class, \"productinfo\")]//h2)[1]");
    public By SECOND_PRODUCT_PRICE_LOCATOR = By.xpath("(//div[contains(@class, \"productinfo\")]//h2)[2]");
    public By SEARCHED_PRODUCTS_TITLE = By.xpath("//h2[contains(@class,\"title\")]");
    public int FIRST_PRODUCT_QUANTITY = 0;
    public int SECOND_PRODUCT_QUANTITY = 0;
    public int FIRST_PRODUCT_PRICE;
    public int SECOND_PRODUCT_PRICE;
    ArrayList<String> namesOfProductsAddedToCart;
    HashMap<String, int[]> productsInfo;
    ArrayList<String> allProductsName;
    public WebDriver driver;
    public ElementsActions elementsActions;
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        elementsActions = new ElementsActions(driver);
        namesOfProductsAddedToCart = new ArrayList<>();
        productsInfo = new HashMap<>();
        allProductsName = new ArrayList<>();
    }
    public Boolean checkAllProductsHeaderIsDisplayed() {
        return elementsActions.getAnElementText(ALL_PRODUCTS).toLowerCase().contains("all products");
    }
    public void enterSearchKeyWord(String keyWord) {
        elementsActions.type(SEARCH_BAR, keyWord);
    }
    public void clickOnSearchIcon() {
        elementsActions.clickOn(SEARCH_ICON);
    }
    public Boolean checkSearchResultsAppeared() {
        return getSearchResultsNumber() > 0;
    }
    public void hoverOverProduct(int productNumber) {
        elementsActions.hoverOverElement(driver.findElements(PRODUCTS).get(productNumber - 1));
    }
//    public void clickOnAddToCart(int elementNumber){
//        elementsActions.clickOn(driver.findElements(ADD_TO_CART_BTN).get((elementNumber - 1) + elementNumber));
//        namesOfProductsAddedToCart.add(getProductName(elementNumber));
//        if(productsInfo.get(getProductName(elementNumber)) != null) {
//            productsInfo.put(getProductName(elementNumber), new int[] {getProductPrice(elementNumber), 1});
//        }else {
//            productsInfo.get(getProductName(elementNumber))[1] ++;
//        }
//    }
    public void clickOnAddToCart(int elementNumber){
        elementsActions.clickOn(driver.findElements(ADD_TO_CART_BTN).get((elementNumber - 1) + elementNumber));
        namesOfProductsAddedToCart.add(getProductName(elementNumber));
        if(elementNumber == 1) {
            FIRST_PRODUCT_QUANTITY++;
            FIRST_PRODUCT_PRICE = setFirstProductPrice();
        } else if (elementNumber == 2) {
            SECOND_PRODUCT_QUANTITY++;
            SECOND_PRODUCT_PRICE = setSecondProductPrice();
        }

    }
    public void clickOnContinueShopping(){
        elementsActions.clickOn(driver.findElement(CONTINUE_SHOPPING_BTN));
    }
    public void clickOnViewCartAfterHovering() {
        elementsActions.clickOn(VIEW_CART);
    }
    public String getProductName(int productNumber) {
        return elementsActions.getAnElementText(driver.findElements(PRODUCT_NAME).get(productNumber - 1));
    }
    public int getProductPrice(int productNumber) {
        WebElement element = driver.findElements(PRODUCT_PRICE).get(productNumber - 1);
        String productPriceWithCurrency = elementsActions.getAnElementText(element);
        System.out.println(Integer.parseInt(productPriceWithCurrency.replaceAll("[^0-9]", "")));
        return Integer.parseInt(productPriceWithCurrency.replaceAll("[^0-9]", ""));
    }
    public ArrayList<String> getNamesOfProductsAddedToCart() {
        Collections.sort(namesOfProductsAddedToCart);
        return namesOfProductsAddedToCart;
    }
    public Boolean checkSearchedProductsTitleDisplayed() {
        return elementsActions.getAnElementText(SEARCHED_PRODUCTS_TITLE).toLowerCase().contains("searched products");
    }
    public ArrayList<String> getAllProductsNames() {
        allProductsName =  elementsActions.getElementsText(PRODUCT_NAME);
        return allProductsName;
    }
    public Boolean checkIfAllSearchRelatedProductsAppeared(String searchedProductName) {
        int expectedNumberOfProducts = 0;
        for (int i = 0; i < allProductsName.size(); i++) {
            if (allProductsName.get(i).toLowerCase().contains(searchedProductName.toLowerCase())) expectedNumberOfProducts++;
        }
        int actualNumberOfProducts = getSearchResultsNumber();
        return expectedNumberOfProducts == actualNumberOfProducts;
    }
    public int getSearchResultsNumber() {
        return elementsActions.getNumberOfElements(SEARCH_RESULTS);
    }

    public int getFirstProductQuantity() {
        return FIRST_PRODUCT_QUANTITY;
    }

    public int getSecondProductQuantity() {
        return SECOND_PRODUCT_QUANTITY;
    }
    public int setFirstProductPrice() {
        return Integer.parseInt(elementsActions.getAnElementText(FIRST_PRODUCT_PRICE_LOCATOR).replaceAll("[^0-9]", ""));
    }
    public int setSecondProductPrice() {
        return Integer.parseInt(elementsActions.getAnElementText(SECOND_PRODUCT_PRICE_LOCATOR).replaceAll("[^0-9]", ""));
    }
    public int getFirstProductPrice() {
        return FIRST_PRODUCT_PRICE;
    }
    public int getSecondProductPrice() {
        return SECOND_PRODUCT_PRICE;
    }

}
