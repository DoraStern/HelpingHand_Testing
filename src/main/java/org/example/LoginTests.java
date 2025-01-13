package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTests extends AppiumBase  {


    public LoginTests() throws MalformedURLException {
    }


    @Test
    public void testUserLogin_InvalidEmail_ErrorMessage()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Wait for the email field to be visible and then locate it
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@index='3']")));
            emailField.sendKeys("testuser");
            System.out.println("Entered email: testuser");
        } catch (Exception e) {
            System.out.println("Error while entering email: " + e.getMessage());
            Assert.fail("Email field interaction failed");
        }

        try {
            // Locate the password field (with explicit wait)
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@index='5']")));
            passwordField.sendKeys("password123");
            System.out.println("Entered password.");
        } catch (Exception e) {
            System.out.println("Error while entering password: " + e.getMessage());
            Assert.fail("Password field interaction failed");
        }

        try {
            // Locate and click the login button
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@index='1']")));
            loginButton.click();
            System.out.println("Clicked on login button.");
        } catch (Exception e) {
            System.out.println("Error while clicking login button: " + e.getMessage());
            Assert.fail("Login button click failed");
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Waited for confirmation of login.");


        try {
            WebElement successMessage = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Find volunteering events\"]"));
            Assert.assertTrue(successMessage.isDisplayed(), "Success message not found!");
            System.out.println("Login successful, Element found.");
        } catch (Exception e) {
            System.out.println("Error while checking for Element: " + e.getMessage());
            Assert.fail("Error while checking for Element: " + e.getMessage());

        }

    }

    @Test
    public void testUserLogin_BlankPassword_ErrorMessage()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Wait for the email field to be visible and then locate it
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@index='3']")));
            emailField.sendKeys("testuser");
            System.out.println("Entered email: testuser");
        } catch (Exception e) {
            System.out.println("Error while entering email: " + e.getMessage());
            Assert.fail("Email field interaction failed");
        }

        try {
            // Locate the password field (with explicit wait)
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@index='5']")));
            passwordField.sendKeys("");
            System.out.println("Entered password.");
        } catch (Exception e) {
            System.out.println("Error while entering password: " + e.getMessage());
            Assert.fail("Password field interaction failed");
        }

        try {
            // Locate and click the login button
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@index='1']")));
            loginButton.click();
            System.out.println("Clicked on login button.");
        } catch (Exception e) {
            System.out.println("Error while clicking login button: " + e.getMessage());
            Assert.fail("Login button click failed");
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Waited for confirmation of login.");


        try {
            WebElement successMessage = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Find volunteering events\"]"));
            Assert.assertTrue(successMessage.isDisplayed(), "Success message not found!");
            System.out.println("Login successful, Element found.");
        } catch (Exception e) {
            System.out.println("Error while checking for Element: " + e.getMessage());
            Assert.fail("Error while checking for Element: " + e.getMessage());

        }

    }

    @Test
    public void testUserLogin_ValidDetails_Success() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Wait for the email field to be visible and then locate it
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@index='3']")));
            emailField.sendKeys("testuser@example.com");
            System.out.println("Entered email: testuser@example.com");
        } catch (Exception e) {
            System.out.println("Error while entering email: " + e.getMessage());
            Assert.fail("Email field interaction failed");
        }

        try {
            // Locate the password field (with explicit wait)
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@index='5']")));
            passwordField.sendKeys("password123");
            System.out.println("Entered password.");
        } catch (Exception e) {
            System.out.println("Error while entering password: " + e.getMessage());
            Assert.fail("Password field interaction failed");
        }

        try {
            // Locate and click the login button
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@index='1']")));
            loginButton.click();
            System.out.println("Clicked on login button.");
        } catch (Exception e) {
            System.out.println("Error while clicking login button: " + e.getMessage());
            Assert.fail("Login button click failed");
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Waited for confirmation of login.");


        try {
            WebElement successMessage = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Find volunteering events\"]"));
            Assert.assertTrue(successMessage.isDisplayed(), "Success message not found!");
            System.out.println("Login successful, Element found.");
        } catch (Exception e) {
            System.out.println("Error while checking for Element: " + e.getMessage());
            Assert.fail("Error while checking for Element: " + e.getMessage());

        }

    }





}
