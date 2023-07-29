package config;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Config {
    public static AndroidDriver setUp(AVDS avd){
        switch (avd) {
            case PIXEL6API33:return create_pixel6api33();
            default: return null;
        }
    }

    private static AndroidDriver create_pixel6api33() {
        AndroidDriver driver;
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:version",  "13");
        caps.setCapability("appium:platformName", "Android");
        caps.setCapability("appium:deviceName", "emulator-5554");
        caps.setCapability("appium:newCommandTimeout", 1800);
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.weather.forecast.weatherchannel");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.weather.forecast.weatherchannel.activities.SettingActivity");
        try {
            driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return driver;
    }
}
