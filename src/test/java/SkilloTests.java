import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.pageFactory.HomePage;
import pageObjects.classicPageObjects.LoginPage;
import pageObjects.pageFactory.NewPostPage;
import pageObjects.pageFactory.ProfilePage;

import java.io.File;
import java.time.Duration;
import java.util.Date;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SkilloTests {

    static WebDriver driver;
    WebDriverWait wait;
    HomePage homePage;
    LoginPage loginPage;
    NewPostPage newPostPage;
    ProfilePage profilePage;

    @BeforeAll
    static void beforeClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void beforeEachTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        newPostPage = new NewPostPage(driver);
        profilePage = new ProfilePage(driver);
        driver.get("http://training.skillo-bg.com:4300");
    }

    @Test
    public void test_signInWithUserName() throws InterruptedException {
        homePage.clickOnLoginButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".h4.mb-4")));
        loginPage.enterUsername("stayko1");
        loginPage.enterPassword("Stayko1");
        loginPage.clickOnSignInButton();
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/posts/all"));
        assertTrue(homePage.isLogOutButtonDisplayed(), "Sign out button not displayed.");
    }

    @Test
    public void test_signInWithEmail() {
        driver.findElement(By.id("nav-link-login")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("defaultLoginFormUsername"))).sendKeys("stayko1@gmail.com");

        driver.findElement(By.id("defaultLoginFormUsername")).clear();
        driver.findElement(By.id("defaultLoginFormUsername")).sendKeys("stayko1@gmail.com");
        driver.findElement(By.id("defaultLoginFormPassword")).sendKeys("Stayko1");
        driver.findElement(By.id("sign-in-button")).click();

        WebElement signOut = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'sign-out')]")));

        assertTrue(signOut.isDisplayed(), "Sign out button not displayed.");
    }

    @Test
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
    public void test_registerUserUsernameTaken() throws InterruptedException {
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
    public void test_signOut() throws InterruptedException {
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
    public void test_addNewPost() throws InterruptedException {

        //got to login page and wait for 1 second
        driver.findElement(By.id("nav-link-login")).click();
        //Thread.sleep(1000);

        //fill in sign in page and wait for 1 second
        wait.until(ExpectedConditions.elementToBeClickable(By.id("defaultLoginFormUsername"))).sendKeys("stayko1@gmail.com");

        driver.findElement(By.id("defaultLoginFormPassword")).sendKeys("Stayko1");
        driver.findElement(By.id("sign-in-button")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".fas.fa-sign-out-alt.fa-lg")));

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