package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class RegistrationTests extends AppiumBase{
    public RegistrationTests() throws MalformedURLException {
    }

@Test
public void testUserRegistration_ValidDetails_Success() {

    System.out.println("Test started: Register screen");


    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    System.out.println("Waited for app to load.");


    try {
        WebElement createAccountButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Create Account!']"));
        System.out.println("Found 'Create Account' button.");

        // Log if the button is clickable
        if (createAccountButton.isEnabled()) {
            System.out.println("'Create Account' button is enabled.");
            createAccountButton.click();
            System.out.println("Clicked on 'Create Account' button.");
        } else {
            System.out.println("'Create Account' button is NOT enabled.");
        }
    } catch (Exception e) {
        Assert.fail("Error while locating the 'Create Account' button: " + e.getMessage());
    }


    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    System.out.println("Waited for Register screen to load.");


    try {
        WebElement nameField = driver.findElement(By.xpath("//android.widget.EditText[@index='3']"));
        nameField.sendKeys("Test User");
        System.out.println("Entered 'Test User' into the Name field.");
    } catch (Exception e) {
        Assert.fail("Error while entering Name: " + e.getMessage());
    }


    try {
        WebElement emailField = driver.findElement(By.xpath("//android.widget.EditText[@index='5']"));
        emailField.sendKeys("testuser@example.com");
        System.out.println("Entered 'testuser@example.com' into the Email field.");
    } catch (Exception e) {
        Assert.fail("Error while entering Email: " + e.getMessage());
    }


    try {
        WebElement passwordField = driver.findElement(By.xpath("//android.widget.EditText[@index='7']"));
        passwordField.sendKeys("password123");
        System.out.println("Entered 'password123' into the Password field.");
    } catch (Exception e) {
        Assert.fail("Error while entering Password: " + e.getMessage());
    }


    try {
        WebElement repeatPasswordField = driver.findElement(By.xpath("//android.widget.EditText[@index='9']"));
        repeatPasswordField.sendKeys("password123");
        System.out.println("Entered 'password123' into the Repeat Password field.");
    } catch (Exception e) {
        Assert.fail("Error while entering Repeat Password: " + e.getMessage());
    }


    try {
        WebElement registerButton = driver.findElement(By.xpath("//android.widget.FrameLayout//android.widget.TextView[@text='REGISTER']/parent::android.view.View"));
        if (registerButton.isEnabled()) {
            System.out.println("Register button is enabled.");
            registerButton.click();
            System.out.println("Clicked on the Register button.");
        } else {
            System.out.println("Register button is NOT enabled.");
        }
    } catch (Exception e) {
        Assert.fail("Error while clicking the Register button: " + e.getMessage());
    }


    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    System.out.println("Waited for confirmation of registration.");


    try {
        WebElement successMessage = driver.findElement(By.xpath("//android.widget.TextView[@text='Welcome']"));
        Assert.assertNotNull(successMessage, "'Welcome' message not found!");
        System.out.println("Registration successful, 'Welcome' message found.");
    } catch (Exception e) {
        Assert.fail("Error while checking for success message: " + e.getMessage());
    }
}

@Test
public void testUserRegistration_InvalidEmail_ErrorMessage() {

        System.out.println("Test started: Register screen");


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Waited for app to load.");


        try {
            WebElement createAccountButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Create Account!']"));
            System.out.println("Found 'Create Account' button.");

            // Log if the button is clickable
            if (createAccountButton.isEnabled()) {
                System.out.println("'Create Account' button is enabled.");
                createAccountButton.click();
                System.out.println("Clicked on 'Create Account' button.");
            } else {
                System.out.println("'Create Account' button is NOT enabled.");
            }
        } catch (Exception e) {
            Assert.fail("Error while locating the 'Create Account' button: " + e.getMessage());
        }


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Waited for Register screen to load.");


        try {
            WebElement nameField = driver.findElement(By.xpath("//android.widget.EditText[@index='3']"));
            nameField.sendKeys("Test User");
            System.out.println("Entered 'Test User' into the Name field.");
        } catch (Exception e) {
            Assert.fail("Error while entering Name: " + e.getMessage());
        }


        try {
            WebElement emailField = driver.findElement(By.xpath("//android.widget.EditText[@index='5']"));
            emailField.sendKeys("testuser");
            System.out.println("Entered 'testuser' into the Email field.");
        } catch (Exception e) {
            Assert.fail("Error while entering Email: " + e.getMessage());
        }


        try {
            WebElement passwordField = driver.findElement(By.xpath("//android.widget.EditText[@index='7']"));
            passwordField.sendKeys("password123");
            System.out.println("Entered 'password123' into the Password field.");
        } catch (Exception e) {
            Assert.fail("Error while entering Password: " + e.getMessage());
        }


        try {
            WebElement repeatPasswordField = driver.findElement(By.xpath("//android.widget.EditText[@index='9']"));
            repeatPasswordField.sendKeys("password123");
            System.out.println("Entered 'password123' into the Repeat Password field.");
        } catch (Exception e) {
            Assert.fail("Error while entering Repeat Password: " + e.getMessage());
        }


        try {
            WebElement registerButton = driver.findElement(By.xpath("//android.widget.FrameLayout//android.widget.TextView[@text='REGISTER']/parent::android.view.View"));
            if (registerButton.isEnabled()) {
                System.out.println("Register button is enabled.");
                registerButton.click();
                System.out.println("Clicked on the Register button.");
            } else {
                System.out.println("Register button is NOT enabled.");
            }
        } catch (Exception e) {
            Assert.fail("Error while clicking the Register button: " + e.getMessage());
        }


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Waited for confirmation of registration.");


        try {
            WebElement successMessage = driver.findElement(By.xpath("//android.widget.TextView[@text='Welcome']"));
            Assert.assertNotNull(successMessage, "'Welcome' message not found!");
            System.out.println("Registration successful, 'Welcome' message found.");
        } catch (Exception e) {
            Assert.fail("Error while checking for success message: " + e.getMessage());
        }
    }

@Test
public void testUserRegistration_BlankPassword_ErrorMessage() {

        System.out.println("Test started: Register screen");


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Waited for app to load.");


        try {
            WebElement createAccountButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Create Account!']"));
            System.out.println("Found 'Create Account' button.");

            // Log if the button is clickable
            if (createAccountButton.isEnabled()) {
                System.out.println("'Create Account' button is enabled.");
                createAccountButton.click();
                System.out.println("Clicked on 'Create Account' button.");
            } else {
                System.out.println("'Create Account' button is NOT enabled.");
            }
        } catch (Exception e) {
            Assert.fail("Error while locating the 'Create Account' button: " + e.getMessage());
        }


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Waited for Register screen to load.");


        try {
            WebElement nameField = driver.findElement(By.xpath("//android.widget.EditText[@index='3']"));
            nameField.sendKeys("Test User");
            System.out.println("Entered 'Test User' into the Name field.");
        } catch (Exception e) {
            Assert.fail("Error while entering Name: " + e.getMessage());
        }


        try {
            WebElement emailField = driver.findElement(By.xpath("//android.widget.EditText[@index='5']"));
            emailField.sendKeys("testuser@example.com");
            System.out.println("Entered 'testuser@example.com' into the Email field.");
        } catch (Exception e) {
            Assert.fail("Error while entering Email: " + e.getMessage());
        }


        try {
            WebElement passwordField = driver.findElement(By.xpath("//android.widget.EditText[@index='7']"));
            passwordField.sendKeys("");
            System.out.println("Entered '' into the Password field.");
        } catch (Exception e) {
            Assert.fail("Error while entering Password: " + e.getMessage());
        }


        try {
            WebElement repeatPasswordField = driver.findElement(By.xpath("//android.widget.EditText[@index='9']"));
            repeatPasswordField.sendKeys("password123");
            System.out.println("Entered 'password123' into the Repeat Password field.");
        } catch (Exception e) {
            Assert.fail("Error while entering Repeat Password: " + e.getMessage());
        }


        try {
            WebElement registerButton = driver.findElement(By.xpath("//android.widget.FrameLayout//android.widget.TextView[@text='REGISTER']/parent::android.view.View"));
            if (registerButton.isEnabled()) {
                System.out.println("Register button is enabled.");
                registerButton.click();
                System.out.println("Clicked on the Register button.");
            } else {
                System.out.println("Register button is NOT enabled.");
            }
        } catch (Exception e) {
            Assert.fail("Error while clicking the Register button: " + e.getMessage());
        }


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Waited for confirmation of registration.");


        try {
            WebElement successMessage = driver.findElement(By.xpath("//android.widget.TextView[@text='Welcome']"));
            Assert.assertNotNull(successMessage, "'Welcome' message not found!");
            System.out.println("Registration successful, 'Welcome' message found.");
        } catch (Exception e) {
            Assert.fail("Error while checking for success message: " + e.getMessage());
        }
    }

@Test
public void testUserRegistration_PasswordMismatch_ErrorMessage() {

        System.out.println("Test started: Register screen");


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Waited for app to load.");


        try {
            WebElement createAccountButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Create Account!']"));
            System.out.println("Found 'Create Account' button.");

            // Log if the button is clickable
            if (createAccountButton.isEnabled()) {
                System.out.println("'Create Account' button is enabled.");
                createAccountButton.click();
                System.out.println("Clicked on 'Create Account' button.");
            } else {
                System.out.println("'Create Account' button is NOT enabled.");
            }
        } catch (Exception e) {
            Assert.fail("Error while locating the 'Create Account' button: " + e.getMessage());
        }


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Waited for Register screen to load.");


        try {
            WebElement nameField = driver.findElement(By.xpath("//android.widget.EditText[@index='3']"));
            nameField.sendKeys("Test User");
            System.out.println("Entered 'Test User' into the Name field.");
        } catch (Exception e) {
            Assert.fail("Error while entering Name: " + e.getMessage());
        }


        try {
            WebElement emailField = driver.findElement(By.xpath("//android.widget.EditText[@index='5']"));
            emailField.sendKeys("testuser@example.com");
            System.out.println("Entered 'testuser@example.com' into the Email field.");
        } catch (Exception e) {
            Assert.fail("Error while entering Email: " + e.getMessage());
        }


        try {
            WebElement passwordField = driver.findElement(By.xpath("//android.widget.EditText[@index='7']"));
            passwordField.sendKeys("password123");
            System.out.println("Entered 'password123' into the Password field.");
        } catch (Exception e) {
            Assert.fail("Error while entering Password: " + e.getMessage());
        }


        try {
            WebElement repeatPasswordField = driver.findElement(By.xpath("//android.widget.EditText[@index='9']"));
            repeatPasswordField.sendKeys("password321");
            System.out.println("Entered 'password321' into the Repeat Password field.");
        } catch (Exception e) {
            Assert.fail("Error while entering Repeat Password: " + e.getMessage());
        }


        try {
            WebElement registerButton = driver.findElement(By.xpath("//android.widget.FrameLayout//android.widget.TextView[@text='REGISTER']/parent::android.view.View"));
            if (registerButton.isEnabled()) {
                System.out.println("Register button is enabled.");
                registerButton.click();
                System.out.println("Clicked on the Register button.");
            } else {
                System.out.println("Register button is NOT enabled.");
            }
        } catch (Exception e) {
            Assert.fail("Error while clicking the Register button: " + e.getMessage());
        }


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Waited for confirmation of registration.");


        try {
            WebElement successMessage = driver.findElement(By.xpath("//android.widget.TextView[@text='Welcome']"));
            Assert.assertNotNull(successMessage, "'Welcome' message not found!");
            System.out.println("Registration successful, 'Welcome' message found.");
        } catch (Exception e) {
            Assert.fail("Error while checking for success message: " + e.getMessage());
        }
    }

@Test
public void testOrganizationRegistration_ValidDetails_Success() {

        System.out.println("Test started: Register screen");


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Waited for app to load.");


        try {
            WebElement createAccountButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Create Account!']"));

            System.out.println("Found 'Create Account' button.");

            // Log if the button is clickable
            if (createAccountButton.isEnabled()) {
                System.out.println("'Create Account' button is enabled.");
                createAccountButton.click();
                System.out.println("Clicked on 'Create Account' button.");
            } else {
                System.out.println("'Create Account' button is NOT enabled.");
            }
        } catch (Exception e) {
            System.out.println("Error while locating the 'Create Account' button: " + e.getMessage());
            Assert.fail("Error while locating the 'Create Account' button: " + e.getMessage());
        }


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Waited for Register screen to load.");


        try {
            WebElement nameField = driver.findElement(By.xpath("//android.widget.EditText[@index='3']"));
            nameField.sendKeys("Test Organization");
            System.out.println("Entered 'Test Organization' into the Name field.");
        } catch (Exception e) {
            System.out.println("Error while entering Name: " + e.getMessage());
            Assert.fail("Error while entering Name: " + e.getMessage());
        }


        try {
            WebElement emailField = driver.findElement(By.xpath("//android.widget.EditText[@index='5']"));
            emailField.sendKeys("testorganization3@example.com");
            System.out.println("Entered 'testorganization2@example.com' into the Email field.");
        } catch (Exception e) {
            System.out.println("Error while entering Email: " + e.getMessage());
            Assert.fail("Error while entering Email: " + e.getMessage());
        }


        try {
            WebElement passwordField = driver.findElement(By.xpath("//android.widget.EditText[@index='7']"));
            passwordField.sendKeys("password123");
            System.out.println("Entered 'password123' into the Password field.");
        } catch (Exception e) {
            System.out.println("Error while entering Password: " + e.getMessage());
            Assert.fail("Error while entering Password: " + e.getMessage());
        }


        try {
            WebElement repeatPasswordField = driver.findElement(By.xpath("//android.widget.EditText[@index='9']"));
            repeatPasswordField.sendKeys("password123");
            System.out.println("Entered 'password123' into the Repeat Password field.");
        } catch (Exception e) {
            System.out.println("Error while entering Repeat Password: " + e.getMessage());
            Assert.fail("Error while entering Repeat Password: " + e.getMessage());

        }

        try {
            // Locate the checkbox using XPath
            WebElement checkbox = driver.findElement(By.xpath("//android.widget.CheckBox[@package='org.volonter.helpinghand' and @index='10']"));

            // Check if the checkbox is already checked
            if (!checkbox.isSelected()) {
                // If it's not checked, click it to check the box
                checkbox.click();
                System.out.println("Checkbox was unchecked, now checked.");
            } else {
                // If it's already checked
                System.out.println("Checkbox is already checked.");
            }
        } catch (Exception e) {
            System.out.println("Error while interacting with the checkbox: " + e.getMessage());
            Assert.fail("Error while interacting with the checkbox: " + e.getMessage());

        }



        try {
            // WebElement registerButton = driver.findElement(By.xpath("//android.widget.Button[@text='REGISTER']"));

            WebElement registerButton = driver.findElement(By.xpath("//android.widget.FrameLayout//android.widget.TextView[@text='REGISTER']/parent::android.view.View"));
            if (registerButton.isEnabled()) {
                System.out.println("Register button is enabled.");
                registerButton.click();
                System.out.println("Clicked on the Register button.");
            } else {
                System.out.println("Register button is NOT enabled.");
            }
        } catch (Exception e) {
            System.out.println("Error while clicking the Register button: " + e.getMessage());
            Assert.fail("Error while clicking the Register button: " + e.getMessage());
        }


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Waited for confirmation of registration.");


        try {
            WebElement successMessage = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Find volunteering events\"]"));
            Assert.assertTrue(successMessage.isDisplayed(), "Success message not found!");
            System.out.println("Registration successful, Element found.");
        } catch (Exception e) {
            System.out.println("Error while checking for Element: " + e.getMessage());
            Assert.fail("Error while checking for Element: " + e.getMessage());

        }
    }

