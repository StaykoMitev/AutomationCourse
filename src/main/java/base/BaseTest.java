package base;

import Utils.PropertiesLoader;
import Utils.ScreenshotRule;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.extension.TestInstanceFactoryContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
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

        testReporter.publishEntry(testInfo.getDisplayName()+ " test - started");
    }

    @AfterEach
    void afterEachTest(TestInfo testInfo, TestReporter testReporter) {
        //quit driver
        driver.quit();
        testReporter.publishEntry(testInfo.getDisplayName()+ " test - finished");
    }

    @RegisterExtension
    ScreenshotRule screenshotRule = new ScreenshotRule();
}
