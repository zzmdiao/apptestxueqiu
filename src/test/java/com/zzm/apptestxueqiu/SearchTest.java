package com.zzm.apptestxueqiu;

import com.zzm.apptestxueqiu.pages.MainPage;
import com.zzm.apptestxueqiu.pages.SearchPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTest {
    @Autowired
    static MainPage mainPage;
    @Autowired
    static SearchPage searchPage;

    @BeforeAll
    static void beforeAll(){
        mainPage= MainPage.start();
        mainPage.cancelUpgrade();
        searchPage=mainPage.gotoSearch();
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
    @AfterAll
    public void afterAll() {
        mainPage.quit();
    }
}
