package Utils;

import Screens.*;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GenericUtils {

  AndroidDriver driver;

  public GenericUtils(AndroidDriver<AndroidElement> driver) {
    this.driver = driver;
  }

  /**
   * Click on a menu option and return the corresponding screen
   *
   * @param option Menu option to click on
   * @return Object representing the screen related to the option
   * @throws NoClassDefFoundError if no class is defined for the option
   */
  public  Object clickOnMenuOption(String option) {
    AndroidElement optionElement = (AndroidElement) driver.findElement(MobileBy.AccessibilityId(option));
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

  protected void clickOnElement(AndroidElement element) {
    waitUntilElementIsDisplayed(element).click();
  }

  protected  AndroidElement waitUntilElementIsDisplayed(AndroidElement element) {
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.elementToBeClickable(element));
    return element;
  }

}
