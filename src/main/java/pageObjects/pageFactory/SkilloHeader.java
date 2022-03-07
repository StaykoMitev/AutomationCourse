package pageObjects.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SkilloHeader {

    WebDriver driver;
    WebDriverWait wait;

    public SkilloHeader(WebDriver driver){
        this.driver=driver;
        //Initialise Elements
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="homeIcon")
    private WebElement skilloIcon;

    @FindBy(id="nav-link-home")
    private WebElement homeButton;

    @FindBy(id="nav-link-login")
    private WebElement loginButton;

    @FindBy(id="nav-link-profile")
    private WebElement profileButton;

    @FindBy(id="nav-link-new-post")
    private WebElement newPostButton;

    @FindBy(id="search-bar")
    private WebElement searchBar;

    @FindBy(css=".fas.fa-sign-out-alt.fa-lg")
    private WebElement logOutButton;

    public WebElement getLogOutButton() {
        return wait.until(ExpectedConditions.visibilityOf(logOutButton));
    }

    public void clickOnSkilloIcon(){
        skilloIcon.click();
    }

    public void clickOnHomeButton(){
        homeButton.click();
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }

    public void clickOnProfileButton(){
        profileButton.click();
    }

    public void clickOnNewPostButton(){
        newPostButton.click();
    }

    public void clickOnSignOutButton(){
        logOutButton.click();
    }


    public boolean isLogOutButtonDisplayed(){
        return wait.until(ExpectedConditions.visibilityOf(logOutButton)).isDisplayed();
    }
}
