//package tests;
//
//import Screens.LoginScreen;
//import Screens.SignUpScreen;
//import Utils.GenericUtils;
//import Utils.RandomDataGenerator;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//public class SuccessfulSignUpTests extends BaseMobileTest {
//
//  @Test
//  public void successfulSignUpTest(){
//    String randomEmail = RandomDataGenerator.generateRandomEmail();
//    String randomPassword = RandomDataGenerator.generateRandomPassword(8,12);
//
//    LoginScreen loginScreen = (LoginScreen) GenericUtils.clickOnMenuOption("Login");
//    SignUpScreen signUpSection = loginScreen.clickOnSignUpOptionBtn();
//    signUpSection.enterEmail(randomEmail);
//    signUpSection.enterPassword(randomPassword);
//    signUpSection.enterRePassword(randomPassword);
//    signUpSection.clickOnSignUpSubmitBtn();
//
//    Assert.assertEquals(signUpSection.getSuccessModalMsgText(),"You successfully signed up!");
//  }
//}
