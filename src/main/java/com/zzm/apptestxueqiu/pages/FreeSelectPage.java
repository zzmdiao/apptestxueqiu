package com.zzm.apptestxueqiu.pages;

import com.zzm.apptestxueqiu.drivers.Driver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;

public class FreeSelectPage extends BasePage {


    //点击搜索按钮添加自选记录
    public void addZixuan(String keyword, String name) {
        find(By.id("action_create_cube")).click();
        find(By.id("search_input_text")).sendKeys(keyword);
        WebElement firstElement = find(By.xpath("(//*[contains(@resource-id, 'follow') or contains(@resource-id, '_btn')])[1]"));
        if (firstElement.getAttribute("resourceId").equals("com.xueqiu.android:id/follow_btn") && getAllSelectList().get(0).equals(name)) {
            firstElement.click();
        }


    }

    //搜索页面点击取消按钮
    public FreeSelectPage cancel() {
        find(By.id("action_close")).click();
        return new FreeSelectPage();
    }

    //从自选列表中移除test=name的记录
    public void removeZixuan(String name) {
        TouchAction action = new TouchAction(Driver.getCurrentDriver());
        if (getAllZixuanList().get(0).equals(name)) {
            action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(find(text(name)))).withDuration(Duration.ofSeconds(1)));
            action.perform();
        }

        find(text("删除")).click();
    }

    //获取自选全部列表数据
    public ArrayList<String> getAllZixuanList() {
        ArrayList<String> array = new ArrayList<String>();
        for (WebElement e : finds(By.id("portfolio_stockName"))) {
            array.add(e.getText());
        }
        return array;
    }

    //获取搜索综合列表数据
    public ArrayList<String> getAllSelectList() {
        ArrayList<String> array = new ArrayList<String>();
        for (WebElement e : finds(By.id("stockName"))) {
            array.add(e.getText());
        }
        return array;

    }

}
