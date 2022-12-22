package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementsActions;

import java.util.ArrayList;
import java.util.HashMap;

public class CartPage {
    public By PRODUCT_NAME = By.xpath("//td[@class=\"cart_description\"]//h4/a");
    public By PRODUCT_PRICE = By.xpath("//td[@class=\"cart_price\"]/p");
    public By PRODUCT_QUANTITY = By.xpath("//td[@class=\"cart_quantity\"]/button");
    public By PRODUCT_TOTAL = By.xpath("//td[@class=\"cart_total\"]/p");
    public By FIRST_PRODUCT_NAME = By.xpath("(//td[@class=\"cart_description\"]//h4/a)[1]");
    public By SECOND_PRODUCT_NAME = By.xpath("(//td[@class=\"cart_description\"]//h4/a)[2]");
    public By FIRST_PRODUCT_PRICE = By.xpath("(//td[@class=\"cart_price\"]/p)[1]");
    public By SECOND_PRODUCT_PRICE = By.xpath("(//td[@class=\"cart_price\"]/p)[2]");
    public By FIRST_PRODUCT_TOTAL = By.xpath("(//td[@class=\"cart_total\"]/p)[1]");
    public By SECOND_PRODUCT_TOTAL = By.xpath("(//td[@class=\"cart_total\"]/p)[2]");
    public By FIRST_PRODUCT_QUANTITY = By.xpath("(//td[@class=\"cart_quantity\"]/button)[1]");
    public By SECOND_PRODUCT_QUANTITY = By.xpath("(//td[@class=\"cart_quantity\"]/button)[2]");
    public WebDriver driver;
    public ElementsActions elementsActions;
    public HashMap<String, int[]> productsInfo;
    public CartPage(WebDriver driver) {
        this.driver = driver;
        elementsActions = new ElementsActions(driver);
        productsInfo = new HashMap<>();
    }
    public ArrayList<String> getNamesOfProductsInTheCart() {
        return elementsActions.getElementsText(PRODUCT_NAME);
    }
//    public HashMap<String, int[]> getProductsInfo() {
//        for (int i = 0; i < elementsActions.getNumberOfElements(PRODUCT_NAME); i++) {
//            productsInfo.put(elementsActions.getElementsText(PRODUCT_NAME), )
//        }
    public int getFirstProductPrice() {
        return Integer.parseInt(elementsActions.getAnElementText(FIRST_PRODUCT_PRICE).replaceAll("[^0-9]", ""));
    }

    public int getSecondProductPrice() {
        return Integer.parseInt(elementsActions.getAnElementText(SECOND_PRODUCT_PRICE).replaceAll("[^0-9]", ""));
    }

    public int getFirstProductTotal() {
        return Integer.parseInt(elementsActions.getAnElementText(FIRST_PRODUCT_TOTAL).replaceAll("[^0-9]", ""));
    }

    public int getSecondProductTotal() {
        return Integer.parseInt(elementsActions.getAnElementText(SECOND_PRODUCT_TOTAL).replaceAll("[^0-9]", ""));
    }

    public int getFirstProductQuantity() {
        return Integer.parseInt(elementsActions.getAnElementText(FIRST_PRODUCT_QUANTITY));
    }

    public int getSecondProductQuantity() {
        return Integer.parseInt(elementsActions.getAnElementText(SECOND_PRODUCT_QUANTITY));
    }

}
