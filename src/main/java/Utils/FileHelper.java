package Utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileHelper implements TestWatcher {

    public static void cleanUpDirectory() throws IOException {
        Path path = Path.of("screenshots");
        FileUtils.cleanDirectory(path.toFile());
    }

    public static void takeScreenShot(WebDriver driver, String path, String fileName) {
        if (driver != null) {
            try {
                new File(path).mkdirs();
                try (FileOutputStream out = new FileOutputStream(
                    path + File.separator + "screenshot-" + fileName + ".png")) {
                    out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
                }
            } catch (IOException | WebDriverException e) {
                System.out.println("screenshot failed:" + e.getMessage());
            }
        }
    }
}