package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class ProfileTests extends AppiumBase{
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public void getToSettings(){
             try {

         WebElement dropdownTrigger = wait.until(ExpectedConditions.elementToBeClickable(
                  AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(4)")));
           dropdownTrigger.click();
           System.out.println("Dropdown trigger clicked.");

           Thread.sleep(1000);

           WebElement selectedItem = wait.until(ExpectedConditions.elementToBeClickable(
                  AppiumBy.xpath("//android.widget.TextView[@text='Settings']")));
          selectedItem.click();
           System.out.println("First item clicked.");

       } catch (Exception e) {
            System.out.println("Error while interacting with the dropdown: " + e.getMessage());
           Assert.fail("Test failed due to exception: " + e.getMessage());
       }
    }
    public ProfileTests() throws MalformedURLException {
    }
    @Test
    public void testChangeUsername_Empty_ErrorMessage() {

getToSettings();
        try {
            WebElement username = driver.findElement(By.xpath("//android.widget.EditText[@index='4']"));
            username.clear();

            System.out.println("Text changed");
        }
        catch (Exception e){
            Assert.fail("Couldn't change text in new username field");
        }

        try{
            WebElement saveButton = driver.findElement(By.xpath("//android.widget.Button[@index='1']"));
            System.out.println("Located save button");
            saveButton.click();
        }
        catch (Exception e){
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }

        WebElement toastMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.xpath("//android.widget.Toast[@text='Profile updated successfully']")
        ));

        // Validate the toast message content
        String toastText = toastMessage.getText();
        assertEquals("Profile updated successfully", toastText);


    }

    @Test
    public void testChangDescription_Empty_ErrorMessage() {
getToSettings();
        try {
            WebElement description= driver.findElement(By.xpath("//android.widget.EditText[@index='6']"));
            description.clear();

            System.out.println("Text changed");
        }
        catch (Exception e){
            Assert.fail("Couldn't change text in description field");
        }

        try{
            WebElement saveButton = driver.findElement(By.xpath("//android.widget.Button[@index='1']"));
            System.out.println("Located save button");
            saveButton.click();
        }
        catch (Exception e){
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }

        WebElement toastMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.xpath("//android.widget.Toast[@text='Profile updated successfully']")
        ));

        // Validate the toast message content
        String toastText = toastMessage.getText();
        assertEquals("Profile updated successfully", toastText);


    }

    @Test
    public void testChangeUsername_ValidDetails_Success() {
getToSettings();
        try {
            WebElement username = driver.findElement(By.xpath("//android.widget.EditText[@index='4']"));
            username.clear();
            username.sendKeys("New username");

            System.out.println("Text changed");
        }
        catch (Exception e){
            Assert.fail("Couldn't change text in new username field");
        }

        try{
            WebElement saveButton = driver.findElement(By.xpath("//android.widget.Button[@index='1']"));
            System.out.println("Located save button");
            saveButton.click();
        }
        catch (Exception e){
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }

        WebElement toastMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.xpath("//android.widget.Toast[@text='Profile updated successfully']")
        ));

        // Validate the toast message content
        String toastText = toastMessage.getText();
        assertEquals("Profile updated successfully", toastText);


    }

    @Test
    public void testChangDescription_ValidDetails_Success() {
getToSettings();
        try {
            WebElement description= driver.findElement(By.xpath("//android.widget.EditText[@index='6']"));
            description.clear();
            description.sendKeys("Some new description");

            System.out.println("Text changed");
        }
        catch (Exception e){
            Assert.fail("Couldn't change text in description field");
        }

        try{
            WebElement saveButton = driver.findElement(By.xpath("//android.widget.Button[@index='1']"));
            System.out.println("Located save button");
            saveButton.click();
        }
        catch (Exception e){
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }

        WebElement toastMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.xpath("//android.widget.Toast[@text='Profile updated successfully']")
        ));

        // Validate the toast message content
        String toastText = toastMessage.getText();
        assertEquals("Profile updated successfully", toastText);


    }

}
