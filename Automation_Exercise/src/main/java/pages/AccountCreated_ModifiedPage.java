package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementsActions;

public class AccountCreated_ModifiedPage {
    public By ACCOUNT_CREATED_MESSAGE = By.xpath("//h2[@data-qa=\"account-created\"]");
    public By ACCOUNT_DELETED_MESSAGE = By.xpath("//section[@id=\"form\"]//h2[@class=\"title text-center\"]//b");
    public By CONTINUE_BTN = By.xpath("//a[@data-qa=\"continue-button\"]");
    public WebDriver driver;
    public ElementsActions elementsActions;
    public AccountCreated_ModifiedPage(WebDriver driver) {
        this.driver = driver;
        elementsActions = new ElementsActions(driver);
    }
    public void clickOnContinueBtn() {
        elementsActions.clickOn(CONTINUE_BTN);
    }
    public Boolean checkAccountDeletedMessageAppeared() {
        return elementsActions.getAnElementText(ACCOUNT_DELETED_MESSAGE).toLowerCase().contains("account deleted");
    }
    public Boolean checkAccountCreatedMessageAppeared() {
        return elementsActions.getAnElementText(ACCOUNT_CREATED_MESSAGE).toLowerCase().contains("account created");
    }
}
