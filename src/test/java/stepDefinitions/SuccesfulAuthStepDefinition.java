package stepDefinitions;

import Screens.LoginScreen;
import Screens.SignUpScreen;
import Utils.RandomDataGenerator;
import Utils.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SuccesfulAuthStepDefinition {
  public TestContextSetup testContextSetup;
  LoginScreen loginScreen;
  SignUpScreen signUpSection;

  public SuccesfulAuthStepDefinition(TestContextSetup testContextSetup) {
    this.testContextSetup = testContextSetup;
  }

  @Given("the user navigates at the Login section")
  public void theUserIsAtTheLoginSection() {
    loginScreen = (LoginScreen) testContextSetup.genericUtils.clickOnMenuOption("Login");
  }

  @When("the user navigates to the Signup section")
  public void theUserNavigatesToTheSignupSection() {
    signUpSection = loginScreen.clickOnSignUpOptionBtn();
  }

  @And("fills all the required form data to sign up")
  public void fillsAllTheRequiredFormDataToSignUp() {
    String randomEmail = RandomDataGenerator.generateRandomEmail();
    String randomPassword = RandomDataGenerator.generateRandomPassword(8,12);
    signUpSection.enterEmail(randomEmail);
    signUpSection.enterPassword(randomPassword);
    signUpSection.enterRePassword(randomPassword);
    signUpSection.clickOnSignUpSubmitBtn();
  }

  @And("completes the signup process clicking on the submit button")
  public void completesTheSignupProcess() {
    signUpSection = loginScreen.clickOnSignUpOptionBtn();
  }

  @Then("the signup should be successfully completed")
  public void theSignupShouldBeSuccessfullyCompleted() {
    Assert.assertEquals(signUpSection.getSuccessModalMsgText(),"You successfully");
  }

  @And("the user fills in valid login credentials")
  public void theUserFillsInValidLoginCredentials() {

    signUpSection = loginScreen.clickOnSignUpOptionBtn();
    String randomEmail = RandomDataGenerator.generateRandomEmail();
    String randomPassword = RandomDataGenerator.generateRandomPassword(8,12);
    signUpSection.enterEmail(randomEmail);
    signUpSection.enterPassword(randomPassword);
    signUpSection.enterRePassword(randomPassword);
    signUpSection.clickOnSignUpSubmitBtn();
    loginScreen.enterEmail(randomEmail);
    loginScreen.enterPassword(randomPassword);
  }

  @And("submits the login form")
  public void submitsTheLoginForm() {
    loginScreen.clickOnLoginSubmitBtn();
  }

  @Then("the login should be successful")
  public void theLoginShouldBeSuccessful() {
    Assert.assertEquals(loginScreen.getSuccessModalMsgText(),"You are logged in!");
  }
}
