package Screens;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseScreen {
  protected static AndroidDriver<AndroidElement> driver;

  public BaseScreen(AndroidDriver<AndroidElement> driver) {
    this.driver = driver;
    // Initialize page elements using AppiumFieldDecorator
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
  }

  /**
   * Wait until the element is displayed on the screen
   *
   * @param element AndroidElement to wait for
   * @return WebElement once it's displayed
   */
  protected static WebElement waitUntilElementIsDisplayed(AndroidElement element) {
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.elementToBeClickable(element));
    return element;
  }

  /**
   * Check if the element is displayed on the screen
   *
   * @param element AndroidElement to check
   * @return Boolean indicating if the element is displayed
   */
  protected Boolean isElementDisplayed(AndroidElement element) {
    return waitUntilElementIsDisplayed(element).isDisplayed();
  }

  /**
   * Click on the given AndroidElement
   *
   * @param element AndroidElement to click on
   */
  protected void clickOnElement(AndroidElement element) {
    waitUntilElementIsDisplayed(element).click();
  }

  /**
   * Click on a menu option and return the corresponding screen
   *
   * @param option Menu option to click on
   * @return Object representing the screen related to the option
   * @throws NoClassDefFoundError if no class is defined for the option
   */
//  public Object clickOnMenuOption(String option) {
//    AndroidElement optionElement = driver.findElement(MobileBy.AccessibilityId(option));
//    clickOnElement(optionElement);
//
//    switch (option) {
//      case "Home":
//        return new HomeScreen(driver);
//      case "Webview":
//        return new WebviewScreen(driver);
//      case "Login":
//        return new LoginScreen(driver);
//      case "Forms":
//        return new FormsScreen(driver);
//      case "Swipe":
//        return new SwipeScreen(driver);
//      case "Drag":
//        return new DragScreen(driver);
//      default:
//        throw new NoClassDefFoundError("There's no class defined for: " + option);
//    }
//  }

  /**
   * Scroll until the specified text is visible on the screen
   *
   * @param visibleText Text to be scrolled to and made visible
   */
  protected String scrollUntilVisibleText(String visibleText) {
    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" + visibleText + "\").instance(0))");
    return visibleText;
  }

  /**
   * Set text in the given AndroidElement
   *
   * @param element AndroidElement to set text into
   * @param text    Text to set in the element
   */
  protected void setText(AndroidElement element, String text) {
    waitUntilElementIsDisplayed(element).sendKeys(text);
  }

  protected void swipeOrScroll(int startX, int startY, int endX, int endY){
    TouchAction touchAction = new TouchAction(driver);
    touchAction.longPress(new PointOption<>().withCoordinates(startX,startY)).moveTo(new PointOption<>().withCoordinates(endX,endY)).release().perform();
  }

  public void scrollDown(){
    Dimension size = driver.manage().window().getSize();

    int startX = size.getWidth()/2;
    int startY = size.getHeight()/2;

    int endX = startX;
    int endY = (int) (size.getHeight() * 0.4);

    swipeOrScroll(startX, startY, endX, endY);
  }
}