package base;

import Utils.PropertiesLoader;
import Utils.ScreenshotRule;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.RegisterExtension;
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
    void beforeEachTest() {
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

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        newPostPage = new NewPostPage(driver);
        profilePage = new ProfilePage(driver);
        skilloHeader = new SkilloHeader(driver);
        editProfileModal = new EditProfileModal(driver);
        driver.get(url);
    }

    @AfterEach
    void afterEachTest(TestInfo testInfo) {
        //quit driver
        driver.quit();
    }

    @RegisterExtension
    ScreenshotRule screenshotRule = new ScreenshotRule();
}
