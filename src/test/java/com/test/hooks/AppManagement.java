package com.test.hooks;

import com.test.helper.PropertyLoader;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URL;

import static com.test.Pages.PageFactory.setDriver;

/**
 * Created by S430030 on 30/03/2017.
 */


public class AppManagement {

    private final Logger LOG = LoggerFactory.getLogger(AppManagement.class);

    public static WebDriver driver;

//    @Rule
//    public TestName testName = new TestName();

    /* Takes care of sending the result of the tests over to TestObject. */
//    @Rule
//    public TestObjectTestResultWatcher resultWatcher = new TestObjectTestResultWatcher();

    @Before
    public void prepareApp(Scenario scenario) throws Exception {
        LOG.info("preparing app to start the test");
        try {
            driver = getWebdriver();
        } catch (Exception e) {
            throw new Exception("Driver could not be initialised " + e.getMessage());

        }
    }

    @After
    public void closeApp() throws Exception {
        LOG.info("closing app to end the test");
        try {
            if (driver != null) driver.quit();
        } catch (Exception ex) {
            LOG.info("error while closing app to end the test");
        }
    }

    private AndroidDriver getWebdriver() throws Exception {
        PropertyLoader propertyLoader=new PropertyLoader();
        AndroidDriver driver = getAndroidDriver(Boolean.parseBoolean(propertyLoader.getProperty("cloud")));

        setDriver(driver);
        return driver;
    }

    private AndroidDriver getAndroidDriver(boolean testobject) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (testobject) {
            capabilities.setCapability("testobject_api_key", PropertyLoader.getProperty("testobject_api_key"));
            capabilities.setCapability("testobject_device", PropertyLoader.getProperty("testobject_device"));
            capabilities.setCapability("testobject_suite_name", "Demo_Suite");
            capabilities.setCapability("testobject_test_name", "Demo_Test");
            AndroidDriver driver = new AndroidDriver(new URL("http://appium.testobject.com/wd/hub"), capabilities);
            return driver;
        } else {
            File appDir = new File("C:\\Automation\\Appium");
            File app = new File(appDir, "OI Shopping List_1.7.0.5.apk");
            capabilities.setCapability("device", "LC566YH07645");
            capabilities.setCapability("deviceName", "Android");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("app", app.getAbsolutePath());
            AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            return driver;
        }
    }
}
