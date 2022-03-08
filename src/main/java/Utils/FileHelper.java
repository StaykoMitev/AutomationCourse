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
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileHelper implements TestWatcher {

    public static void cleanUpDirectory() throws IOException {
//        Path path = Path.of("screenshots");
//        FileUtils.cleanDirectory(path.toFile());
    }

    public static void takeScreenShot(WebDriver driver, String fileName) {
        if (driver != null) {
            try {
                try (FileOutputStream out = new FileOutputStream("screenshots" + File.separator + "screenshot-" + fileName + ".png")) {
                    out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
                }
            } catch (IOException | WebDriverException e) {
                System.out.println("screenshot failed:" + e.getMessage());
            }
        }
    }

    public static void createDirectory() throws IOException {
        new File("screenshots/new folder/asd").mkdirs();
    }

    public static void createFile() {
        try {
            File myObj = new File("screenshots/filename.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeToFile() {
        try {
            FileWriter myWriter = new FileWriter("screenshots/filename.txt");
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}