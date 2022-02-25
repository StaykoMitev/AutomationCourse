package pageObjects.classicPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private WebElement skilloIcon(){
        return driver.findElement(By.id("homeIcon"));
    }

    private WebElement homeButton(){
        return driver.findElement(By.id("nav-link-home"));
    }

    private WebElement profileButton(){
        return driver.findElement(By.id("nav-link-profile"));
    }

    private WebElement newPostButton(){
        return driver.findElement(By.id("nav-link-new-post"));
    }

    private WebElement searchBar(){
        return driver.findElement(By.id("search-bar"));
    }

    private WebElement loginButton(){
        return driver.findElement(By.id("nav-link-login"));
    }

    private WebElement logOutButton(){
        return driver.findElement(By.cssSelector(".fas.fa-sign-out-alt.fa-lgr"));
    }

    private List<WebElement> getPosts(){
        return driver.findElements(By.cssSelector("div.post-feed-container"));
    }

    public void clickOnSkilloIcon(){
        skilloIcon().click();
    }

    public void clickOnHomeButton(){
        homeButton().click();
    }

    public void clickOnLoginButton(){
        loginButton().click();
    }

    public void clickOnProfileButton(){
        profileButton().click();
    }

    public void clickOnNewPostButton(){
        newPostButton().click();
    }

    public void clickOnSignOutButton(){
        logOutButton().click();
    }

    public WebElement getPostByIndex(int index){
        return getPosts().get(index);
    }

    public String getPostUser(int index){
        return getPostByIndex(index).findElement(By.className("post-user")).getText();
    }

    public boolean isLogOutButtonDisplayed(){
        return logOutButton().isDisplayed();
    }

}
