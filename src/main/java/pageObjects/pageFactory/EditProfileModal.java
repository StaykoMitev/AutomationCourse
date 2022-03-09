package pageObjects.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditProfileModal {

    private WebDriver driver;
    private WebDriverWait wait;

    public EditProfileModal(WebDriver driver){
        //Pass driver initialized before each test to the page object
        this.driver=driver;
        //Initialise Elements Page Factory
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //Initialise Elements Page Factory with default wait time of 5 seconds
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
    }

    @FindBy(tagName="h4")
    private WebElement modalWindowHeading;

    @FindBy(css="input[formcontrolname='username']")
    private WebElement usernameInputField;

    @FindBy(css="input[formcontrolname='email']")
    private WebElement emailInputField;

    @FindBy(css="input[formcontrolname='password']")
    private WebElement passwordInputField;

    @FindBy(css="input[formcontrolname='confirmPassword']")
    private WebElement confirmPasswordInputField;

    @FindBy(css="input[formcontrolname='publicInfo']")
    private WebElement publicInfoInputField;

    @FindBy(css="button[type='submit']")
    private WebElement saveButton;

    public String getModalWindowHeading(){
        return modalWindowHeading.getText();
    }

    public void enterUsername(String username){
        usernameInputField.sendKeys(username);
    }

    public void enterEmail(String email){
        emailInputField.sendKeys(email);
    }

    public void enterPassword(String password){
        passwordInputField.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassoword){
        confirmPasswordInputField.sendKeys(confirmPassoword);
    }

    public void enterPublicInfo(String publicInfo){
        publicInfoInputField.sendKeys(publicInfo);
    }

    public void clickOnSaveButton(){
        saveButton.click();
    }
}
