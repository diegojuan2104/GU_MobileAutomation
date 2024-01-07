package Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {

  public AndroidDriver driver;

  Dotenv dotenv = Dotenv.load();

  public AndroidDriver WebDriverManager() {

   if (driver == null) {
     try {
       DesiredCapabilities capabilities = environmentSetup();
       driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723"), capabilities);

       PageFactory.initElements(new AppiumFieldDecorator(driver), this);

       return driver;
     } catch (MalformedURLException e) {
       e.printStackTrace();
       return null;
     }

   }
    return driver;
  }

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
}