@Test
public void testOrganizationRegistration_InvalidEmail_ErrorMessage() {

        System.out.println("Test started: Register screen");


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Waited for app to load.");


        try {
            WebElement createAccountButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Create Account!']"));

            System.out.println("Found 'Create Account' button.");

            // Log if the button is clickable
            if (createAccountButton.isEnabled()) {
                System.out.println("'Create Account' button is enabled.");
                createAccountButton.click();
                System.out.println("Clicked on 'Create Account' button.");
            } else {
                System.out.println("'Create Account' button is NOT enabled.");
            }
        } catch (Exception e) {
            System.out.println("Error while locating the 'Create Account' button: " + e.getMessage());
            Assert.fail("Error while locating the 'Create Account' button: " + e.getMessage());
        }


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Waited for Register screen to load.");


        try {
            WebElement nameField = driver.findElement(By.xpath("//android.widget.EditText[@index='3']"));
            nameField.sendKeys("Test Organization");
            System.out.println("Entered 'Test Organization' into the Name field.");
        } catch (Exception e) {
            System.out.println("Error while entering Name: " + e.getMessage());
            Assert.fail("Error while entering Name: " + e.getMessage());
        }


        try {
            WebElement emailField = driver.findElement(By.xpath("//android.widget.EditText[@index='5']"));
            emailField.sendKeys("testorganization3");
            System.out.println("Entered 'testorganization2@example.com' into the Email field.");
        } catch (Exception e) {
            System.out.println("Error while entering Email: " + e.getMessage());
            Assert.fail("Error while entering Email: " + e.getMessage());
        }


        try {
            WebElement passwordField = driver.findElement(By.xpath("//android.widget.EditText[@index='7']"));
            passwordField.sendKeys("password123");
            System.out.println("Entered 'password123' into the Password field.");
        } catch (Exception e) {
            System.out.println("Error while entering Password: " + e.getMessage());
            Assert.fail("Error while entering Password: " + e.getMessage());
        }


        try {
            WebElement repeatPasswordField = driver.findElement(By.xpath("//android.widget.EditText[@index='9']"));
            repeatPasswordField.sendKeys("password123");
            System.out.println("Entered 'password123' into the Repeat Password field.");
        } catch (Exception e) {
            System.out.println("Error while entering Repeat Password: " + e.getMessage());
            Assert.fail("Error while entering Repeat Password: " + e.getMessage());

        }

        try {
            // Locate the checkbox using XPath
            WebElement checkbox = driver.findElement(By.xpath("//android.widget.CheckBox[@package='org.volonter.helpinghand' and @index='10']"));

            // Check if the checkbox is already checked
            if (!checkbox.isSelected()) {
                // If it's not checked, click it to check the box
                checkbox.click();
                System.out.println("Checkbox was unchecked, now checked.");
            } else {
                // If it's already checked
                System.out.println("Checkbox is already checked.");
            }
        } catch (Exception e) {
            System.out.println("Error while interacting with the checkbox: " + e.getMessage());
            Assert.fail("Error while interacting with the checkbox: " + e.getMessage());

        }



        try {
            // WebElement registerButton = driver.findElement(By.xpath("//android.widget.Button[@text='REGISTER']"));

            WebElement registerButton = driver.findElement(By.xpath("//android.widget.FrameLayout//android.widget.TextView[@text='REGISTER']/parent::android.view.View"));
            if (registerButton.isEnabled()) {
                System.out.println("Register button is enabled.");
                registerButton.click();
                System.out.println("Clicked on the Register button.");
            } else {
                System.out.println("Register button is NOT enabled.");
            }
        } catch (Exception e) {
            System.out.println("Error while clicking the Register button: " + e.getMessage());
            Assert.fail("Error while clicking the Register button: " + e.getMessage());
        }


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Waited for confirmation of registration.");


        try {
            WebElement successMessage = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Find volunteering events\"]"));
            Assert.assertTrue(successMessage.isDisplayed(), "Success message not found!");
            System.out.println("Registration successful, Element found.");
        } catch (Exception e) {
            System.out.println("Error while checking for Element: " + e.getMessage());
            Assert.fail("Error while checking for Element: " + e.getMessage());

        }
    }

