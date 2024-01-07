package Screens;

import Screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DragScreen extends BaseScreen {

  @AndroidFindBy(xpath = "//android.widget.TextView[@text='Drag and Drop']")
  private AndroidElement titleText;

  @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Drag-drop-screen']/android.widget.ImageView")
  private AndroidElement dragGrid;

  @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Drag-drop-screen']/android.widget.ImageView")
  private AndroidElement dragElementsGroup;

  public DragScreen(AndroidDriver<AndroidElement> driver) {
    super(driver);
  }

  public String getTitleText() {
    waitUntilElementIsDisplayed(titleText);
    return titleText.getText();
  }

  public Boolean isDragGridDisplayed() {
    return isElementDisplayed(dragGrid);
  }

  public Boolean isDragElementsGroupDisplayed() {
    return isElementDisplayed(dragElementsGroup);
  }
}
