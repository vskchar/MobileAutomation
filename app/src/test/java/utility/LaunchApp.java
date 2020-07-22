package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;

public class LaunchApp {

    public AndroidDriver<WebElement> driver = null;

    public void setUp() throws MalformedURLException, MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","emulator-5554");
        capabilities.setCapability("platformName","Android");
        //capabilities.setCapability("appPackage","in.amazon.mShop.android.shopping");
        //capabilities.setCapability("appActivity","com.amazon.mShop.home.HomeActivity");
        capabilities.setCapability("appPackage","naukriApp.appModules.login");
        capabilities.setCapability("appActivity","com.naukri.dashboard.view.NaukriSplashScreen");
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

    }
}