@Test
public void testOrganizationRegistration_BlankFields_ErrorMessage() {

        System.out.println("Test started: Register screen");


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Waited for app to load.");


        try {
            WebElement createAccountButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Create Account!']"));

            System.out.println("Found 'Create Account' button.");

            // Log if the button is clickable
            if (createAccountButton.isEnabled()) {
                System.out.println("'Create Account' button is enabled.");
                createAccountButton.click();
                System.out.println("Clicked on 'Create Account' button.");
            } else {
                System.out.println("'Create Account' button is NOT enabled.");
            }
        } catch (Exception e) {
            System.out.println("Error while locating the 'Create Account' button: " + e.getMessage());
            Assert.fail("Error while locating the 'Create Account' button: " + e.getMessage());
        }


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Waited for Register screen to load.");


        try {
            WebElement nameField = driver.findElement(By.xpath("//android.widget.EditText[@index='3']"));
            nameField.sendKeys("Test Organization");
            System.out.println("Entered 'Test Organization' into the Name field.");
        } catch (Exception e) {
            System.out.println("Error while entering Name: " + e.getMessage());
            Assert.fail("Error while entering Name: " + e.getMessage());
        }


        try {
            WebElement emailField = driver.findElement(By.xpath("//android.widget.EditText[@index='5']"));
            emailField.sendKeys("testorganization3@example.com");
            System.out.println("Entered 'testorganization2@example.com' into the Email field.");
        } catch (Exception e) {
            System.out.println("Error while entering Email: " + e.getMessage());
            Assert.fail("Error while entering Email: " + e.getMessage());
        }


        try {
            WebElement passwordField = driver.findElement(By.xpath("//android.widget.EditText[@index='7']"));
            passwordField.sendKeys("password123");
            System.out.println("Entered 'password123' into the Password field.");
        } catch (Exception e) {
            System.out.println("Error while entering Password: " + e.getMessage());
            Assert.fail("Error while entering Password: " + e.getMessage());
        }


        try {
            WebElement repeatPasswordField = driver.findElement(By.xpath("//android.widget.EditText[@index='9']"));
            repeatPasswordField.sendKeys("");
            System.out.println("Entered 'password123' into the Repeat Password field.");
        } catch (Exception e) {
            System.out.println("Error while entering Repeat Password: " + e.getMessage());
            Assert.fail("Error while entering Repeat Password: " + e.getMessage());

        }

        try {
            // Locate the checkbox using XPath
            WebElement checkbox = driver.findElement(By.xpath("//android.widget.CheckBox[@package='org.volonter.helpinghand' and @index='10']"));

            // Check if the checkbox is already checked
            if (!checkbox.isSelected()) {
                // If it's not checked, click it to check the box
                checkbox.click();
                System.out.println("Checkbox was unchecked, now checked.");
            } else {
                // If it's already checked
                System.out.println("Checkbox is already checked.");
            }
        } catch (Exception e) {
            System.out.println("Error while interacting with the checkbox: " + e.getMessage());
            Assert.fail("Error while interacting with the checkbox: " + e.getMessage());

        }



        try {
            // WebElement registerButton = driver.findElement(By.xpath("//android.widget.Button[@text='REGISTER']"));

            WebElement registerButton = driver.findElement(By.xpath("//android.widget.FrameLayout//android.widget.TextView[@text='REGISTER']/parent::android.view.View"));
            if (registerButton.isEnabled()) {
                System.out.println("Register button is enabled.");
                registerButton.click();
                System.out.println("Clicked on the Register button.");
            } else {
                System.out.println("Register button is NOT enabled.");
            }
        } catch (Exception e) {
            System.out.println("Error while clicking the Register button: " + e.getMessage());
            Assert.fail("Error while clicking the Register button: " + e.getMessage());
        }


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Waited for confirmation of registration.");


        try {
            WebElement successMessage = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Find volunteering events\"]"));
            Assert.assertTrue(successMessage.isDisplayed(), "Success message not found!");
            System.out.println("Registration successful, Element found.");
        } catch (Exception e) {
            System.out.println("Error while checking for Element: " + e.getMessage());
            Assert.fail("Error while checking for Element: " + e.getMessage());

        }
    }




}
