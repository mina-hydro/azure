package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementsActions;

public class ContactUsPage {
    public By GET_IN_TOUCH_HEADER = By.xpath("//div[@class=\"contact-form\"]//h2[contains(@class, \"title\")]");
    public By NAME = By.name("name");
    public By EMAIL = By.name("email");
    public By SUBJECT = By.name("subject");
    public By MESSAGE = By.id("message");
    public By UPLOAD_FILE = By.name("upload_file");
    public By SUBMIT = By.name("submit");
    public By SUCCESS_MESSAGE = By.xpath("//div[@class=\"contact-form\"]//div[contains(@class,\"alert-success\")]");
    public By HOME_BTN = By.xpath("//a[contains(@class,\"btn-success\")]/span");
    public WebDriver driver;
    public ElementsActions elementsActions;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        elementsActions = new ElementsActions(driver);
    }
    public Boolean checkGetInTouchTitleIsDisplayed() {
        return elementsActions.getAnElementText(GET_IN_TOUCH_HEADER).toLowerCase().contains("get in touch");
    }
    public void enterName(String name) {
        elementsActions.type(NAME, name);
    }
    public void enterEmail(String email) {
        elementsActions.type(EMAIL, email);
    }
    public void enterSubject(String subject) {
        elementsActions.type(SUBJECT, subject);
    }
    public void clickOnSubmit() {
        elementsActions.clickOn(SUBMIT);
    }
    public void enterMessage(String message) {
        elementsActions.type(MESSAGE, message);
    }
    public void uploadFile(String filePath) {
        elementsActions.type(UPLOAD_FILE, filePath);
    }
    public void clickOnHomeBtn() {
        elementsActions.clickOn(HOME_BTN);
    }
}
