package pageObjects.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        //Initialise Elements
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
        userNameOrEmailField.sendKeys(username);
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
