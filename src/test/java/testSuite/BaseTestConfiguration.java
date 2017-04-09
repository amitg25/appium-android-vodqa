package testSuite;

import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import screens.*;
import utils.AppiumFactory;
import utils.PropertyFactory;
import utils.ShellExecution;

import java.io.IOException;

public class BaseTestConfiguration {

    private static Logger logger = LogManager.getLogger(BaseTestConfiguration.class);
    public BaseScreen baseScreen;
    public LoginScreen loginScreen;
    public HomeScreen homeScreen;
    public SliderScreen sliderScreen;
    public VerticalSwipingScreen verticalSwipingScreen;
    public AppiumDriver baseTestDriver;

    public BaseTestConfiguration() {
        this.baseScreen = new BaseScreen();
        this.loginScreen = new LoginScreen();
        this.homeScreen = new HomeScreen();
        this.sliderScreen = new SliderScreen();
        this.verticalSwipingScreen = new VerticalSwipingScreen();
    }

    @BeforeSuite
    public void suiteSetup() {
        System.out.println("Before suite started");
        new PropertyFactory();
        baseScreen.setDriver();
        baseTestDriver = AppiumFactory.getDriver();
        logger.info("Suite setup completed");
    }

    @BeforeMethod
    public void testSetup() {
        System.out.println("Before test started");
        baseScreen.launchApp();
        logger.info("Test setup completed");
    }

    @AfterMethod
    public void testClosure() throws IOException {
        System.out.println("After test started");
        baseScreen.closeApp();
        ShellExecution.clearAppData();
        logger.info("Test closure completed");
    }

    @AfterSuite
    public void suiteClosure() {
        System.out.println("After suite started");
        AppiumFactory.quitDriver();
        logger.info("Suite closure completed");
    }
}
