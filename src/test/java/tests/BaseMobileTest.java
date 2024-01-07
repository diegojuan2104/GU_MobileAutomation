package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import Screens.BaseScreen;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseMobileTest {
  private AndroidDriver<AndroidElement> driver;
  protected BaseScreen baseScreen;
  @FindBy(xpath = "//android.widget.TextView[@text=\"Home\"]")
  private MobileElement menu;

  SoftAssert softAssert;
  Dotenv dotenv = Dotenv.load();

  @BeforeClass
  public void setUp() throws MalformedURLException {
    // Set up capabilities and initialize the driver
    DesiredCapabilities capabilities = environmentSetup();
    driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723"), capabilities);

    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    baseScreen = getBaseScreen();
    softAssert = new SoftAssert();
  }

  /**
   * Method to initialize the BaseScreen object
   * @return BaseScreen object
   */
  protected BaseScreen getBaseScreen() {
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.visibilityOf(menu)); // Wait until menu button is visible

    return new BaseScreen(driver);
  }

  /**
   * Method to set up the desired capabilities for the test environment
   * @return DesiredCapabilities for Appium
   */
  private DesiredCapabilities environmentSetup() {
    DesiredCapabilities capabilities = new DesiredCapabilities();

    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, dotenv.get("DEVICE_NAME"));
    capabilities.setCapability(MobileCapabilityType.APP, dotenv.get("APP_PATH"));
    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, dotenv.get("PLATFORM_VERSION"));
    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, dotenv.get("PLATFORM_NAME"));
    capabilities.setCapability("automationName", dotenv.get("AUTOMATION_NAME"));
    capabilities.setCapability("appPackage", "com.wdiodemoapp");
    capabilities.setCapability("appActivity", "com.wdiodemoapp.MainActivity");

    return capabilities;
  }

  @AfterClass
  public void tearDown() {
    driver.quit();
  }
}