package pageObjects.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProfilePage {

    WebDriver driver;
    WebDriverWait wait;

    public ProfilePage(WebDriver driver){
        //Pass driver initialized before each test to the page object
        this.driver=driver;
        //Initialise Elements Page Factory
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        //Initialise Elements Page Factory with default wait time of 5 seconds
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".fas.fa-user-edit.ng-star-inserted")
    private WebElement editProfileButton;

    @FindBy(xpath="//li[text()=' posts']")
    private WebElement postsCounter;

    @FindBy(id="followers")
    private WebElement followersCounter;

    @FindBy(id="following")
    private WebElement followingCounter;

    @FindBy(xpath = "//div/div[1]/h2" )
    private WebElement profileName;

    @FindBy(className = "btn-all")
    private WebElement allPostsButton;

    @FindBy(className = "btn-public")
    private WebElement publicPostsButton;

    @FindBy(className = "btn-private")
    private WebElement privatePostsButton;

    @FindBy(xpath = "//div[text()='New post']")
    private WebElement newPostButton;

    @FindBy(xpath="//div[contains(@class, 'post-img')]")
    public List<WebElement> posts;

    @FindBy(xpath="//div[contains(@class, 'post-img')]")
    public WebElement post;

    @FindBy(css = ".fas.fa-sad-tear.fa-3x")
    private WebElement noPostsHereIcon;

    @FindBy(xpath = "//a[text()='Delete post']")
    private WebElement deleteButtonInPostModal;

    @FindBy(xpath = "//button[text()='Yes']")
    private WebElement yesButtonInPostModal;

    @FindBy(css = ".col-12.d-flex.justify-content-center.spinner-container")
    private WebElement spinner;

    @FindBy(xpath = "//h3[text()='No posts here']")
    private WebElement getNoPostsHereIcon;

    public boolean isNoPostsHereIconPresent(){
        return wait.until(ExpectedConditions.visibilityOf(getNoPostsHereIcon)).isDisplayed();
    }

    public void clickOnEditProfileButton(){
        editProfileButton.click();
    }

    public String getProfileName(){
        return profileName.getText();
    }

    public String getNumberOfPosts(){
        return postsCounter.getText();
    }

    public String getNumberOfFollowers(){
        return followersCounter.getText();
    }

    public String getNumberOfFollowing(){
        return followingCounter.getText();
    }

    public void clickOnAllPostsButton(){
        allPostsButton.click();
    }

    public void clickOnPublicPostsButton(){
        publicPostsButton.click();
    }

    public void clickOnPrivatePostsButton(){
        privatePostsButton.click();
    }

    public void clickOnNewPostButton(){
        newPostButton.click();
    }

    public WebElement getPostByIndex(int index){
        return posts.get(index);
    }

    //
    public void deletePost(WebElement postElement) {
        postElement.click();
        deleteButtonInPostModal.click();
        yesButtonInPostModal.click();
        waitForDeleteMessagePopUp();
    }

    //Waiting for delete post popup to appear and then to disappear
    public void waitForDeleteMessagePopUp(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@aria-label,'Post Deleted!')]")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(@aria-label,'Post Deleted!')]")));
    }

    //waiting for spinner to appear and then to disappear
    public void waitForSpinnerToShowAndDisappear(){
        wait.until(ExpectedConditions.visibilityOf(spinner));
        wait.until(ExpectedConditions.invisibilityOf(spinner));
    }

    //Scrolls to the bottom of the page and waits for spinner to disappear. It is repeated as long as spinner is present
    public void loadAllPosts() {
        scrollToTheBottomOfThePage();
        do {
            waitForSpinnerToShowAndDisappear();
            scrollToTheBottomOfThePage();
        }
        while(isLoaderPresent());
    }

    //Using javascript method scrolls to the bottom of the page
    public void scrollToTheBottomOfThePage(){
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    //Method is trying to find the spinner and catches the exception if it is not present.
    public boolean isLoaderPresent(){
        try {
            wait.until(ExpectedConditions.visibilityOf(spinner));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    //Method deletes first post. This is repeated N number of times. N is the number of posts
    public void deleteAllPosts() {
        int numberOfPosts = posts.size();
        for (int i = numberOfPosts-1; i >= 0; i--) {
            deletePost(post);
            System.out.println("------- DELETE post ----");
        }
    }
}
