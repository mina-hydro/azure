package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ElementsActions {
    public WebDriver driver;
    public WebDriverWait wait;
    public ElementsActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
    }
    public void clickOn(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public void clickOn(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }
    public void type(By locator, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).clear();
        driver.findElement(locator).sendKeys(text);
    }
    public Boolean checkIfElementExist(By locator) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
        return driver.findElement(locator).isDisplayed();
    }
    public String getAnElementText(By locator) {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator))).getText();
    }
    public ArrayList<String> getElementsText(By locator) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
        List<WebElement> products = driver.findElements(locator);
        ArrayList<String> productsNames = new ArrayList<String>();
        for (WebElement s: products) {
            productsNames.add(s.getText());
        }
        return productsNames;
    }
    public String getAnElementText(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement)).getText();
    }
    public void selectElementByText(By locator, String text) {
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(text);
    }
    public int getNumberOfElements(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return driver.findElements(locator).size();
    }
    public void hoverOverElement(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).perform();
    }
    public void hoverOverElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(locator)).perform();
    }
}
