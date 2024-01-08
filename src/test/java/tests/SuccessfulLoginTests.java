package tests;

import Screens.LoginScreen;
import Screens.SignUpScreen;
import Utils.Data.CommonActions;
import Utils.Data.RandomDataGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuccessfulLoginTests extends BaseMobileTest {
  @Test
  public void successfulSignUpTest(){
    String randomEmail = RandomDataGenerator.generateRandomEmail();
    String randomPassword = RandomDataGenerator.generateRandomPassword(8,12);

    //Register
    LoginScreen loginScreen = (LoginScreen) CommonActions.clickOnMenuOption("Login");
    SignUpScreen signUpSection = loginScreen.clickOnSignUpOptionBtn();
    signUpSection.enterEmail(randomEmail);
    signUpSection.enterPassword(randomPassword);
    signUpSection.enterRePassword(randomPassword);
    signUpSection.clickOnSignUpSubmitBtn();
    signUpSection.clickOnSuccessModalOkBtn();
    signUpSection.clickOnLoginOptionBtn();

    //Login
    loginScreen.enterEmail(randomEmail);
    loginScreen.enterPassword(randomPassword);
    loginScreen.clickOnLoginSubmitBtn();

    Assert.assertEquals(loginScreen.getSuccessModalMsgText(),"You are logged in!");
  }
}
