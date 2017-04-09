package screens;

import io.appium.java_client.TouchAction;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

public class VerticalSwipingScreen extends BaseScreen {

    private WebElement scrollViewArea() {
        return driver.findElementByAccessibilityId("listview");
    }

    public void swipeScrollView() {
        Dimension size = scrollViewArea().getSize();
        new TouchAction(driver).press(scrollViewArea(), size.width / 2, (size.height * 3) / 4).waitAction(2000).moveTo(size.width / 2, size.height / 4).release().perform();
    }
}
