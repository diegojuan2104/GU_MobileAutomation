package stepDefinitions;

import Screens.SwipeScreen;
import Utils.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SwipeCardStepDefinition {

  SwipeScreen swipeSection;
  TestContextSetup testContextSetup;
  private static final int SELECTED_DOT_HEIGHT = 20;
  public SwipeCardStepDefinition(TestContextSetup testContextSetup) {
    this.testContextSetup = testContextSetup;
  }

  @Given("the user is at the Swipe section in the first card of the carousel")
  public void theUserIsAtTheSwipeSectionInTheFirstCardOfTheCarousel() {
    swipeSection = (SwipeScreen) testContextSetup.genericUtils.clickOnMenuOption("Swipe");

    swipeSection.scrollDown();
    Assert.assertTrue(swipeSection.isDisplayedCardByTitleText("FULLY OPEN SOURCE"));
  }

  @When("the user performs a left swipe on the cards")
  public void theUserPerformsALeftSwipeOnTheCards() {
    swipeSection.swipeCardToTheLeft();
    swipeSection.scrollDown();
  }

  @Then("the first card should be hidden")
  public void theFirstCardShouldBeHidden() {
    Assert.assertFalse(swipeSection.isDisplayedCardByTitleText("FULLY OPEN SOURCE"));
  }

  @And("the second card should be visible")
  public void theSecondCardShouldBeVisible() {
    Assert.assertTrue(swipeSection.isDisplayedCardByTitleText("GREAT COMMUNITY"));
  }

  @And("the second card dot should be selected")
  public void theSecondCardDotShouldBeSelected() {
    Assert.assertEquals(SELECTED_DOT_HEIGHT, swipeSection.getDotHeightByIndex(2));
  }

  @Given("the user is at the Swipe section in the second card of the carousel")
  public void theUserIsAtTheSwipeSectionInTheSecondCardOfTheCarousel() {
    swipeSection = (SwipeScreen) testContextSetup.genericUtils.clickOnMenuOption("Swipe");
    swipeSection.swipeCardToTheRight();
    Assert.assertTrue(swipeSection.isDisplayedCardByTitleText("GREAT COMMUNITY"));
  }

  @When("the user performs a right swipe on the cards")
  public void theUserPerformsARightSwipeOnTheCards() {
    swipeSection.swipeCardToTheRight();
    Assert.assertTrue(swipeSection.isDisplayedCardByTitleText("FULLY OPEN SOURCE"));
    Assert.assertEquals(SELECTED_DOT_HEIGHT, swipeSection.getDotHeightByIndex(1));
  }

  @Then("the second card should be hidden")
  public void theSecondCardShouldBeHidden() {
    Assert.assertFalse(swipeSection.isDisplayedCardByTitleText("GREAT COMMUNITY"));
  }

  @And("the first card should be visible")
  public void theFirstCardShouldBeVisible() {
    Assert.assertTrue(swipeSection.isDisplayedCardByTitleText("FULLY OPEN SOURCE"));
  }

  @And("the first card dot should be selected")
  public void theFirstCardDotShouldBeSelected() {
    Assert.assertEquals(SELECTED_DOT_HEIGHT, swipeSection.getDotHeightByIndex(1));
  }
}
