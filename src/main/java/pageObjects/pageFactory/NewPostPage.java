package pageObjects.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewPostPage {

    WebDriver driver;
    WebDriverWait wait;

    public NewPostPage(WebDriver driver){
        //Pass driver initialized before each test to the page object
        this.driver=driver;
        //Initialise Elements Page Factory
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //Initialise Elements Page Factory with default wait time of 5 seconds
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
    }

    @FindBy(css=".fas.fa-times")
    private WebElement closePostButton;

    @FindBy(xpath="input[formcontrolname='caption']")
    private WebElement postDescription;

    @FindBy(xpath="")
    private WebElement privatePublicButton;

    @FindBy(id="create-post")
    private WebElement createPostButton;

    @FindBy(xpath="/html/body/app-root/div[2]/app-create-post/div/div/div/form/div[2]/input")
    private WebElement fileInputField;

    public void clickOnClosePostButton(){
        closePostButton.click();
    }

    public void addPhotoToThePost(String photoName){
        fileInputField.sendKeys(photoName);
    }

    public void enterPostDescription(String description){
        postDescription.sendKeys(description);
    }

    public void clickOnPrivatePublicButton(){
        privatePublicButton.click();
    }

    public void clickOnCreatePostButton(){
        createPostButton.click();
    }

}
