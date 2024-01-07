package stepDefinitions;

import Screens.HomeScreen;
import Utils.GenericUtils;
import Utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class bottomMenuBarNavigation {

  public TestContextSetup testContextSetup;

  public bottomMenuBarNavigation(TestContextSetup testContextSetup) {
    this.testContextSetup = testContextSetup;
  }

  @Given("the user is on the Home screen")
  public void theUserIsOnTheHomeScreen() {
    HomeScreen homeScreen = (HomeScreen) testContextSetup.genericUtils.clickOnMenuOption("Home");
    Assert.assertTrue(homeScreen.isRobotImageDisplayed());
  }

  @When("the user taps the Drag icon on the bottom menu bar")
  public void theUserTapsTheDragIconOnTheBottomMenuBar() {
  }

  @Then("validate Drag section elements")
  public void validateDragSectionElements() {
  }

  @When("the user taps the Swipe Forms icon on the bottom menu bar")
  public void theUserTapsTheSwipeFormsIconOnTheBottomMenuBar() {
  }

  @Then("validate Swipe Forms section elements")
  public void validateSwipeFormsSectionElements() {
  }

  @When("the user taps the Login icon on the bottom menu bar")
  public void theUserTapsTheLoginIconOnTheBottomMenuBar() {
  }

  @Then("validate Login section elements")
  public void validateLoginSectionElements() {
  }

  @Given("the user is on another section")
  public void theUserIsOnAnotherSection() {
  }

  @When("the user taps the Home icon on the bottom menu bar")
  public void theUserTapsTheHomeIconOnTheBottomMenuBar() {
  }

  @Then("validate Home section elements")
  public void validateHomeSectionElements() {
  }

  @When("the user taps the Webview icon on the bottom menu bar")
  public void theUserTapsTheWebviewIconOnTheBottomMenuBar() {
  }

  @Then("validate Webview screen elements")
  public void validateWebviewScreenElements() {
  }
}