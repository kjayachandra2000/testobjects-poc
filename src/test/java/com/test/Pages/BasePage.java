package com.test.Pages;

import org.openqa.selenium.WebElement;


/**
 * Created by s746032 on 18/11/2015.
 */
public class BasePage extends PageFactory {

    public void clickOn(WebElement webElement) throws Exception {
        webElement.click();
        Thread.sleep(1000);
    }

}

