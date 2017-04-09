package screens;

import org.openqa.selenium.WebElement;

public class HomeScreen extends BaseScreen {

    private WebElement sliderBtn() {
        return driver.findElementByAccessibilityId("slider1");
    }

    private WebElement verticalSwippinBtn() {
        return driver.findElementByAccessibilityId("verticalSwipe");
    }

    public void clickSlider() {
        sliderBtn().click();
    }

    public void clickVerticalSwipe() {
        verticalSwippinBtn().click();
    }
}
