package com.zzm.apptestxueqiu.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class BasePage {

    protected AppiumDriver<WebElement> driver;

     WebElement find(By locator) {
        try {
            return driver.findElement(locator);
        } catch (Exception e) {
            driver.findElement(text("下次再说")).click();
            return driver.findElement(locator);
        }
    }

    List<WebElement> finds(By locator) {
        try {
            return driver.findElements(locator);
        } catch (Exception e) {
            driver.findElement(text("下次再说")).click();
            return driver.findElements(locator);
        }
    }

    By text(String content) {
        return By.xpath("//*[@text='" + content + "']");
    }

    //
    public void setDriver(AppiumDriver<WebElement> driver) {
        this.driver = driver;
    }
}