package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;
import org.openqa.selenium.WebDriver;
import java.net.URL;
import java.net.MalformedURLException;

public class AppiumBase {

    protected WebDriver driver;

    public AppiumBase() throws MalformedURLException {
        setUp();
    }

    public void setUp() throws MalformedURLException {
        // Create BaseOptions and set capabilities for Appium
        BaseOptions options = new BaseOptions()
                .amend("platformName", "android")
                .amend("appium:automationName", "UiAutomator2")
                .amend("appium:platformVersion", "14")
                .amend("appium:deviceName", "ormfdemr6l6tir85")
                .amend("appium:app", "D:/apptest/app-release-1.apk")
                .amend("appium:noReset", true)
                .amend("appium:newCommandTimeout", 3600)
                .amend("appium:connectHardwareKeyboard", true);

        // Initialize the AndroidDriver with the correct URL and options
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
