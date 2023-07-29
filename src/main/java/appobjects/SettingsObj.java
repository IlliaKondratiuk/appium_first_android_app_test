package appobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class SettingsObj {
    static AndroidDriver driver;

    public SettingsObj(AndroidDriver driver) {
        this.driver = driver;
    }

    By tempSwitch = By.id("com.weather.forecast.weatherchannel:id/tgTemperature_setting");
    By timeSwitch = By.id("com.weather.forecast.weatherchannel:id/tg_format_time_setting");
    By windSpeedArrow = By.id("com.weather.forecast.weatherchannel:id/iv_arrow_distance");
    By chooseSpeedScreen = By.id("com.weather.forecast.weatherchannel:id/md_contentRecyclerView");
    By notificationToggle = By.id("com.weather.forecast.weatherchannel:id/tgNotifi_settings");
    By statusToggle = By.id("com.weather.forecast.weatherchannel:id/tg_notifi_second_settings");
    By doneButton = By.id("com.weather.forecast.weatherchannel:id/tvDone");

    public void tempTo(TEMP temp) {
        MobileElement tempsw = (MobileElement) driver.findElement(tempSwitch);
        switch (temp) {
            case C:
                if (tempsw.getAttribute("checked").equals("true")) {
                    tempsw.click();
                }
            case F:
                if (tempsw.getAttribute("checked").equals("false")) {
                    tempsw.click();
                }
        }
    }

    public void timeTo(TIMEFORMATS time) {
        MobileElement timesw = (MobileElement) driver.findElement(timeSwitch);
            switch (time) {
            case T12:
                if (timesw.getAttribute("checked").equals("false")) {
                    timesw.click();
                }
            case T24:
                if (timesw.getAttribute("checked").equals("true")) {
                    timesw.click();
                }
        }
    }

    public void clickWindSpeedArrow() {
        MobileElement arrow = (MobileElement) driver.findElement(windSpeedArrow);
        arrow.click();

    }

    public void selectWindSpeed(SPEED speed) {

        MobileElement choose = (MobileElement) driver.findElement(chooseSpeedScreen);

        for (MobileElement element : choose.findElements(By.className("android.widget.LinearLayout"))) {
            if (element.findElement(By.className("android.widget.TextView")).getAttribute("text").equals(speed.speedinapp)) {
                element.click();
                return;
            }
        }
    }

    public void setNotificationToggle(boolean isEnabled) {
        MobileElement notifSwitch = (MobileElement) driver.findElement(notificationToggle);
        if (isEnabled) {
            if (notifSwitch.getAttribute("checked").equals("false")) {
                notifSwitch.click();
            }
        } else {
            if (notifSwitch.getAttribute("checked").equals("true")) {
                notifSwitch.click();
            }
        }
    }

    public void setStatusToggle(boolean isEnabled) {
        MobileElement statusSwitch = (MobileElement) driver.findElement(statusToggle);
        if (isEnabled) {
            if (statusSwitch.getAttribute("checked").equals("false")) {
                statusSwitch.click();
            }
        } else {
            if (statusSwitch.getAttribute("checked").equals("true")) {
                statusSwitch.click();
            }
        }
    }

    public void clickDone() {
        driver.findElement(doneButton).click();
    }
}

