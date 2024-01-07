package Screens;

import Screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FormsScreen extends BaseScreen {
  @AndroidFindBy(xpath = "//android.widget.TextView[@text='Form components']")
  private AndroidElement titleText;

  @AndroidFindBy(accessibility = "text-input")
  private AndroidElement inputFieldTextInput;

  @AndroidFindBy(accessibility = "input-text-result")
  private AndroidElement youHaveTypedText;

  @AndroidFindBy(accessibility = "switch")
  private AndroidElement switchBtnInput;

  @AndroidFindBy(className = "android.widget.EditText")
  private AndroidElement dropDownInput;

  @AndroidFindBy(accessibility = "button-Inactive")
  private AndroidElement inactiveBtn;

  @AndroidFindBy(accessibility = "button-Active")
  private AndroidElement activeBtn;

  public FormsScreen(AndroidDriver<AndroidElement> driver) {
    super(driver);
  }

  public String getTitleText() {
    waitUntilElementIsDisplayed(titleText);
    return titleText.getText();
  }

  public Boolean isTextInputDisplayed() {
    return isElementDisplayed(inputFieldTextInput);
  }

  public Boolean isYouHaveTypedTextDisplayed() {
    return isElementDisplayed(youHaveTypedText);
  }

  public Boolean isDropDownInputDisplayed() {
    return isElementDisplayed(dropDownInput);
  }

  public Boolean isSwitchBtnInputDisplayed() {
    return isElementDisplayed(switchBtnInput);
  }

  public Boolean isInactiveBtnInputDisplayed() {
    scrollUntilVisibleText("Inactive");
    return isElementDisplayed(inactiveBtn);
  }

  public Boolean isActiveBtnInputDisplayed() {
    scrollUntilVisibleText("Active");
    return isElementDisplayed(activeBtn);
  }
}