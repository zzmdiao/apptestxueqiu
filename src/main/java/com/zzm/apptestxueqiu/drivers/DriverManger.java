package com.zzm.apptestxueqiu.drivers;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
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
//        desiredCapabilities.setCapability("platformName", "android");
//        desiredCapabilities.setCapability("deviceName", "dd");
//        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
//        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
//        desiredCapabilities.setCapability("autoGrantPermissions", true);

        Yaml yaml = new Yaml();
        InputStream in = DriverManger.class.getResourceAsStream("/globalConfig.yml");
        GlobalConfig config = yaml.loadAs(in, GlobalConfig.class );
        HashMap hashMap = config.getAppium().getCapabilities();

        hashMap.forEach(( key ,value )->{
            desiredCapabilities.setCapability((String) key,value);
        });


        URL remoteUrl = null;
        try {
            remoteUrl = new URL(config.getAppium().getUrl());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        AndroidDriver<WebElement> driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(config.getAppium().getWait(), TimeUnit.SECONDS);
        return driver;
    }

    private static class SingletonHolder {
        private static final DriverManger INSTANCE = new DriverManger();
    }


}