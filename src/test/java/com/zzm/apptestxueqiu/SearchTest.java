package com.zzm.apptestxueqiu;

import com.zzm.apptestxueqiu.drivers.DriverManger;
import com.zzm.apptestxueqiu.pages.MainPage;
import com.zzm.apptestxueqiu.pages.SearchPage;
import com.zzm.apptestxueqiu.pages.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTest {
    private static MainPage mainPage;
    private static SearchPage searchPage;
    private static AndroidDriver<WebElement> driver;

    @BeforeAll
    static void init() {
        //1.create driver
        driver = DriverManger.createDriver();

        //2.
        mainPage = PageFactory.createMainPage(driver);
        searchPage = PageFactory.createSearchPage(driver);

        mainPage.cancelUpgrade();
        mainPage.gotoZixuan();

    }


    @ParameterizedTest
    @CsvSource({
            "pdd, 拼多多",
            "alibaba, 阿里巴巴",
            "sogo, 搜狗"
    })
    void 搜索测试(String keyword, String name){
        String content=searchPage.search(keyword).getAll().get(0);
        assertEquals(content, name);
    }

}
