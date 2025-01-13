package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
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
import static org.testng.AssertJUnit.assertTrue;

public class EventTests extends AppiumBase{
    public EventTests() throws MalformedURLException {
    }

    @Test
    public  void testAddEvent_EmptyTitle_ErrorMessage(){
        try{
            driver.findElement(AppiumBy.className("android.widget.Button")).click();
        }
        catch (Exception e) {
            Assert.fail("Error while locating the 'Add new event' button: " + e.getMessage());
        }
        try{
          WebElement imageLink =  driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));
                  imageLink.sendKeys("blank");

            System.out.println("Changed image link");
        }
        catch (Exception e) {
            Assert.fail("Error while locating the 'Image link " + e.getMessage());
        }
        try{
           WebElement eventTitle= driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"));
                    eventTitle.sendKeys("");

            System.out.println("Empty title");
        }
        catch (Exception e) {
            Assert.fail("Error while locating the 'Title " + e.getMessage());
        }

        try{
           WebElement volonteers = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(2)"));
            volonteers.sendKeys("10");

            System.out.println("Changed volonteers needed");
        }
        catch (Exception e) {
            Assert.fail("Error while locating the 'Needed volonteers" + e.getMessage());
        }


        try{
            WebElement phoneField = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(5)"));
            phoneField.click();
            phoneField.sendKeys("091091091");

            System.out.println("Changed phone field");
        }
        catch (Exception e) {
            Assert.fail("Error while locating the 'phone field" + e.getMessage());
        }
        try{
            driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]"))
                    .click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"18\")")).click();
            System.out.println("Picked date");
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

            driver.findElement(AppiumBy.xpath("//android.widget.Button")).click();
            System.out.println("Exited calendar widget");
            System.out.println("Changed date");
        }
        catch (Exception e) {
            Assert.fail("Error while locating the 'date' " + e.getMessage());
        }

        try{
            WebElement address= driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiSelector().className(\"android.widget.EditText\").instance(3)"));
            address.sendKeys("Gunduliceva ulica");

            System.out.println("Changed keys sent");
        }
        catch (Exception e) {
            Assert.fail("Error while locating the 'address" + e.getMessage());
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try{
            WebElement addressChoice= driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"Gundulićeva ulica, Zagreb, Hrvatska\")"));
            addressChoice.click();

            System.out.println("Changed address");
        }
        catch (Exception e) {
            Assert.fail("Error while locating the 'address" + e.getMessage());
        }

        try{
            WebElement description = driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/" +
                    "android.view.View/android.view.View/android.view.View/android.widget.EditText[7]"));
            description.click();
            description.sendKeys("Neki opis");

            System.out.println("Changed description field");
        }
        catch (Exception e) {
            Assert.fail("Error while locating the 'description field" + e.getMessage());
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        try {
            driver.navigate().back();
            System.out.println("Navigated back");
        }
        catch (Exception e){

            Assert.fail("Cant find back");
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(1)"
        ));



        try{
            WebElement postButton = driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/" +
                    "android.view.View/android.view.View/android.view.View/android.view.View[3]/android.widget.Button"));
            postButton.click();


            System.out.println("Post button clicked");
        }
        catch (Exception e) {
            Assert.fail("Error while locating the post button " + e.getMessage());
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // XPath to locate toast message
        WebElement toastMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.xpath("//android.widget.Toast[@text='Event successfully created']")
        ));

        // Validate the toast message content
        String toastText = toastMessage.getText();
        assertEquals("Event successfully created", toastText);


    }

    @Test
    public  void testAddEvent_InvalidVolunteerNumber_ErrorMessage(){
        try{
            driver.findElement(AppiumBy.className("android.widget.Button")).click();
        }
        catch (Exception e) {
            Assert.fail("Error while locating the 'Add new event' button: " + e.getMessage());
        }
        try{
            WebElement imageLink =  driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));
            imageLink.sendKeys("blank");

            System.out.println("Changed image link");
        }
        catch (Exception e) {
            Assert.fail("Error while locating the 'Image link " + e.getMessage());
        }
        try{
            WebElement eventTitle= driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"));
            eventTitle.sendKeys("Sakupljanje smeća");

            System.out.println("Changed event title");
        }
        catch (Exception e) {
            Assert.fail("Error while locating the 'Title" + e.getMessage());
        }

        try{
            WebElement volonteers = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(2)"));
            volonteers.sendKeys("");

            System.out.println("Changed volonteers needed");
        }
        catch (Exception e) {
            Assert.fail("Error while locating the 'Needed volonteers" + e.getMessage());
        }


        try{
            WebElement phoneField = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(5)"));
            phoneField.click();
            phoneField.sendKeys("091091091");

            System.out.println("Changed phone field");
        }
        catch (Exception e) {
            Assert.fail("Error while locating the 'phone field" + e.getMessage());
        }
        try{
            driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]"))
                    .click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"18\")")).click();
            System.out.println("Picked date");
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

            driver.findElement(AppiumBy.xpath("//android.widget.Button")).click();
            System.out.println("Exited calendar widget");
            System.out.println("Changed date");
        }
        catch (Exception e) {
            Assert.fail("Error while locating the 'date' " + e.getMessage());
        }

        try{
            WebElement address= driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiSelector().className(\"android.widget.EditText\").instance(3)"));
            address.sendKeys("Gunduliceva ulica");

            System.out.println("Changed keys sent");
        }
        catch (Exception e) {
            Assert.fail("Error while locating the 'address" + e.getMessage());
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try{
            WebElement addressChoice= driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"Gundulićeva ulica, Zagreb, Hrvatska\")"));
            addressChoice.click();

            System.out.println("Changed address");
        }
        catch (Exception e) {
            Assert.fail("Error while locating the 'address" + e.getMessage());
        }

        try{
            WebElement description = driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/" +
                    "android.view.View/android.view.View/android.view.View/android.widget.EditText[7]"));
            description.click();
            description.sendKeys("Neki opis");

            System.out.println("Changed description field");
        }
        catch (Exception e) {
            Assert.fail("Error while locating the 'description field" + e.getMessage());
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        try {
            driver.navigate().back();
            System.out.println("Navigated back");
        }
        catch (Exception e){

            Assert.fail("Cant find back");
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(1)"
        ));



        try{
            WebElement postButton = driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/" +
                    "android.view.View/android.view.View/android.view.View/android.view.View[3]/android.widget.Button"));
            postButton.click();


            System.out.println("Post button clicked");
        }
        catch (Exception e) {
            Assert.fail("Error while locating the post button " + e.getMessage());
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // XPath to locate toast message
        WebElement toastMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.xpath("//android.widget.Toast[@text='Event successfully created']")
        ));

        // Validate the toast message content
        String toastText = toastMessage.getText();
        assertEquals("Event successfully created", toastText);


    }

    @Test
    public  void testAddEvent_ClickPostButton_FormSubmitted(){
        try{
            driver.findElement(AppiumBy.className("android.widget.Button")).click();
        }
        catch (Exception e) {
            Assert.fail("Error while locating the 'Add new event' button: " + e.getMessage());
        }
        try{
            WebElement imageLink =  driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));
            imageLink.sendKeys("blank");

            System.out.println("Changed image link");
        }
        catch (Exception e) {
            Assert.fail("Error while locating the 'Image link " + e.getMessage());
        }
        try{
            WebElement eventTitle= driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"));
            eventTitle.sendKeys("Sakupljanje smeća");

            System.out.println("Changed event title");
        }
        catch (Exception e) {
            Assert.fail("Error while locating the 'Title" + e.getMessage());
        }

        try{
            WebElement volonteers = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(2)"));
            volonteers.sendKeys("1");

            System.out.println("Changed volonteers needed");
        }
        catch (Exception e) {
            Assert.fail("Error while locating the 'Needed volonteers" + e.getMessage());
        }


        try{
            WebElement phoneField = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(5)"));
            phoneField.click();
            phoneField.sendKeys("091091091");

            System.out.println("Changed phone field");
        }
        catch (Exception e) {
            Assert.fail("Error while locating the 'phone field" + e.getMessage());
        }
        try{
            driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]"))
                    .click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"18\")")).click();
            System.out.println("Picked date");
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

            driver.findElement(AppiumBy.xpath("//android.widget.Button")).click();
            System.out.println("Exited calendar widget");
            System.out.println("Changed date");
        }
        catch (Exception e) {
            Assert.fail("Error while locating the 'date' " + e.getMessage());
        }

        try{
            WebElement address= driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiSelector().className(\"android.widget.EditText\").instance(3)"));
            address.sendKeys("Gunduliceva ulica");

            System.out.println("Changed keys sent");
        }
        catch (Exception e) {
            Assert.fail("Error while locating the 'address" + e.getMessage());
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        try{
            WebElement addressChoice= driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"Gundulićeva ulica, Zagreb, Hrvatska\")"));
            addressChoice.click();

            System.out.println("Changed address");
        }
        catch (Exception e) {
            Assert.fail("Error while locating the 'address" + e.getMessage());
        }

        try{
            WebElement description = driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/" +
                    "android.view.View/android.view.View/android.view.View/android.widget.EditText[7]"));
            description.click();
            description.sendKeys("Neki opis");

            System.out.println("Changed description field");
        }
        catch (Exception e) {
            Assert.fail("Error while locating the 'description field" + e.getMessage());
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        try {
            driver.navigate().back();
            System.out.println("Navigated back");
        }
        catch (Exception e){

            Assert.fail("Cant find back");
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(1)"
        ));



        try{
            WebElement postButton = driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/" +
                    "android.view.View/android.view.View/android.view.View/android.view.View[3]/android.widget.Button"));
            postButton.click();


            System.out.println("Post button clicked");
        }
        catch (Exception e) {
            Assert.fail("Error while locating the post button " + e.getMessage());
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // XPath to locate toast message
        WebElement toastMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.xpath("//android.widget.Toast[@text='Event successfully created']")
        ));

        // Validate the toast message content
        String toastText = toastMessage.getText();
        assertEquals("Event successfully created", toastText);

    }

    @Test
    public  void testAddEvent_ClickCancelButton_FormCleared() {
        try {
            driver.findElement(AppiumBy.className("android.widget.Button")).click();
            System.out.println("Add new event button clicked");
        } catch (Exception e) {
            Assert.fail("Error while locating the 'Add new event' button: " + e.getMessage());
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        try{
            WebElement eventTitle= driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"));
            eventTitle.sendKeys("Sakupljanje smeća");

            System.out.println("Changed event title");
        }
        catch (Exception e) {
            Assert.fail("Error while locating the 'Title" + e.getMessage());
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);



        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(1)"
        ));

        try {
            driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button")).click();
        System.out.println("Cancel button clicked");
        } catch (Exception e) {
            Assert.fail("Error while locating the 'cancel' button: " + e.getMessage());
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        try {
            driver.findElement(AppiumBy.className("android.widget.Button")).click();
        } catch (Exception e) {
            Assert.fail("Error while locating the 'Add new event' button: " + e.getMessage());
        }

        WebElement eventTitle= driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"));

// Check if the text is empty
        String text = eventTitle.getText();
        assertTrue("The EditText is not empty!", text.isEmpty());



    }

    @Test
    public void testApplyForEvent_Success(){

        try {
            WebElement findEventsButton= driver.findElement(By.xpath("//android.widget.TextView[@index='1']"));
            findEventsButton.click();

            System.out.println("Button clicked");
        }
        catch (Exception e){
            Assert.fail("Button couldn't be clicked" );
        }

        try {
            driver.findElement(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]")).click();
        }
        catch (Exception e){
            Assert.fail("Couldn't click event");
        }
        try {
            WebElement applyButton= driver.findElement(By.xpath("//android.widget.Button[@index='1']"));
            applyButton.click();
        }
        catch (Exception e){
            Assert.fail("Couldn't click apply");
        }

        WebElement applyTextView= driver.findElement(By.xpath("//android.widget.TextView[@index='0']"));
        // Validate the toast message content

        String buttonText = applyTextView.getText();
        assertEquals("UNDO APPLY", buttonText);

    }

    @Test
    public void testReachEventList(){
        try {
            WebElement findEventsButton= driver.findElement(By.xpath("//android.widget.TextView[@index='1']"));
            findEventsButton.click();

            System.out.println("Event List reached");
        }
        catch (Exception e){
            Assert.fail("Couldn't reach event list" );
        }
    }

    @Test
    public void testPickEventFromList(){
        try {
            WebElement findEventsButton= driver.findElement(By.xpath("//android.widget.TextView[@index='1']"));
            findEventsButton.click();

            System.out.println("Button clicked");
        }
        catch (Exception e){
            Assert.fail("Button couldn't be clicked" );
        }

        try {
            driver.findElement(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]")).click();
        }
        catch (Exception e){
            Assert.fail("Couldn't click event");
        }
    }

    @Test
    public void testWriteReview_ValidData_Success(){
        testReachEventList();
        try{
            driver.findElement(AppiumBy.className("android.widget.Button")).click();
        }
        catch (Exception e) {
            Assert.fail("Error while locating the 'Add review button" + e.getMessage());
        }

        try{
            WebElement commentTitle= driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"));
            commentTitle.sendKeys("super Sve");

            System.out.println("Changed comment title");
        }
        catch (Exception e) {
            Assert.fail("Error while locating the 'Title" + e.getMessage());
        }

        try{
            WebElement commentText= driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"));
            commentText.sendKeys("Jako je bilo dobro, preporuke.");

            System.out.println("Changed comment text");
        }
        catch (Exception e) {
            Assert.fail("Error while locating the 'text" + e.getMessage());
        }


    }

}
