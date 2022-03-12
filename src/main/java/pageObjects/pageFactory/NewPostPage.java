package pageObjects.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import java.io.File;

public class NewPostPage {

    WebDriver driver;
    WebDriverWait wait;

    public NewPostPage(WebDriver driver){
        //Pass driver initialized before each test to the page object
        this.driver=driver;
        //Initialise Elements Page Factory
        wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        //Initialise Elements Page Factory with default wait time of 5 seconds
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".fas.fa-times")
    private WebElement closePostButton;

    @FindBy(css="input[formcontrolname='caption']")
    private WebElement postDescription;

    @FindBy(xpath="")
    private WebElement privatePublicButton;

    @FindBy(id="create-post")
    private WebElement createPostButton;

    @FindBy(css="input[formcontrolname='coverUrl']")
    private WebElement fileInputField;

    public void clickOnClosePostButton(){
        closePostButton.click();
    }

    public void addPhotoToThePost(String path){
        File file = new File(path);
        String absolutePath = file.getAbsolutePath();
        fileInputField.sendKeys(absolutePath);
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

    public void createPosts(int numberOfPosts){
        for (int i = 0; i < numberOfPosts; i++) {
            driver.findElement(By.id("nav-link-new-post")).click();
            //upload photo
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector ("input[formcontrolname='coverUrl']")));
            addPhotoToThePost("src/main/resources/trout.png");
            //add caption
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[formcontrolname='caption']")));
            enterPostDescription("This is post number: "+i);
            //click create post
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("create-post")));
            clickOnCreatePostButton();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'post-img')]")));
            waitForCreatePostMessagePopUp();
        }
    }

    public void waitForCreatePostMessagePopUp(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@aria-label,'Post created!')]")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(@aria-label,'Post created!')]")));
    }
}
