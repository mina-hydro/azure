package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementsActions;

public class HomePage {
    public By SIGN_UP = By.xpath("//header[@id=\"header\"]//li//a[contains(text(),'ignup')]");
    public By PRODUCTS = By.xpath("//header[@id=\"header\"]//li/a[contains(@href,\"products\")]");
    public By CONTACT_US = By.xpath("//header[@id=\"header\"]//li/a[contains(@href, \"/contact_us\")]");
    public By LOGO = By.xpath("//header[@id=\"header\"]//a/img");
    public String URL = "https://automationexercise.com/";
    public WebDriver driver;
    public ElementsActions elementsActions;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        elementsActions = new ElementsActions(driver);
    }
    public Boolean checkTheSiteLogoExist() {
        return elementsActions.checkIfElementExist(LOGO);
    }
    public String getTheUrl() {
        return URL;
    }
    public void clickOnContactUs() {
        elementsActions.clickOn(CONTACT_US);
    }
    public void clickOnSignUp() {
        elementsActions.clickOn(SIGN_UP);
    }
    public void clickOnProducts() {
        elementsActions.clickOn(PRODUCTS);
    }
    public static class SignedInUserHomePage {
        public By LOGGED_IN_AS_HEADER = By.xpath("(//header[@id=\"header\"]//li/a)[last()]");
        public By DELETE_ACCOUNT = By.xpath("//header[@id=\"header\"]//li/a[@href=\"/delete_account\"]");
        public By LOGOUT = By.xpath("//header[@id=\"header\"]//li/a[@href=\"/logout\"]");
        public WebDriver driver;
        public ElementsActions elementsActions;
        public SignedInUserHomePage(WebDriver driver) {
            this.driver = driver;
            elementsActions = new ElementsActions(driver);
        }
        public Boolean checkIfLoggedInAsHeaderExists() {
            return elementsActions.getAnElementText(LOGGED_IN_AS_HEADER).toLowerCase().contains("logged in as");
        }
        public void deleteAccount() {
            elementsActions.clickOn(DELETE_ACCOUNT);
        }
        public void logOut() {
            elementsActions.clickOn(LOGOUT);
        }

    }
}
