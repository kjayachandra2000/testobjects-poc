package com.test.Pages;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by S430030 on 30/03/2017.
 */
public class HomePage extends BasePage {
    private AppiumDriver driver;

    @FindBy(id = "autocomplete_add_item")
    private WebElement txt_itemName;

    @FindBy(id = "button_add_item")
    private WebElement btn_add_item;

    @FindBy(id = "check")
    private List<WebElement> check_itemList;

    @FindBy(className = "android.widget.ImageButton")
    private WebElement img_more_options;

    @FindBy(id = "title")
    private List<WebElement> title_List;
    @FindBy(id = "edittext")
    private WebElement txt_NewItemName;
    @FindBy(id = "button1")
    private WebElement btn_createbtn;


    public HomePage() {
        this.driver = getDriver();
        org.openqa.selenium.support.PageFactory.initElements(this.driver, this);
    }

    public void i_am_on_the_login_page() {
        assertThat("Application Launch", btn_add_item.isDisplayed());
    }

    public void iAddRandomItemsToTheList() {
        for (int i = 1; i <= 3; i++) {
            txt_itemName.sendKeys(RandomStringUtils.randomAlphabetic(10));
            btn_add_item.click();
        }
    }

    public void userAddedItemsShouldDisplay() {
        assertThat(check_itemList.size(), is(3));
    }


    public void userSelectsNewList(String arg0) {
        img_more_options.click();
        select_menu("New list");
        txt_NewItemName.sendKeys(arg0);
        btn_createbtn.click();

    }

    private void select_menu(String menu_name) {
        for (WebElement atitle_List : title_List) {
            if (atitle_List.getText().equalsIgnoreCase(menu_name)) {
                atitle_List.click();
                break;
            }
        }
    }
}
