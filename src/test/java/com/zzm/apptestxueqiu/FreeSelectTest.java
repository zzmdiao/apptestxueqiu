package com.zzm.apptestxueqiu;

import com.zzm.apptestxueqiu.drivers.DriverManger;
import com.zzm.apptestxueqiu.pages.FreeSelectPage;
import com.zzm.apptestxueqiu.pages.MainPage;
import com.zzm.apptestxueqiu.pages.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class FreeSelectTest {

    private static MainPage mainPage;
    private static FreeSelectPage freeSelectPage;
    private static AndroidDriver<WebElement> driver;

    @BeforeAll
    static void init() {
        driver = DriverManger.createDriver();
        mainPage = PageFactory.createMainPage(driver);
        freeSelectPage = PageFactory.createFreeSelectPage(driver);

        mainPage.cancelUpgrade();
        mainPage.gotoZixuan();

    }

    @ParameterizedTest
    @CsvSource({
            "suning, 苏宁易购",
            "liantong, 中国联通"
    })
    @DisplayName("添加自选、删除自选")
    public void freeSelectTest(String keyword, String name) {
        freeSelectPage.addZixuan(keyword, name);
        freeSelectPage.cancel();
        freeSelectPage.removeZixuan(name);
        assertNotEquals(freeSelectPage.getAllZixuanList().get(0), name);
    }



}
