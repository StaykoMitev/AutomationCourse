package Utils;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static Utils.FileHelper.takeScreenShot;

public class ScreenshotRule implements TestWatcher {
    private File screenshotFile;
    static WebDriver driver;

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        takeScreenShot(driver, "screenshots", context.getDisplayName());
        driver.quit();
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        driver.quit();
    }

    public void setDriver(WebDriver driver){
        ScreenshotRule.driver = driver;
    }
}