package com.zzm.apptestxueqiu.pages;

import com.zzm.apptestxueqiu.drivers.Driver;
import org.openqa.selenium.By;

public class MainPage extends BasePage {

    public static MainPage start(){
        Driver.start();
        return new MainPage();
    }

    public static void quit(){
        Driver.quit();
    }
    public void  cancelUpgrade(){
        if (Driver.getCurrentDriver().findElements(By.id("image_cancel")).size()>0){
            find(By.id("image_cancel")).click();
        }
    }
    public SearchPage gotoSearch(){
        find(By.id("home_search")).click();
        return new SearchPage();
    }

    public FreeSelectPage gotoZixuan(){
        find(text("自选")).click();
        return new FreeSelectPage();
    }

}
