package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    public static Properties prop = null;

    public static void loadProperties(){
        String propertiesFileName = "config.properties";
        try (InputStream configInput = new FileInputStream("src/main/resources/config/" + propertiesFileName)) {
            prop = new Properties();
            // load a properties file
            prop.load(configInput);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
