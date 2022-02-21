import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.security.Timestamp;
import java.time.Duration;
import java.util.Date;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.*;

public class SkilloTests {

    static WebDriver driver;
    WebDriverWait wait;

    @BeforeAll
    static void beforeClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void beforeEachTest() {
        System.out.println("Test - "+Thread.currentThread().getStackTrace()[1].getMethodName()+" has started");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("http://training.skillo-bg.com:4300");
    }

    @Test
    public void test_signInWithUserName() throws InterruptedException {
        driver.findElement(By.id("nav-link-login")).click();
        //Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("defaultLoginFormUsername"))).sendKeys("stayko1");

//        driver.findElement(By.id("defaultLoginFormUsername")).sendKeys("stayko1");
        driver.findElement(By.id("defaultLoginFormPassword")).sendKeys("Stayko1");
        driver.findElement(By.id("sign-in-button")).click();
        //Thread.sleep(1000);

        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/posts/all"));

        assertTrue(driver.findElement(By.xpath("//*[contains(@class,'sign-out')]")).isDisplayed(), "Sign out button not displayed.");
    }

    @Test
    public void test_signInWithEmail() throws InterruptedException {
        driver.findElement(By.id("nav-link-login")).click();
        //Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("defaultLoginFormUsername"))).sendKeys("stayko1@gmail.com");

//        driver.findElement(By.id("defaultLoginFormUsername")).sendKeys("stayko1@gmail.com");
        driver.findElement(By.id("defaultLoginFormPassword")).sendKeys("Stayko1");
        driver.findElement(By.id("sign-in-button")).click();
        //Thread.sleep(1000);

        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/posts/all"));
        assertTrue(driver.findElement(By.xpath("//*[contains(@class,'sign-out')]")).isDisplayed(), "Sign out button not displayed.");
    }

    @Test
    public void test_registerNewUser() throws InterruptedException{
        //got to login page and wait for 1 second
        driver.findElement(By.id("nav-link-login")).click();
        //Thread.sleep(1000);

        //open registration form and wait for 1 second
//        driver.findElement(By.xpath("/html/body/app-root/div[2]/app-login/div/div/form/p[2]/a")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div[2]/app-login/div/div/form/p[2]/a"))).click();

        //Thread.sleep(1000);

        //fill in registration form
        driver.findElement(By.cssSelector("input[formcontrolname='username']")).sendKeys("T" + (new Date()).getTime());
        driver.findElement(By.cssSelector("input[formcontrolname='email']")).sendKeys("T" + (new Date()).getTime() + "@a.bg");
        driver.findElement(By.cssSelector("input[formcontrolname='birthDate']")).sendKeys("12.12.1990");
        driver.findElement(By.id("defaultRegisterFormPassword")).sendKeys("As123123");
        driver.findElement(By.id("defaultRegisterPhonePassword")).sendKeys("As123123");
        driver.findElement(By.cssSelector("textarea[formcontrolname='publicInfo']")).sendKeys("134651346");

        //submit form
        driver.findElement(By.id("sign-in-button")).click();

        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/posts/all"));
        assertTrue(driver.findElement(By.xpath("//*[contains(@class,'sign-out')]")).isDisplayed(), "Sign out button not displayed.");
    }

    @Test
    public void test_registerUserUsernameTaken() throws InterruptedException {
        //got to login page and wait for 1 second
        driver.findElement(By.id("nav-link-login"))
              .click();
        //Thread.sleep(1000);

        //open registration form and wait for 1 second
//        driver.findElement(By.xpath("/html/body/app-root/div[2]/app-login/div/div/form/p[2]/a")).click();
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("/html/body/app-root/div[2]/app-login/div/div/form/p[2]/a")))
            .click();

        //Thread.sleep(1000);

        //fill in registration form
        driver.findElement(By.cssSelector("input[formcontrolname='username']"))
              .sendKeys("123123");
        driver.findElement(By.cssSelector("input[formcontrolname='email']"))
              .sendKeys("123123@123.com");
        driver.findElement(By.cssSelector("input[formcontrolname='birthDate']"))
              .sendKeys("12.12.1990");
        driver.findElement(By.id("defaultRegisterFormPassword"))
              .sendKeys("As123123");
        driver.findElement(By.id("defaultRegisterPhonePassword"))
              .sendKeys("As123123");
        driver.findElement(By.cssSelector("textarea[formcontrolname='publicInfo']"))
              .sendKeys("134651346");

        //submit form
        driver.findElement(By.id("sign-in-button"))
              .click();

