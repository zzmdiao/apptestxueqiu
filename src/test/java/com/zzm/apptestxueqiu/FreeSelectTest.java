package com.zzm.apptestxueqiu;

import com.zzm.apptestxueqiu.pages.MainPage;
import com.zzm.apptestxueqiu.pages.FreeSelectPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class FreeSelectTest {

    @Autowired
    static MainPage mainPage;
    @Autowired
    static FreeSelectPage freeSelectPage;

    @BeforeAll
    static void beforeAll(){
        mainPage= MainPage.start();
        mainPage.cancelUpgrade();
        freeSelectPage =mainPage.gotoZixuan();
    }
    @ParameterizedTest
    @CsvSource({
            "suning, 苏宁易购",
            "liantong, 中国联通"
    })
    public void freeSelectTest(String keyword, String name){
        freeSelectPage.addZixuan(keyword, name);
        freeSelectPage.cancel();
        freeSelectPage.removeZixuan(name);
        assertNotEquals(freeSelectPage.getAllZixuanList().get(0),name);
    }


}
