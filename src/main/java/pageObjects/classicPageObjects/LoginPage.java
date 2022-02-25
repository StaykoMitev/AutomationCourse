package pageObjects.classicPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    //WebElements
    public WebElement userNameOrEmailField(){
        return driver.findElement(By.id("defaultLoginFormUsername"));
    }

    private WebElement passwordField(){
        return driver.findElement(By.id("defaultLoginFormPassword"));
    }

    private WebElement rememberMeCheckBox(){
        return driver.findElement(By.id("rememberMe"));
    }

    private WebElement signInButton(){
        return driver.findElement(By.id("sign-in-button"));
    }

    private WebElement registerLink(){
        return driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
    }

    //Action methods
    public void enterUsername(String username){
        userNameOrEmailField().sendKeys(username);
    }

    public void enterPassword(String password){
        passwordField().sendKeys(password);
    }

    public void clickOnRememberMeCheckbox(){
        rememberMeCheckBox().click();
    }

    public void clickOnSignInButton(){
        signInButton().click();
    }

    public void clickOnRegisterLink(){
        registerLink().click();
    }

    //BooleanMethods

}
