package tests;

import Screens.SwipeScreen;
import Utils.Data.CommonActions;
import org.testng.annotations.Test;

public class SwipeCardsTests extends BaseMobileTest{

  @Test
  public void SwipeCardsTest(){
    int SELECTED_DOT_HEIGHT = 30;

    SwipeScreen swipeSection = (SwipeScreen) CommonActions.clickOnMenuOption("Swipe");

    swipeSection.scrollDown();

    //Check first card title
    softAssert.assertTrue(swipeSection.isDisplayedCardByTitleText("FULLY OPEN SOURCE"));

    //Swipe First card to the left and checks second card title
    swipeSection.swipeCardToTheLeft();
    swipeSection.scrollDown();

    swipeSection.test(1);


    softAssert.assertTrue(swipeSection.isDisplayedCardByTitleText("GREAT COMMUNITY"));
    softAssert.assertEquals(swipeSection.getDotHeightByIndex(2), SELECTED_DOT_HEIGHT);

    //Swipe Second Card to the right and checks first card title is visible again
    swipeSection.swipeCardToTheRight();
    softAssert.assertTrue(swipeSection.isDisplayedCardByTitleText("FULLY OPEN SOURCE"));
    softAssert.assertEquals(swipeSection.getDotHeightByIndex(1), SELECTED_DOT_HEIGHT);

    //Checks that the older card title is not display
    softAssert.assertFalse(swipeSection.isDisplayedCardByTitleText("GREAT COMMUNITY"));

    softAssert.assertAll();
  }
}
