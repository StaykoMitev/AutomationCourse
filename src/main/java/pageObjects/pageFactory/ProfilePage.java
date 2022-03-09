package pageObjects.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
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
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //Initialise Elements Page Factory with default wait time of 5 seconds
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
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
    private List<WebElement> posts;

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
}
