package screens;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;

/**
 * Package name PACKAGE_NAME
 * Created by Bharathan on 18/01/17.
 * Project Name appium-android-calculator
 */
public class LoginScreen extends BaseScreen {

  private WebElement userNameTxt() {
//    return driver.findElement(By.xpath("//android.widget.FrameLayout[1]//android.widget.EditText[1]"));
    return driver.findElement(MobileBy.AccessibilityId("username"));
  }

  private WebElement passwordTxt() {
//    return driver.findElement(By.xpath("//android.widget.FrameLayout[1]//android.widget.EditText[2]"));
    return driver.findElement(MobileBy.AccessibilityId("password"));

  }

  private WebElement submitBtn() {
//    return driver.findElement(By.xpath("//android.widget.FrameLayout[1]//android.widget.Button[1]"));
    return driver.findElement(MobileBy.AccessibilityId("login"));
  }

  public void setUserName(String userName) {
    userNameTxt().sendKeys(userName);
    driver.hideKeyboard();
  }

  public void setPassword(String password) {
    passwordTxt().sendKeys(password);
    driver.hideKeyboard();
  }

  public void clickSubmit() {
    submitBtn().click();
  }

  public void enterCredentials(String username, String password) {
    setUserName(username);
    setPassword(password);
    clickSubmit();
  }
}
