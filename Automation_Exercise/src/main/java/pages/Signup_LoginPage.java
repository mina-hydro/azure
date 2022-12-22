package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementsActions;

public class Signup_LoginPage {
    public By SIGN_UP_USER_NAME = By.xpath("//input[@data-qa=\"signup-name\"]");
    public By SIGN_UO_EMAIL = By.xpath("//input[@data-qa=\"signup-email\"]");
    public By SIGN_UP_BTN = By.xpath("//button[@data-qa=\"signup-button\"]");
    public By LOG_IN_EMAIL = By.name("email");
    public By LOG_IN_PASSWORD = By.name("password");
    public By LOG_IN_BTN = By.xpath("//button[@data-qa=\"login-button\"]");
    public By INCORRECT_LOGIN_MESSAGE = By.xpath("//section[@id=\"form\"]//form/p[contains(text(),\"is incorrect\")]");
    public By ALREADY_REGISTERED_USER_MESSAGE = By.xpath("//section[@id=\"form\"]//p[contains(text(), \"already exist\")]");
    public WebDriver driver;
    ElementsActions elementsActions;
    public Signup_LoginPage(WebDriver driver) {
        this.driver = driver;
        elementsActions = new ElementsActions(driver);
    }
    public void enterSignUpUserName(String username) {
        elementsActions.type(SIGN_UP_USER_NAME, username);
    }
    public void enterSignUpEmail(String email) {
        elementsActions.type(SIGN_UO_EMAIL, email);
    }
    public void clickOnSignUpBtn() {
        elementsActions.clickOn(SIGN_UP_BTN);
    }
    public void signUp(String username, String email) {
        enterSignUpUserName(username);
        enterSignUpEmail(email);
        clickOnSignUpBtn();
    }
    public void enterLogInEmail(String email) {
        elementsActions.type(LOG_IN_EMAIL, email);
    }
    public void enterLogInPassword(String password) {
        elementsActions.type(LOG_IN_PASSWORD, password);
    }
    public void clickOnLogInBtn() {
        elementsActions.clickOn(LOG_IN_BTN);
    }
    public Boolean checkIncorrectEmailOrPasswordMessageIsDisplayed() {
        return elementsActions.getAnElementText(INCORRECT_LOGIN_MESSAGE).toLowerCase().contains("email or password is incorrect");
    }
    public Boolean checkEmailAlreadyExistMessageIsDisplayed() {
        return elementsActions.getAnElementText(ALREADY_REGISTERED_USER_MESSAGE).toLowerCase().contains("email address already exist");
    }

}
