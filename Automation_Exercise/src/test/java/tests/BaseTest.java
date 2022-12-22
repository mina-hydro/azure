package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import pages.SignUpPage;
import pages.Signup_LoginPage;

import java.util.ArrayList;
import java.util.Collections;

public class BaseTest {
    public WebDriver driver;
    public ArrayList<String> signUpData;


    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com");
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
