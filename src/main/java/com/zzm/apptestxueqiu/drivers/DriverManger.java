package com.zzm.apptestxueqiu.drivers;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManger {
    private final AndroidDriver<WebElement> driver;
    private DriverManger() {
        this.driver = createAndroidDriver();
    }

    public static DriverManger getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public AndroidDriver<WebElement> getDriver() {
        return driver;
    }

    public static AndroidDriver<WebElement> createDriver() {
        return createAndroidDriver();
    }

    private static AndroidDriver<WebElement> createAndroidDriver(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "dd");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        desiredCapabilities.setCapability("autoGrantPermissions", true);

        URL remoteUrl = null;
        try {
            remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        AndroidDriver<WebElement> driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        System.out.println(driver.getSessionId());
        System.out.println(driver);
        return driver;
    }

    private static class SingletonHolder {
        private static final DriverManger INSTANCE = new DriverManger();
    }
}