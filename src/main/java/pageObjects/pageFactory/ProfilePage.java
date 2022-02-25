package pageObjects.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProfilePage {

    WebDriver driver;

    public ProfilePage(WebDriver driver){
        this.driver=driver;
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    @FindBy()
    private WebElement editProfileButton;

    @FindBy()
    private WebElement postsField;

    @FindBy()
    private WebElement followersField;

    @FindBy()
    private WebElement followingField;

    @FindBy()
    private WebElement profileName;

    @FindBy()
    private WebElement allPostsButton;

    @FindBy()
    private WebElement publicPostsButton;

    @FindBy()
    private WebElement privatePostsButton;

    @FindBy()
    private WebElement newPostButton;

    @FindBy()
    private List<WebElement> posts;
}
