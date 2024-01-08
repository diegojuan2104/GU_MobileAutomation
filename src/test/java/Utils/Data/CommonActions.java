package Utils.Data;

import Screens.*;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CommonActions extends BaseScreen{

  public CommonActions(AndroidDriver<AndroidElement> driver) {
    super(driver);
  }

  /**
   * Click on a menu option and return the corresponding screen
   *
   * @param option Menu option to click on
   * @return Object representing the screen related to the option
   * @throws NoClassDefFoundError if no class is defined for the option
   */
  public static Object clickOnMenuOption(String option) {
    AndroidElement optionElement = driver.findElement(MobileBy.AccessibilityId(option));
    clickOnElement(optionElement);

    switch (option) {
      case "Home":
        return new HomeScreen(driver);
      case "Webview":
        return new WebviewScreen(driver);
      case "Login":
        return new LoginScreen(driver);
      case "Forms":
        return new FormsScreen(driver);
      case "Swipe":
        return new SwipeScreen(driver);
      case "Drag":
        return new DragScreen(driver);
      default:
        throw new NoClassDefFoundError("There's no class defined for: " + option);
    }
  }

}
