package com.zzm.apptestxueqiu.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class PageFactory {

    public static MainPage createMainPage(AndroidDriver<WebElement> driver) {
        MainPage mainPage = new MainPage();
        mainPage.setDriver(driver);
        return mainPage;
    }

    public static FreeSelectPage createFreeSelectPage(AndroidDriver<WebElement> driver) {
        FreeSelectPage sp = new FreeSelectPage();
        sp.setDriver(driver);
        return sp;
    }

    public static SearchPage createSearchPage(AndroidDriver<WebElement> driver) {
        SearchPage sp = new SearchPage();
        sp.setDriver(driver);
        return sp;
    }
}
