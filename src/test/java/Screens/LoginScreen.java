package Screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginScreen extends BaseScreen {

  @AndroidFindBy(xpath = "//android.widget.TextView[@text='Login / Sign up Form']")
  private AndroidElement titleText;

  @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"When the device has Touch/FaceID (iOS) or FingerPrint enabled a biometrics button will be shown to use and test the login.\"]")
  private AndroidElement descriptionText;

  @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sign up']")
  private AndroidElement signUpOptionBtn;

  @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Login\"])[1]")
  private AndroidElement loginOptionBtn;

  @AndroidFindBy(accessibility = "input-email")
  private AndroidElement emailTextInput;

  @AndroidFindBy(accessibility = "input-password")
  private AndroidElement passwordTextInput;

  @AndroidFindBy(accessibility = "button-LOGIN")
  private AndroidElement submitLoginBtn;

  @AndroidFindBy(id = "android:id/message")
  private AndroidElement successModalMsgText;

  public LoginScreen(AndroidDriver<AndroidElement> driver) {
    super(driver);
  }


  public void enterEmail(String email) {
    waitUntilElementIsDisplayed(emailTextInput);
    setText(emailTextInput, email);
  }

  public void enterPassword(String password) {
    setText(passwordTextInput, password);
  }

  public SignUpScreen clickOnSignUpOptionBtn() {
    clickOnElement(signUpOptionBtn);
    return new SignUpScreen(driver);
  }

  public String getTitleText() {
    waitUntilElementIsDisplayed(titleText);
    return titleText.getText();
  }

  public String getDescriptionText() {
    waitUntilElementIsDisplayed(descriptionText);
    return descriptionText.getText();
  }

  public void clickOnLoginSubmitBtn() {
    clickOnElement(submitLoginBtn);
  }

  public String getSuccessModalMsgText() {
    return waitUntilElementIsDisplayed(successModalMsgText).getText();
  }

  public Boolean isSignUpOptionDisplayed() {
    return isElementDisplayed(signUpOptionBtn);
  }

  public Boolean isLoginOptionDisplayed() {
    return isElementDisplayed(loginOptionBtn);
  }

  public Boolean isEmailTextInputDisplayed() {
    return isElementDisplayed(emailTextInput);
  }

  public Boolean isPasswordTextInputDisplayed() {
    return isElementDisplayed(passwordTextInput);
  }

  public Boolean isSubmitBtnDisplayed() {
    return isElementDisplayed(submitLoginBtn);
  }

}
