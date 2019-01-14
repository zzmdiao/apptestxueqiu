package com.zzm.apptestxueqiu.pages;

import com.zzm.apptestxueqiu.drivers.Driver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BasePage {
    static WebElement find(By locator){
        try{
            return Driver.getCurrentDriver().findElement(locator);
        }catch (Exception e){
            Driver.getCurrentDriver().findElement(text("下次再说")).click();
            return Driver.getCurrentDriver().findElement(locator);
        }
    }
    static List<AndroidElement> finds(By locator) {
        try {
            return Driver.getCurrentDriver().findElements(locator);
        }catch (Exception e){
            Driver.getCurrentDriver().findElement(text("下次再说")).click();
            return Driver.getCurrentDriver().findElements(locator);
        }
    }
    static By locate(String locator){
        if(locator.matches("/.*")){
            return By.xpath(locator);
        }else{
            return By.id(locator);
        }
    }
    static By text(String content){
        return By.xpath("//*[@text='"+ content + "']");
    }


}