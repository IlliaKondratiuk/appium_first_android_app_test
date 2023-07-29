import appobjects.SPEED;
import appobjects.SettingsObj;
import appobjects.TEMP;
import appobjects.TIMEFORMATS;
import config.Base;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test1 extends Base {
    static SettingsObj settings;

    @BeforeClass
    public static void setDriver() {
        settings = new SettingsObj(driver);
    }
    @Test
    public void clickTempSwitch() {
        settings.tempTo(TEMP.F);
    }

    @Test
    public void clickTimeSwitch() {
        settings.timeTo(TIMEFORMATS.T24);
    }

    @Test
    public void selectSpeed() {
        settings.clickWindSpeedArrow();
        settings.selectWindSpeed(SPEED.KNOTS);
    }

    @Test
    public void enableNotifications() {
        settings.setNotificationToggle(false);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void enableStatusBar() {
        settings.setStatusToggle(true);
    }

    @Test
    public void clickDone(){
        settings.clickDone();
    }
}