//        Thread.sleep(2000);
//        assertTrue(driver.findElement(By.xpath("//*[contains(@aria-label,'Username taken')]")).isDisplayed(), "Username taken message does not appear.");

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@aria-label,'Username taken')]")));

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofMillis(100))
            .ignoring(NoSuchElementException.class);

        Function<WebDriver, WebElement> function  = new Function<WebDriver, WebElement>()
        {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//*[contains(@aria-label,'Username takena')]"));
            }
        };

        WebElement errorMessage = wait.until(function);
        assertTrue(errorMessage.isDisplayed());



        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(@aria-label,'Username taken')]")));
    }

    @Test
    public void test_signOut() throws InterruptedException {
        //got to login page and wait for 1 second
        driver.findElement(By.id("nav-link-login")).click();
        //Thread.sleep(1000);

        //fill in sign in page and wait for 1 second
//        driver.findElement(By.id("defaultLoginFormUsername")).sendKeys("stayko1");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("defaultLoginFormUsername"))).sendKeys("stayko1@gmail.com");

        driver.findElement(By.id("defaultLoginFormPassword")).sendKeys("Stayko1");
        driver.findElement(By.id("sign-in-button")).click();
        //Thread.sleep(1000);

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".fas.fa-sign-out-alt.fa-lg"))).click();
        //click on sign out button
//        driver.findElement(By.cssSelector(".fas.fa-sign-out-alt.fa-lg")).click();

        //assert that user is on the correct page
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/users/login"));
        assertTrue(driver.findElement(By.id("defaultLoginFormUsername")).isDisplayed(), "Sign out button not displayed.");

//        if (!driver.getCurrentUrl().equals("")){
//            System.out.println("Test failed. User is not on the expected page");
//        } else System.out.println("Test passed successfully");
    }

    @Test
    public void test_addNewPost() throws InterruptedException {
        //click on login page and wait for 1 second
        driver.findElement(By.id("nav-link-login")).click();
        //Thread.sleep(1000);

        //fill in form and login
        driver.findElement(By.id("defaultLoginFormUsername")).sendKeys("stayko1");
        driver.findElement(By.id("defaultLoginFormPassword")).sendKeys("Stayko1");
        driver.findElement(By.id("sign-in-button")).click();
        //Thread.sleep(1000);

        //click on new post button
        driver.findElement(By.id("nav-link-new-post")).click();
        //Thread.sleep(1000);

        File file = new File("src/main/resources/trout.png");
        String absolutePath = file.getAbsolutePath();

        //upload file and wait
        driver.findElement(By.xpath("/html/body/app-root/div[2]/app-create-post/div/div/div/form/div[2]/input"))
              .sendKeys(absolutePath);
        //Thread.sleep(1000);

        //add post description and click on create post
        driver.findElement(By.xpath("/html/body/app-root/div[2]/app-create-post/div/div/div/form/div[2]/div[3]/input"))
              .sendKeys("Amazing fish!");
        driver.findElement(By.id("create-post")).click();
        Thread.sleep(3000);

        //open post from profile page
        driver.findElement(By.className("post-img")).click();
        //Thread.sleep(1000);

        //assert that post with same description is present on profile page
        if (driver.findElement(By.cssSelector("div[class=post-title]")).getText().equals("Amazing fish!")){
            System.out.println("Test failed. Post was created successfully");
        }
    }

    @Test
    public void test_addNewPostAndThenDeleteIt() throws InterruptedException {
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
        Thread.sleep(3000);

        //open post from profile page
        driver.findElement(By.className("post-img")).click();
        //Thread.sleep(1000);

        //click on delete button for a post
        driver.findElement(By.className("delete-ask")).click();
        //Thread.sleep(1000);

        //click on yes button
        driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm")).click();
        Thread.sleep(3000);
    }

    public void test_likePost(){

    }

    @Test
    public void test_findSpecificUser() throws InterruptedException {
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

    @AfterEach
    void afterEachTest() {
        //quit driver
        driver.quit();
    }
}