package Screens;

import Screens.BaseScreen;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;

public class SwipeScreen extends BaseScreen {

  @AndroidFindBy(xpath = "//android.widget.TextView[@text='Swipe horizontal']")
  private AndroidElement titleText;

  @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Or swipe vertical to find what I'm hiding.\"]")
  private AndroidElement descriptionText;

  @AndroidFindBy(accessibility = "Carousel")
  private AndroidElement carousel;

  @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Carousel\"]/android.view.ViewGroup/android.view.ViewGroup")
  private List<AndroidElement> dotsList;


  public SwipeScreen(AndroidDriver<AndroidElement> driver) {
    super(driver);
  }

  public void swipeCardToTheLeft() {
    Dimension size = driver.manage().window().getSize();
    int startX = (int) (size.width * 0.8);
    int startY = size.getHeight() / 2;
    int endX = (int) (size.width * 0.20);
    int endY = startY;

    swipeOrScroll(startX, startY, endX, endY);
  }

  public void swipeCardToTheRight() {
    Dimension size = driver.manage().window().getSize();
    int startX = (int) (size.width * 0.20);
    int startY = size.getHeight() / 2;
    int endX = (int) (size.width * 0.8);
    int endY = startY;

    swipeOrScroll(startX, startY, endX, endY);
  }

  public String getTitleText() {
    waitUntilElementIsDisplayed(titleText);
    return titleText.getText();
  }

  public String getDescriptionText() {
    waitUntilElementIsDisplayed(descriptionText);
    return descriptionText.getText();
  }

  public Boolean isCarouselDisplayed() {
    return isElementDisplayed(carousel);
  }

  public void test(int index){
    System.out.println(dotsList.size());
  }

  public int getDotHeightByIndex(int index) {
    return dotsList.get(index).getSize().getHeight();

//
//    return driver
//        .findElement(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"Carousel\"]" +
//            "/android.view.ViewGroup/android.view.ViewGroup[" + index + "]/android.view.ViewGroup")).getSize().getHeight();
  }

  public Boolean isDisplayedCardByTitleText(String text) {
    try {
      AndroidElement cardTitle = driver.findElement(MobileBy.xpath(
          "//android.widget.TextView[@text=\"" + text + "\"]"));
      return cardTitle.isDisplayed();
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public String getYouFoundMeText(){
    return scrollUntilVisibleText("You found me!!!");
  }
}