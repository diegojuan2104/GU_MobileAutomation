package stepDefinitions;

import Screens.*;
import Utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class bottomMenuBarNavigationStepDefinition {

  public TestContextSetup testContextSetup;
  DragScreen dragSection;
  SwipeScreen swipeSection;
  HomeScreen homeScreen;
  FormsScreen formsSection;
  WebviewScreen webviewScreen;

  public bottomMenuBarNavigationStepDefinition(TestContextSetup testContextSetup) {
    this.testContextSetup = testContextSetup;
  }

  @Given("the user is on the Home screen")
  public void theUserIsOnTheHomeScreen() {
    homeScreen = (HomeScreen) testContextSetup.genericUtils.clickOnMenuOption("Home");
    Assert.assertTrue(homeScreen.isRobotImageDisplayed());
  }

  @When("the user taps the Drag icon on the bottom menu bar")
  public void theUserTapsTheDragIconOnTheBottomMenuBar() {
    dragSection = (DragScreen) testContextSetup.genericUtils.clickOnMenuOption("Drag");
  }

  @Then("validate Drag section elements")
  public void validateDragSectionElements() {
    Assert.assertEquals("Drag and Drop", dragSection.getTitleText());
    Assert.assertTrue(dragSection.isDragGridDisplayed());
    Assert.assertTrue(dragSection.isDragElementsGroupDisplayed());
  }

  @When("the user taps the Swipe Forms icon on the bottom menu bar")
  public void theUserTapsTheSwipeFormsIconOnTheBottomMenuBar() {
    swipeSection = (SwipeScreen)  testContextSetup.genericUtils.clickOnMenuOption("Swipe");
  }

  @Then("validate Swipe Forms section elements")
  public void validateSwipeFormsSectionElements() {
    Assert.assertEquals(swipeSection.getTitleText(), "Swipe horizontal");
    Assert.assertEquals(swipeSection.getDescriptionText(), "Or swipe vertical to find what I'm hiding.");
    Assert.assertTrue(swipeSection.isCarouselDisplayed());
    Assert.assertEquals(swipeSection.getYouFoundMeText(), "You found me!!!");
  }

  @When("the user taps the Login icon on the bottom menu bar")
  public void theUserTapsTheLoginIconOnTheBottomMenuBar() {
    formsSection = (FormsScreen)  testContextSetup.genericUtils.clickOnMenuOption("Forms");
  }

  @Then("validate Login section elements")
  public void validateLoginSectionElements() {
    Assert.assertEquals(formsSection.getTitleText(), "Form components");
    Assert.assertTrue(formsSection.isTextInputDisplayed());
    Assert.assertTrue(formsSection.isYouHaveTypedTextDisplayed());
    Assert.assertTrue(formsSection.isSwitchBtnInputDisplayed());
    Assert.assertTrue(formsSection.isDropDownInputDisplayed());
    Assert.assertTrue(formsSection.isInactiveBtnInputDisplayed());
    Assert.assertTrue(formsSection.isActiveBtnInputDisplayed());
  }

  @Given("the user is not in home Section")
  public void theUserIsNotInHomeSection() {
    formsSection = (FormsScreen)  testContextSetup.genericUtils.clickOnMenuOption("Forms");
  }

  @When("the user taps the Home icon on the bottom menu bar")
  public void theUserTapsTheHomeIconOnTheBottomMenuBar() {
    homeScreen = (HomeScreen) testContextSetup.genericUtils.clickOnMenuOption("Home");
    Assert.assertTrue(homeScreen.isRobotImageDisplayed());
  }

  @Then("validate Home section elements")
  public void validateHomeSectionElements() {
    Assert.assertTrue(homeScreen.isRobotImageDisplayed());
    Assert.assertEquals(homeScreen.getTitleText(), "WEBDRIVER");
    Assert.assertEquals(homeScreen.getSubtitleText(), "Demo app for the appium-boilerplate");
    Assert.assertTrue(homeScreen.isMacImgDisplayed());
    Assert.assertTrue(homeScreen.isAndroidImgDisplayed());
    Assert.assertEquals(homeScreen.getSupportText(), "Support");
  }

  @When("the user taps the Webview icon on the bottom menu bar")
  public void theUserTapsTheWebviewIconOnTheBottomMenuBar() {
    webviewScreen = (WebviewScreen)  testContextSetup.genericUtils.clickOnMenuOption("Webview");
  }

  @Then("validate Webview screen elements")
  public void validateWebviewScreenElements() {
    Assert.assertTrue(webviewScreen.isWebViewDisplayed());
  }
}