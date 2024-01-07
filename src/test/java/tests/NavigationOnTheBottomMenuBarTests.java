//package tests;
//
//import Screens.*;
//import Utils.GenericUtils;
//import org.testng.annotations.Test;
//
//public class NavigationOnTheBottomMenuBarTests extends BaseMobileTest {
//
//  @Test
//  public void navigateToDragScreen()  {
//    DragScreen dragSection = (DragScreen) GenericUtils.clickOnMenuOption("Drag");
//    softAssert.assertEquals(dragSection.getTitleText(), "Drag and Drop");
//    softAssert.assertTrue(dragSection.isDragGridDisplayed());
//    softAssert.assertTrue(dragSection.isDragElementsGroupDisplayed());
//    softAssert.assertAll();
//  }
//
//  @Test
//  public void navigateToSwipeScreen(){
//    SwipeScreen swipeSection = (SwipeScreen) GenericUtils.clickOnMenuOption("Swipe");
//    softAssert.assertEquals(swipeSection.getTitleText(), "Swipe horizontal");
//    softAssert.assertEquals(swipeSection.getDescriptionText(), "Or swipe vertical to find what I'm hiding.");
//    softAssert.assertTrue(swipeSection.isCarouselDisplayed());
//    softAssert.assertEquals(swipeSection.getYouFoundMeText(), "You found me!!!");
//    softAssert.assertAll();
//  }
//
//  @Test
//  public void navigateToFormsScreen(){
//    FormsScreen formsSection = (FormsScreen) GenericUtils.clickOnMenuOption("Forms");
//    softAssert.assertEquals(formsSection.getTitleText(), "Form components");
//    softAssert.assertTrue(formsSection.isTextInputDisplayed());
//    softAssert.assertTrue(formsSection.isYouHaveTypedTextDisplayed());
//    softAssert.assertTrue(formsSection.isSwitchBtnInputDisplayed());
//    softAssert.assertTrue(formsSection.isDropDownInputDisplayed());
//    softAssert.assertTrue(formsSection.isInactiveBtnInputDisplayed());
//    softAssert.assertTrue(formsSection.isActiveBtnInputDisplayed());
//    softAssert.assertAll();
//  }
//
//  @Test
//  public void navigateToLoginScreen(){
//    LoginScreen loginScreen = (LoginScreen) GenericUtils.clickOnMenuOption("Login");
//    softAssert.assertEquals(loginScreen.getTitleText(), "Login / Sign up Form");
//    softAssert.assertEquals(loginScreen.getDescriptionText(), "When the device has Touch/FaceID (iOS) or FingerPrint enabled a biometrics button will be shown to use and test the login.");
//    softAssert.assertTrue(loginScreen.isLoginOptionDisplayed());
//    softAssert.assertTrue(loginScreen.isSignUpOptionDisplayed());
//    softAssert.assertTrue(loginScreen.isEmailTextInputDisplayed());
//    softAssert.assertTrue(loginScreen.isPasswordTextInputDisplayed());
//    softAssert.assertTrue(loginScreen.isSubmitBtnDisplayed());
//    softAssert.assertAll();
//  }
//
//  @Test
//  public void navigateWebviewScreen(){
//    WebviewScreen webviewScreen = (WebviewScreen) GenericUtils.clickOnMenuOption("Webview");
//    softAssert.assertTrue(webviewScreen.isWebViewDisplayed());
//    softAssert.assertAll();
//  }
//
//  @Test
//  public void navigateToHomeScreen()  {
//    HomeScreen homeScreen = (HomeScreen) GenericUtils.clickOnMenuOption("Home");
//    softAssert.assertTrue(homeScreen.isRobotImageDisplayed());
//    softAssert.assertEquals(homeScreen.getTitleText(),"WEBDRIVER");
//    softAssert.assertEquals(homeScreen.getSubtitleText(),"Demo app for the appium-boilerplate");
//    softAssert.assertTrue(homeScreen.isMacImgDisplayed());
//    softAssert.assertTrue(homeScreen.isAndroidImgDisplayed());
//    softAssert.assertEquals(homeScreen.getSupportText(), "Support");
//  }
//}
