package screens;

import io.appium.java_client.TouchAction;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

/**
 * Package name PACKAGE_NAME
 * Created by Bharathan on 18/01/17.
 * Project Name appium-android-calculator
 */
public class SliderScreen extends BaseScreen {

  private WebElement slider() {
    return driver.findElementByAccessibilityId("slider");
  }

  public void slideHalf() {
    Dimension size = slider().getSize();
    new TouchAction(driver).press(slider(), 0, size.height / 2).waitAction(2000).moveTo(size.width / 2, size.height / 2).release().perform();
  }
}
