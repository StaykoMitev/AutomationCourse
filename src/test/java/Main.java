import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    static WebDriver driver;

//    public static void main(Str   ing[] args) throws InterruptedException {
//        //test_signInWithUserName();
//        //test_signInWithEmail();
//        //test_registerNewUser();
//        //test_signOut();
//        //test_addNewPost();
//
//    }

    @BeforeAll
    static void beforeClass(){
        System.out.println("Before Class");
        System.out.println("Test - "+Thread.currentThread().getStackTrace()[1].getMethodName()+" has started");
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void beforeEachTest() {
        System.out.println("Before Each Test");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://training.skillo-bg.com:4300");
    }

    @Test
    public void test_signInWithUserName() throws InterruptedException {
//        System.out.println("Test - " + Thread.currentThread().getStackTrace()[1].getMethodName() + " has started");
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//
//        driver.get("http://training.skillo-bg.com:4300");
        driver.findElement(By.id("nav-link-login")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("defaultLoginFormUsername")).sendKeys("stayko1");
        driver.findElement(By.id("defaultLoginFormPassword")).sendKeys("Stayko1");
        driver.findElement(By.id("sign-in-button")).click();
        Thread.sleep(1000);

        if (!driver.getCurrentUrl().equals("http://training.skillo-bg.com:4300/posts/all")){
            System.out.println("Test failed. User is not on the expected page");
        } else System.out.println("Test passed successfully");

//        driver.quit();
    }

    @Test
    public void test_signInWithEmail() throws InterruptedException {
//        System.out.println("Test - "+Thread.currentThread().getStackTrace()[1].getMethodName()+" has started");

//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//
//        driver.get("http://training.skillo-bg.com:4300");
        driver.findElement(By.id("nav-link-login")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("defaultLoginFormUsername")).sendKeys("stayko1@gmail.com");
        driver.findElement(By.id("defaultLoginFormPassword")).sendKeys("Stayko1");
        driver.findElement(By.id("sign-in-button")).click();
        Thread.sleep(1000);

        if (!driver.getCurrentUrl().equals("http://training.skillo-bg.com:4300/posts/all")){
            System.out.println("Test failed. User is not on the expected page");
        } else System.out.println("Test passed successfully");

//        driver.quit();
    }

    @Test
    public void test_registerNewUser() throws InterruptedException{
        //log that test has started
//        System.out.println("Test - "+Thread.currentThread().getStackTrace()[1].getMethodName()+" has started");

//        //setup driver
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//
//        //open page
//        driver.get("http://training.skillo-bg.com:4300");

        //got to login page and wait for 1 second
        driver.findElement(By.id("nav-link-login")).click();
        Thread.sleep(1000);

        //open registration form and wait for 1 second
        driver.findElement(By.xpath("/html/body/app-root/div[2]/app-login/div/div/form/p[2]/a")).click();
        Thread.sleep(1000);

        //fill in registration form
        driver.findElement(By.cssSelector("input[formcontrolname='username']")).sendKeys("123123");
        driver.findElement(By.cssSelector("input[formcontrolname='email']")).sendKeys("123123@123.com");
        driver.findElement(By.cssSelector("input[formcontrolname='birthDate']")).sendKeys("12.12.1990");
        driver.findElement(By.id("defaultRegisterFormPassword")).sendKeys("123123");
        driver.findElement(By.id("defaultRegisterPhonePassword")).sendKeys("123123");
        driver.findElement(By.cssSelector("textarea[formcontrolname='publicInfo']")).sendKeys("134651346");

        //submit form
        driver.findElement(By.id("sign-in-button")).click();

        //assert that user is on the correct page
        if (!driver.getCurrentUrl().equals("http://training.skillo-bg.com:4300/posts/all")){
            System.out.println("Test failed. User is not on the expected page");
        }

        //quit driver
//        driver.quit();
    }

    @Test
    public void test_signOut() throws InterruptedException {
        //log that test has started
//        System.out.println("Test - "+Thread.currentThread().getStackTrace()[1].getMethodName()+" has started");

//        //setup driver
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//
//        //open page
//        driver.get("http://training.skillo-bg.com:4300");

        //got to login page and wait for 1 second
        driver.findElement(By.id("nav-link-login")).click();
        Thread.sleep(1000);

        //fill in sign in page and wait for 1 second
        driver.findElement(By.id("defaultLoginFormUsername")).sendKeys("stayko1");
        driver.findElement(By.id("defaultLoginFormPassword")).sendKeys("Stayko1");
        driver.findElement(By.id("sign-in-button")).click();
        Thread.sleep(1000);

        //click on sign out button
        driver.findElement(By.cssSelector(".fas.fa-sign-out-alt.fa-lg")).click();

        //assert that user is on the correct page
        if (!driver.getCurrentUrl().equals("http://training.skillo-bg.com:4300/users/login")){
            System.out.println("Test failed. User is not on the expected page");
        } else System.out.println("Test passed successfully");

        //quit driver
//        driver.quit();
    }

    @Test
    @Disabled
    public void test_addNewPost() throws InterruptedException {
        //log that test has started
//        System.out.println("Test - "+Thread.currentThread().getStackTrace()[1].getMethodName()+" has started");

//        //driver setup
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//
//        //go to home page
//        driver.get("http://training.skillo-bg.com:4300");

        //click on login page and wait for 1 second
        driver.findElement(By.id("nav-link-login")).click();
        Thread.sleep(1000);

        //fill in form and login
        driver.findElement(By.id("defaultLoginFormUsername")).sendKeys("stayko1");
        driver.findElement(By.id("defaultLoginFormPassword")).sendKeys("Stayko1");
        driver.findElement(By.id("sign-in-button")).click();
        Thread.sleep(1000);

        //click on new post button
        driver.findElement(By.id("nav-link-new-post")).click();
        Thread.sleep(1000);

        //upload file and wait
        driver.findElement(By.xpath("/html/body/app-root/div[2]/app-create-post/div/div/div/form/div[2]/input"))
              .sendKeys("C:\\Users\\stayk\\IdeaProjects\\photo\\trout.png");
        Thread.sleep(1000);

        //add post description and click on create post
        driver.findElement(By.xpath("/html/body/app-root/div[2]/app-create-post/div/div/div/form/div[2]/div[3]/input"))
              .sendKeys("Amazing fish!");
        driver.findElement(By.id("create-post")).click();
        Thread.sleep(3000);

        //open post from profile page
        driver.findElement(By.className("post-img")).click();
        Thread.sleep(1000);

        //assert that post with same description is present on profile page
        if (driver.findElement(By.cssSelector("div[class=post-title]")).getText().equals("Amazing fish!")){
            System.out.println("Test failed. Post was created successfully");
        }

        //quit driver
//        driver.quit();
    }

    @Test
    @Disabled
    public void test_addNewPostAndThenDeleteIt() throws InterruptedException {
        //log that test has started
//        System.out.println("Test - "+Thread.currentThread().getStackTrace()[1].getMethodName()+" has started");

//        //driver setup
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//
//        //go to home page
//        driver.get("http://training.skillo-bg.com:4300");

        //open login form
        driver.findElement(By.id("nav-link-login")).click();
        Thread.sleep(1000);

        //sign in and wait for a second
        driver.findElement(By.id("defaultLoginFormUsername")).sendKeys("stayko1");
        driver.findElement(By.id("defaultLoginFormPassword")).sendKeys("Stayko1");
        driver.findElement(By.id("sign-in-button")).click();
        Thread.sleep(1000);

        //open posts creation form
        driver.findElement(By.id("nav-link-new-post")).click();
        Thread.sleep(1000);

        //upload file
        driver.findElement(By.xpath("/html/body/app-root/div[2]/app-create-post/div/div/div/form/div[2]/input"))
              .sendKeys("C:\\Users\\stayk\\IdeaProjects\\photo\\trout.png");
        Thread.sleep(1000);

        //add description to the post
        driver.findElement(By.xpath("/html/body/app-root/div[2]/app-create-post/div/div/div/form/div[2]/div[3]/input"))
              .sendKeys("Amazing fish!");

        //create post
        driver.findElement(By.id("create-post")).click();
        Thread.sleep(3000);

        //open post from profile page
        driver.findElement(By.className("post-img")).click();
        Thread.sleep(1000);

        //click on delete button for a post
        driver.findElement(By.className("delete-ask")).click();
        Thread.sleep(1000);

        //click on yes button
        driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm")).click();
        Thread.sleep(3000);

        //quit driver
//        driver.quit();
    }

    public void test_likePost(){

    }

    @Test
    public void test_findSpecificUser() throws InterruptedException {
        //log that test has started
//        System.out.println("Test - "+Thread.currentThread().getStackTrace()[1].getMethodName()+" has started");

//        //setup driver
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//
//        //open home page
//        driver.get("http://training.skillo-bg.com:4300");

        //open login form
        driver.findElement(By.id("nav-link-login")).click();
        Thread.sleep(1000);

        //sign in
        driver.findElement(By.id("defaultLoginFormUsername")).sendKeys("stayko1");
        driver.findElement(By.id("defaultLoginFormPassword")).sendKeys("Stayko1");
        driver.findElement(By.id("sign-in-button")).click();
        Thread.sleep(1000);

        //add search criteria in search bar
        driver.findElement(By.id("search-bar")).sendKeys("stayko");
        ////*[@id="navbarColor01"]/form/div/app-search-dropdown/div/div[1]/app-small-user-profile/div/div[1]/a

        //quit driver
//        driver.quit();
    }

    @AfterEach
    void afterEachTest() {
        //quit driver
        driver.quit();
    }
}