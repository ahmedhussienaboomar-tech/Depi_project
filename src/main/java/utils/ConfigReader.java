package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try {
            properties = new Properties();
            // Try loading from src/test/resources/config.properties
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            System.err.println("WARNING: Could not find or read config.properties. Using default fallback properties.");
            // Set defaults if config.properties is missing
            properties = new Properties();
            properties.setProperty("baseUrl", "http://localhost/opencart/");
            properties.setProperty("browser", "chrome");
            properties.setProperty("implicit.wait", "10");
        }
    }

    /**
     * Returns the value of the property for the given key.
     * System property overrides file property if set.
     */
    public static String getProperty(String key) {
        String systemProp = System.getProperty(key);
        if (systemProp != null && !systemProp.trim().isEmpty()) {
            return systemProp;
        }
        return properties.getProperty(key);
    }
}
