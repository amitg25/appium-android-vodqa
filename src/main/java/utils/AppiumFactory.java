package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

/**
 * Package name PACKAGE_NAME
 * Created by Bharathan on 18/01/17.
 * Project Name appium-android-calculator
 */
public class AppiumFactory {

    private static AppiumDriver<MobileElement> driver;
    private static Logger logger = LogManager.getLogger(AppiumFactory.class);
    private static Properties property = PropertyFactory.getProperty();

    public AppiumFactory() {
        configureDriver();
    }

    public static AppiumDriver getDriver() {
        if (driver == null) {
            new AppiumFactory();
        }
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
        driver = null;
        logger.error("Driver quit");
    }

    public void configureDriver() {
        DesiredCapabilities capabilities;
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, property.getProperty("DEVICE_NAME"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, property.getProperty("PLATFORM_NAME"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, property.getProperty("PLATFORM_VERSION"));
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, property.getProperty("AUTOMATION_NAME"));
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 700000);
        capabilities.setCapability(MobileCapabilityType.APP, property.getProperty("APP"));
        try {
            driver = new AndroidDriver<>(new URL(property.getProperty("NODE_URL")), capabilities);
            logger.info("Driver initialised");
        } catch (MalformedURLException e) {
            logger.error("Unable to Create Android driver");
            e.printStackTrace();
        }
    }
}
