package pageObjects.classicPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewPostPage {

    WebDriver driver;

    public NewPostPage(WebDriver driver){
        this.driver=driver;
    }

    private final By closePostButton = By.cssSelector(".fas.fa-times");

    private final By postDescription = By.xpath("input[formcontrolname='caption']");

    private final By privatePublicButton = By.xpath("input[formcontrolname='caption']");

    private final By createPostButton = By.id("create-post");

    private final By fileInputField = By.xpath("/html/body/app-root/div[2]/app-create-post/div/div/div/form/div[2]/input");

    public void clickOnClosePostButton(){
        driver.findElement(closePostButton).click();
    }

    public void addPhotoToThePost(String photoName){
        driver.findElement(fileInputField).sendKeys(photoName);
    }

    public void enterPostDescription(String description){
        driver.findElement(postDescription).sendKeys(description);
    }

    public void clickOnPrivatePublicButton(){
        driver.findElement(privatePublicButton).click();
    }

    public void clickOnCreatePostButton(){
        driver.findElement(createPostButton).click();
    }
}
