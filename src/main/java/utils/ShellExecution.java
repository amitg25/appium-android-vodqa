package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * Package name java.utils
 * Created by Bharathan on 18/01/17.
 * Project Name appium-android-calculator
 */
public class ShellExecution {
    private static Logger logger = LogManager.getLogger(ShellExecution.class);

    public static void clearAppData() {
        try {
            Runtime.getRuntime().exec("adb shell pm clear com.vodqareactnative");
            logger.info("VodQa App local data cleared");
        } catch (IOException e) {
            logger.error("Unable to clear App data");
            e.printStackTrace();
        }
    }
}
