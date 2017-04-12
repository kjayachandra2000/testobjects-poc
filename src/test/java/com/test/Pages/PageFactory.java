package com.test.Pages;

import io.appium.java_client.AppiumDriver;

/**
 * Created by S430030 on 30/03/2017.
 */
public class PageFactory {
    private static AppiumDriver driver;

    public static AppiumDriver getDriver() {
        return driver;
    }
    public static void setDriver(AppiumDriver driverInstance) {
        driver = driverInstance;
    }

}
