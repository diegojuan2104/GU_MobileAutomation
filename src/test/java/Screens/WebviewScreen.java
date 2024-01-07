package Screens;

import Screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WebviewScreen extends BaseScreen {

  @AndroidFindBy(className = "android.webkit.WebView")
  private AndroidElement webview;

  public WebviewScreen(AndroidDriver<AndroidElement> driver) {
    super(driver);
    this.driver = driver;
  }

  public boolean isWebViewDisplayed() {
    return isElementDisplayed(webview);
  }
}
