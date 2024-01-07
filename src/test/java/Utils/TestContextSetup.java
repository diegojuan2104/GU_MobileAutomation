package Utils;

import io.appium.java_client.android.AndroidDriver;

public class TestContextSetup {
  AndroidDriver driver;
  public TestBase testBase;
  public GenericUtils genericUtils;

  public TestContextSetup() {
    testBase = new TestBase();
    this.driver = testBase.WebDriverManager();
    genericUtils = new GenericUtils(driver);

   // pageObjectManager = new PageObjectManager(driver);// genericUtils = new GenericUtils(driver);
  }
}
