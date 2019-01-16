package com.zzm.apptestxueqiu.pages;

import org.openqa.selenium.By;

public class MainPage extends BasePage {

    public  void  cancelUpgrade(){
        if (driver.findElements(By.id("image_cancel")).size()>0){
            find(By.id("image_cancel")).click();
        }
    }
    public void gotoSearch(){
        find(By.id("home_search")).click();
    }

    public void gotoZixuan(){
        find(text("自选")).click();
    }

}
