package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Package name PACKAGE_NAME
 * Created by Bharathan on 18/01/17.
 * Project Name appium-android-calculator
 */
public class PropertyFactory {
    private static Logger logger = LogManager.getLogger(PropertyFactory.class);
    private static Properties property = new Properties();

    public PropertyFactory() {
        loadProperty();
    }

    public static Properties getProperty() {
        return property;
    }

    public static void loadProperty() {
        FileInputStream propertyPath;
        try {
            propertyPath = new FileInputStream("src/test/resources/config.properties");
            property.load(propertyPath);
        } catch (FileNotFoundException e) {
            logger.error("Unable to find file in the path");
            logger.error("Unable to load the properties file");
            e.printStackTrace();
        } catch (IOException e) {
            logger.error("Unable to load the properties file");
            e.printStackTrace();
        }
    }
}
