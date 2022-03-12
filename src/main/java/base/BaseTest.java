package base;

import Utils.PropertiesLoader;
import Utils.ScreenshotRule;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.extension.TestInstanceFactoryContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.classicPageObjects.LoginPage;
import pageObjects.pageFactory.*;

import java.io.IOException;
import java.time.Duration;

import static Utils.FileHelper.cleanUpDirectory;

public class BaseTest {

    protected TestInfo testInfo;
    protected TestReporter testReporter;

    protected static WebDriver driver;
    protected WebDriverWait wait;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected NewPostPage newPostPage;
    protected ProfilePage profilePage;
    protected SkilloHeader skilloHeader;
    protected EditProfileModal editProfileModal;

    static protected String email = null;
    static protected String password = null;
    static protected String url = null;
    static protected String browser = null;

    @BeforeAll
    static void beforeClass() throws IOException {
        cleanUpDirectory();
        PropertiesLoader.loadProperties();
        url = PropertiesLoader.prop.getProperty("url");
        email = PropertiesLoader.prop.getProperty("email");
        password = PropertiesLoader.prop.getProperty("password");
        browser = PropertiesLoader.prop.getProperty("browser");
        //TODO - move driver handling into different class.
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
        }
        else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
        } else if (browser.equals("safari")) {
            WebDriverManager.safaridriver().setup();
        }
    }

    @BeforeEach
    void beforeEachTest(TestInfo testInfoInjected, TestReporter testReporterInjected) {
        //TODO - move driver handling into different class.
        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        }
        else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equals("safari")) {
            driver = new SafariDriver();
        }
        screenshotRule.setDriver(driver);
        driver.manage().window().maximize();
        testInfo = testInfoInjected;
        testReporter = testReporterInjected;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        newPostPage = new NewPostPage(driver);
        profilePage = new ProfilePage(driver);
        skilloHeader = new SkilloHeader(driver);
        editProfileModal = new EditProfileModal(driver);
        driver.get(url);

        // Add entry to the log that test has started
        testReporter.publishEntry(testInfo.getDisplayName()+ " test - started");
    }

    @AfterEach
    void afterEachTest(TestInfo testInfo, TestReporter testReporter) {
        // Quit driver after each test
        driver.quit();
        // Add entry to the log that test has finished
        testReporter.publishEntry(testInfo.getDisplayName()+ " test - finished");
    }

    //Login to skill with parameters
    public void loginToSkillo(String username, String password){
        skilloHeader.clickOnLoginButton();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("defaultLoginFormUsername")));
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnSignInButton();
        skilloHeader.isLogOutButtonDisplayed();
    }

    //Login to skillo with default user/pass
    public void loginToSkilloAsDefaultUser(){
        loginToSkillo("stayko1@gmail.com", "Stayko1");
    }

    @RegisterExtension
    ScreenshotRule screenshotRule = new ScreenshotRule();
}
