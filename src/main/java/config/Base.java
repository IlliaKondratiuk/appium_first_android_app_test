package config;

import io.appium.java_client.android.AndroidDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class Base extends Config {
    public static AndroidDriver driver;

    @BeforeClass
    public static void before() {
        if(driver == null) {
            driver = Config.setUp(AVDS.PIXEL6API33);
        }
    }

    @AfterClass
    public static void after() {
        if (driver != null) {
            driver.quit();
        }
    }


}
