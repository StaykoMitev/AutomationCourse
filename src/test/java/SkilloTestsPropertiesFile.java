import base.BaseTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.time.Duration;
import java.util.Date;
import java.util.function.Function;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SkilloTestsPropertiesFile extends BaseTest {

    @Test
    @DisplayName("Sign in with correct username")
    public void test_signInWithUserName() {
        skilloHeader.clickOnLoginButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".h4.mb-4")));
        loginPage.enterUsername("stayko1");
        loginPage.enterPassword(password);
        loginPage.clickOnSignInButton();
        wait.until(ExpectedConditions.urlToBe(url + "/posts/all"));
        assertTrue(skilloHeader.isLogOutButtonDisplayed(), "Sign out button not displayed.");
    }

    @Test
    @DisplayName("Sign in with correct email")
    public void test_signInWithEmail() {
        skilloHeader.clickOnLoginButton();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("defaultLoginFormUsername"))).sendKeys(email);

        loginPage.enterUsername(email);
        loginPage.enterUsername(password);
        loginPage.clickOnSignInButton();

        WebElement signOut = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'sign-out')]")));

        assertTrue(signOut.isDisplayed(), "Sign out button not displayed.");
    }

    @Test
    @DisplayName("Register new user")
    @Disabled
    public void test_registerNewUser() {
        //got to login page and wait for 1 second
        driver.findElement(By.id("nav-link-login")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Register')]"))).click();

        Date date = new Date();
        long random = date.getTime();

        //fill in registration form
        driver.findElement(By.cssSelector("input[formcontrolname='username']")).sendKeys("t" + random);
        driver.findElement(By.cssSelector("input[formcontrolname='email']")).sendKeys("t" + random + "@a.bg");
        driver.findElement(By.cssSelector("input[formcontrolname='birthDate']")).sendKeys("12.12.1990");
        driver.findElement(By.id("defaultRegisterFormPassword")).sendKeys("As123123");
        driver.findElement(By.id("defaultRegisterPhonePassword")).sendKeys("As123123");
        driver.findElement(By.cssSelector("textarea[formcontrolname='publicInfo']")).sendKeys("134651346");

        //submit form
        driver.findElement(By.id("sign-in-button")).click();

        WebElement signOut = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'sign-out')]")));

        assertTrue(signOut.isDisplayed(), "Sign out button not displayed.");
    }

    @Test
    @DisplayName("Register new user with taken user name")
    public void test_registerUserUsernameTaken() {
        //got to login page and wait for 1 second
        driver.findElement(By.id("nav-link-login")).click();

        //open registration form and wait for 1 second
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Register')]"))).click();

        //fill in registration form
        driver.findElement(By.cssSelector("input[formcontrolname='username']")).sendKeys("123123");
        driver.findElement(By.cssSelector("input[formcontrolname='email']")).sendKeys("123123@123.com");
        driver.findElement(By.cssSelector("input[formcontrolname='birthDate']")).sendKeys("12.12.1990");
        driver.findElement(By.id("defaultRegisterFormPassword")).sendKeys("As123123");
        driver.findElement(By.id("defaultRegisterPhonePassword")).sendKeys("As123123");
        driver.findElement(By.cssSelector("textarea[formcontrolname='publicInfo']")).sendKeys("134651346");

        //submit form
        driver.findElement(By.id("sign-in-button")).click();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(5))
            .pollingEvery(Duration.ofSeconds(1))
            .ignoring(NoSuchElementException.class);

        Function<WebDriver, WebElement> function  = new Function<WebDriver, WebElement>()
        {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//*[contains(@aria-label,'Username taken')]"));
            }
        };

        WebElement errorMessage = wait.until(function);
        assertTrue(errorMessage.isDisplayed());
    }

    @Test
    @DisplayName("Sign in and then sign out")
    public void test_signOut() {
        //got to login page and wait for 1 second
        driver.findElement(By.id("nav-link-login")).click();
        //Thread.sleep(1000);

        //fill in sign in page and wait for 1 second
        wait.until(ExpectedConditions.elementToBeClickable(By.id("defaultLoginFormUsername"))).sendKeys("stayko1@gmail.com");

        driver.findElement(By.id("defaultLoginFormPassword")).sendKeys("Stayko1");
        driver.findElement(By.id("sign-in-button")).click();

        //click on sign out button
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".fas.fa-sign-out-alt.fa-lg"))).click();

        //assert that user is on the correct page
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/users/login"));
        boolean isDisplayed = true;

        try {
            driver.findElement(By.cssSelector(".fas.fa-sign-out-alt.fa-lg")).isDisplayed();
        } catch (Exception e)
        {
            isDisplayed = false;
        }

        assertTrue(!isDisplayed, "Sign out button not displayed.");
    }

    @Test
    @DisplayName("Add new post from button in the header")
    public void test_addNewPost() throws InterruptedException {
        //Click on login button
        skilloHeader.clickOnLoginButton();

        //fill in sign in page and wait for 1 second
        Thread.sleep(2000);
        loginPage.enterUsername("stayko1@gmail.com");
        //wait.until(ExpectedConditions.elementToBeClickable(By.id("defaultLoginFormUsername"))).sendKeys("stayko1@gmail.com");

        loginPage.enterPassword("Stayko1");
        //driver.findElement(By.id("defaultLoginFormPassword")).sendKeys("Stayko1");
        loginPage.clickOnSignInButton();
        //driver.findElement(By.id("sign-in-button")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".fas.fa-sign-out-alt.fa-lg")));

        //click on new post button
        skilloHeader.clickOnNewPostButton();
        //driver.findElement(By.id("nav-link-new-post")).click();
        Thread.sleep(2000);
        newPostPage.addPhotoToThePost("src/main/resources/trout.png");


        //add post description and click on create post
        newPostPage.enterPostDescription("Amazing fish!");

        newPostPage.clickOnCreatePostButton();

        //open post from profile page
        Thread.sleep(2000);
        driver.findElement(By.className("post-img")).click();
        //Thread.sleep(1000);

        //assert that post with same description is present on profile page
        Thread.sleep(2000);
        if (driver.findElement(By.cssSelector("div[class=post-title]")).getText().equals("Amazing fish!")){
            System.out.println("Test failed. Post was created successfully");
        }
        Thread.sleep(5000);
    }

    @Test
    @DisplayName("Delete just created post")
    public void test_addNewPostAndThenDeleteIt() {
        //open login form
        driver.findElement(By.id("nav-link-login")).click();
        //Thread.sleep(1000);

        //sign in and wait for a second
        driver.findElement(By.id("defaultLoginFormUsername")).sendKeys("stayko1");
        driver.findElement(By.id("defaultLoginFormPassword")).sendKeys("Stayko1");
        driver.findElement(By.id("sign-in-button")).click();
        //Thread.sleep(1000);

        //open posts creation form
        driver.findElement(By.id("nav-link-new-post")).click();
        //Thread.sleep(1000);

        File file = new File("src/main/resources/trout.png");
        String absolutePath = file.getAbsolutePath();

        //upload file
        driver.findElement(By.xpath("/html/body/app-root/div[2]/app-create-post/div/div/div/form/div[2]/input"))
              .sendKeys(absolutePath);
        //Thread.sleep(1000);

        //add description to the post
        driver.findElement(By.xpath("/html/body/app-root/div[2]/app-create-post/div/div/div/form/div[2]/div[3]/input"))
              .sendKeys("Amazing fish!");

        //create post
        driver.findElement(By.id("create-post")).click();
//        Thread.sleep(3000);

        //open post from profile page
        driver.findElement(By.className("post-img")).click();
        //Thread.sleep(1000);

        //click on delete button for a post
        driver.findElement(By.className("delete-ask")).click();
        //Thread.sleep(1000);

        //click on yes button
        driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm")).click();
//        Thread.sleep(3000);
    }

    public void test_likePost(){

    }

    @Test
    @DisplayName("Find existing user from search bar in the header")
    public void test_findSpecificUser() {
        //open login form
        driver.findElement(By.id("nav-link-login")).click();
        //Thread.sleep(1000);

        //sign in
        driver.findElement(By.id("defaultLoginFormUsername")).sendKeys("stayko1");
        driver.findElement(By.id("defaultLoginFormPassword")).sendKeys("Stayko1");
        driver.findElement(By.id("sign-in-button")).click();
        //Thread.sleep(1000);

        //add search criteria in search bar
        driver.findElement(By.id("search-bar")).sendKeys("stayko");
        ////*[@id="navbarColor01"]/form/div/app-search-dropdown/div/div[1]/app-small-user-profile/div/div[1]/a
    }
}