package pageObjects.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver){
        //Pass driver initialized before each test to the page object
        this.driver=driver;
        //Initialise Elements Page Factory
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //Initialise Elements Page Factory with default wait time of 5 seconds
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="defaultLoginFormUsername")
    public WebElement userNameOrEmailField;

    @FindBy(id="defaultLoginFormPassword")
    private WebElement passwordField;

    @FindBy(css="rememberMe")
    private WebElement rememberMeCheckBox;

    @FindBy(id="sign-in-button")
    private WebElement signInButton;

    @FindBy(xpath = "//a[contains(text(),'Register')]")
    private WebElement registerLink;

    public void enterUsername(String username){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("defaultLoginFormUsername"))).sendKeys(username);
    }

    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickOnRememberMeCheckbox(){
        rememberMeCheckBox.click();
    }

    public void clickOnSignInButton(){
        signInButton.click();
    }

    public void clickOnRegisterLink(){
        registerLink.click();
    }
}
