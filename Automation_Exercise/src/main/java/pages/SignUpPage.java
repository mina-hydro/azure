package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementsActions;

import java.util.ArrayList;

public class SignUpPage {
    public By ENTER_YOUR_INFO_TITLE = By.xpath("(//section[@id=\"form\"]//h2[@class='title text-center']//b)[1]");
    public By GENDER_MALE = By.id("id_gender1");
    public By NAME = By.id("name");
    public By EMAIL = By.id("email");
    public By PASSWORD = By.id("password");
    public By DAYS = By.id("days");
    public By MONTHS = By.id("months");
    public By YEARS = By.id("years");
    public By SPECIAL_OFFER_CHECKBOX = By.id("optin");
    public By NEWSLETTER_CHECKBOX = By.id("newsletter");
    public By FIRST_NAME = By.id("first_name");
    public By LAST_NAME = By.id("last_name");
    public By COMPANY = By.id("company");
    public By ADDRESS1 = By.id("address1");
    public By ADDRESS2 = By.id("address2");
    public By COUNTRY = By.id("country");
    public By STATE = By.id("state");
    public By CITY = By.id("city");
    public By ZIPCODE = By.id("zipcode");
    public By MOBILE_NUMBER = By.id("mobile_number");
    public By CREATE_ACCOUNT_BTN = By.xpath("//button[@data-qa=\"create-account\"]");
    public WebDriver driver;
    public ElementsActions elementsActions;
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        elementsActions = new ElementsActions(driver);
    }
    public Boolean checkEnterAccountInfoTitleAppeared() {
        return elementsActions.getAnElementText(ENTER_YOUR_INFO_TITLE).toLowerCase().contains("enter account information");
    }
    public void clickOnGenderMale() {
        elementsActions.clickOn(GENDER_MALE);
    }
    public void enterName(String name) {
        elementsActions.type(NAME, name);
    }
    public void enterPassword(String password) {
        elementsActions.type(PASSWORD, password);
    }

    public void selectBirthDay(String birthDay) {
        elementsActions.selectElementByText(DAYS, birthDay);
    }

    public void selectBirthMonth(String birthMonth) {
        elementsActions.selectElementByText(MONTHS, birthMonth);
    }

    public void selectBirthYear(String birthYear) {
        elementsActions.selectElementByText(YEARS, birthYear);
    }
    public void clickOnNewsLetterCheckBox() {
        elementsActions.clickOn(NEWSLETTER_CHECKBOX);
    }
    public void clickOnSpecialOfferCheckBox() {
        elementsActions.clickOn(SPECIAL_OFFER_CHECKBOX);
    }
    public void enterFirstName(String firstname) {
        elementsActions.type(FIRST_NAME, firstname);
    }
    public void enterLastName(String lastname) {
        elementsActions.type(LAST_NAME, lastname);
    }
    public void enterCompany(String company) {
        elementsActions.type(COMPANY, company);
    }
    public void enterAddress1(String address1) {
        elementsActions.type(ADDRESS1, address1);
    }
    public void enterAddress2(String address2) {
        elementsActions.type(ADDRESS2, address2);
    }
    public void selectCountry(String country) {
        elementsActions.selectElementByText(COUNTRY, country);
    }
    public void enterCity(String city) {
        elementsActions.type(CITY, city);
    }
    public void enterState(String state) {
        elementsActions.type(STATE, state);
    }
    public void enterZipCode(String zipcode) {
        elementsActions.type(ZIPCODE, zipcode);
    }
    public void enterMobileNumber(String mobileNumber) {
        elementsActions.type(MOBILE_NUMBER, mobileNumber);
    }
    public void clickOnCreateAccountBtn() {
        elementsActions.clickOn(CREATE_ACCOUNT_BTN);
    }
    public void signUp(ArrayList<String> registrationData) {
        clickOnGenderMale();
        enterName(registrationData.get(0));
        enterPassword(registrationData.get(1));
        selectBirthDay(registrationData.get(2));
        selectBirthMonth(registrationData.get(3));
        selectBirthYear(registrationData.get(4));
        clickOnNewsLetterCheckBox();
        clickOnSpecialOfferCheckBox();
        enterFirstName(registrationData.get(5));
        enterLastName(registrationData.get(6));
        enterCompany(registrationData.get(7));
        enterAddress1(registrationData.get(8));
        enterAddress2(registrationData.get(9));
        selectCountry(registrationData.get(10));
        enterState(registrationData.get(11));
        enterCity(registrationData.get(12));
        enterZipCode(registrationData.get(13));
        enterMobileNumber(registrationData.get(14));
        clickOnCreateAccountBtn();
    }

}
