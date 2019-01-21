package com.zzm.apptestxueqiu;

import com.zzm.apptestxueqiu.drivers.DriverManger;
import com.zzm.apptestxueqiu.drivers.GlobalConfig;
import com.zzm.apptestxueqiu.pages.FreeSelectPage;
import com.zzm.apptestxueqiu.pages.MainPage;
import com.zzm.apptestxueqiu.pages.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebElement;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

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

    @ParameterizedTest
    @CsvFileSource(resources = "/data/select.csv")
    @DisplayName("添加自选、删除自选(csv模式)")
    public void freeSelectTest2(String keyword, String name) {
        freeSelectPage.addZixuan(keyword, name);
        freeSelectPage.cancel();
        freeSelectPage.removeZixuan(name);
        assertNotEquals(freeSelectPage.getAllZixuanList().get(0), name);
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    @DisplayName("添加自选、删除自选(配置模式)")
    public void freeSelectTest3(String keyword, String name) {

        freeSelectPage.addZixuan(keyword, name);
        freeSelectPage.cancel();
        freeSelectPage.removeZixuan(name);
        assertNotEquals(freeSelectPage.getAllZixuanList().get(0), name);
    }

    static Stream<Arguments> stringProvider() {
        Yaml yaml = new Yaml();
        InputStream in = FreeSelectTest.class.getResourceAsStream("/globalConfig.yml");
        GlobalConfig config = yaml.loadAs(in, GlobalConfig.class );
        System.out.println(config.getData().getSelectinput());
        System.out.println(config.getData().getSelectresult());
        return Stream.of(
                arguments(config.getData().getSelectinput()[0],config.getData().getSelectresult()[0]),
                arguments(config.getData().getSelectinput()[1],config.getData().getSelectresult()[1])
        );
    }

}
