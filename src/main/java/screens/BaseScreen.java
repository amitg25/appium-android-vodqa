package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.AppiumFactory;

import java.util.Properties;

public class BaseScreen {

    public static Properties property = null;
    public static AppiumDriver<MobileElement> driver = null;
    private static Logger logger = LogManager.getLogger(BaseScreen.class);

    public BaseScreen() {
    }

    public void setDriver() {
        driver = AppiumFactory.getDriver();
        logger.info("Drive set in BaseScreen");
    }

    public void launchApp() {
        driver.launchApp();
        logger.info("App launched");
    }

    public void closeApp() {
        driver.closeApp();
        logger.info("App closed");
    }
}