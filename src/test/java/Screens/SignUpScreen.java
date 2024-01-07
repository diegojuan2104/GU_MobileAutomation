package Screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SignUpScreen extends BaseScreen {
  @AndroidFindBy(accessibility = "input-email")
  private AndroidElement emailTextInput;

  @AndroidFindBy(accessibility = "input-password")
  private AndroidElement passwordTextInput;

  @AndroidFindBy(accessibility = "input-repeat-password")
  private AndroidElement rePasswordTextInput;

  @AndroidFindBy(accessibility = "button-SIGN UP")
  private AndroidElement submitSignUpBtn;

  @AndroidFindBy(id = "android:id/message")
  private AndroidElement successModalMsgText;

  @AndroidFindBy(id = "android:id/button1")
  private AndroidElement sucessModalOkBtn;

  @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Login\"])[1]")
  private AndroidElement loginOptionBtn;

  public SignUpScreen(AndroidDriver<AndroidElement> driver) {
    super(driver);
  }

  public void enterEmail(String email) {
    waitUntilElementIsDisplayed(emailTextInput);
    setText(emailTextInput, email);
  }

  public void enterPassword(String password) {
    setText(passwordTextInput, password);
  }

  public void enterRePassword(String rePassword) {
    setText(rePasswordTextInput, rePassword);
  }

  public void clickOnSignUpSubmitBtn() {
    scrollUntilVisibleText("SIGN UP");
    clickOnElement(submitSignUpBtn);
  }

  public void clickOnSuccessModalOkBtn() {
    clickOnElement(sucessModalOkBtn);
  }

  public String getSuccessModalMsgText() {
    return waitUntilElementIsDisplayed(successModalMsgText).getText();
  }

  public LoginScreen clickOnLoginOptionBtn() {
    clickOnElement(loginOptionBtn);
    return new LoginScreen(driver);
  }
}


