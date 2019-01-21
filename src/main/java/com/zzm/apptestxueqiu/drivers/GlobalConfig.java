package com.zzm.apptestxueqiu.drivers;


public class GlobalConfig {

    private AppiumConfig appium;
    private DataCofig data;

    public DataCofig getData() {
        return data;
    }

    public void setData(DataCofig data) {
        this.data = data;
    }

    public AppiumConfig getAppium() {
        return appium;
    }

    public void setAppium(AppiumConfig appium) {
        this.appium = appium;
    }
}
