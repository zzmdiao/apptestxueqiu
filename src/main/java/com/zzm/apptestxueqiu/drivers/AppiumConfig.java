package com.zzm.apptestxueqiu.drivers;

import java.util.HashMap;

public class AppiumConfig {

    private String url;
    private String app;
    private Integer wait;
    private HashMap<String, Object> capabilities;

    public String getUrl() {
        return url;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getWait() {
        return wait;
    }

    public void setWait(Integer wait) {
        this.wait = wait;
    }

    public HashMap<String, Object> getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(HashMap<String, Object> capabilities) {
        this.capabilities = capabilities;
    }
}
