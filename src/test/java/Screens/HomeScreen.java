package Screens;

import Screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomeScreen extends BaseScreen {

  @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"WEBDRIVER\"]\n")
  private AndroidElement titleTxt;
  @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"Home-screen\"]/android.view.ViewGroup/android.widget.ImageView[1]")
  private AndroidElement robotImg;
  @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Demo app for the appium-boilerplate\"]")
  private AndroidElement subtitleText;
  @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"\uDB80\uDC35\"]\n")
  private AndroidElement macImg;
  @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"\uDB80\uDC32\"]\n")
  private AndroidElement androidImg;

  @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Support\"]")
  private AndroidElement supportText;

  public HomeScreen(AndroidDriver<AndroidElement> driver) {
    super(driver);
  }

  public String getTitleText() {
    waitUntilElementIsDisplayed(titleTxt);
    return titleTxt.getText();
  }

  public Boolean isRobotImageDisplayed() {
    return isElementDisplayed(robotImg);
  }

  public String getSubtitleText() {
    return waitUntilElementIsDisplayed(subtitleText).getText();
  }

  public Boolean isMacImgDisplayed() {
    return isElementDisplayed(macImg);
  }

  public Boolean isAndroidImgDisplayed() {
    return isElementDisplayed(androidImg);
  }

  public String getSupportText() {
    scrollUntilVisibleText("Support");
    return waitUntilElementIsDisplayed(supportText).getText();
  }
}
