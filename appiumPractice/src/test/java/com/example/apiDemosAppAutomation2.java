package com.example;

import ApiInfo.A0_UIAutomator2OptionsGourav;
import com.google.common.collect.ImmutableList;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

//UiAutomator2Options is the new options from Appium 2.0
public class apiDemosAppAutomation2 extends A0_UIAutomator2OptionsGourav {
    static AndroidDriver driver;

    @BeforeClass
    public void beforeclass() {
        System.out.println("this is before class");
    }

    @BeforeTest
    public void setup() throws MalformedURLException {
        System.out.println("this is before test");
        A0_UIAutomator2OptionsGourav options = new A0_UIAutomator2OptionsGourav();
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options.getApiDemosAPKOptions());

    }

    @Test(enabled = false)
    public void sampleTest() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(AppiumBy.xpath(("//android.widget.TextView[@content-desc=\"App\"]"))).click();
        driver.findElement(AppiumBy.xpath(("//android.widget.TextView[@content-desc=\"Activity\"]"))).click();
        driver.findElement(AppiumBy.xpath(("//android.widget.TextView[@content-desc=\"Animation\"]"))).click();

        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();

    }

    @Test(enabled = false)
    public void creationofXpathInVariousWays() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(AppiumBy.xpath(("//android.widget.TextView[@content-desc=\"App\"]"))).click();

        /*//If you see on the appium inspector, here the android:id/text1 is common for all the elements. so i used this as list.
        I am putting image (Image1-List of elements) and json (donwleod from appium inspector) as well for reference//*/
        List<WebElement> alllinks = driver.findElements(AppiumBy.xpath(("//android.widget.TextView[@resource-id=\"android:id/text1\"]")));
        System.out.println("alllinks: " + alllinks.size());
        Assert.assertEquals(14, alllinks.size());
        for (int i = 0; i < alllinks.size(); i++) {
            System.out.println((alllinks.get(i).getText()));
        }

        /*This is correct, the reason its returning 15 like heading is also having same class (total 14 tab+1 heading)
        List<WebElement> alllinksbyClass = driver.findElements(AppiumBy.className("android.widget.TextView"));
        System.out.println("alllinksbyClass: " + alllinksbyClass.size());
        Assert.assertEquals(15, alllinksbyClass.size());
*/
        //Verify Api Demos heading displayed
        String headingTextApiDemos = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"API Demos\")")).getText();
        System.out.println("This is the header text==>" + headingTextApiDemos);
        Assert.assertEquals(headingTextApiDemos, "API Demos", "API Demos heading is not enabled");

        //Verify that Activity tab is displayed, and enabled.
        boolean activityTabeDisplayed = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Activity\")")).isDisplayed();
        Assert.assertTrue(activityTabeDisplayed, "activity tab is not displayed");
        boolean activityTabeEnabled = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Activity\")")).isDisplayed();
        Assert.assertTrue(activityTabeEnabled, "activity tab is not enabled");

        //Get attribute of element
        String textofElement = driver.findElement(AppiumBy.xpath(("//android.widget.TextView[@content-desc=\"Activity\"]"))).getText();
        System.out.println(textofElement);

        //This will also work, see under xpath the \ is removed and updated with single '.
        String textofElement1 = driver.findElement(AppiumBy.xpath(("//android.widget.TextView[@content-desc='Activity']"))).getText();
        System.out.println(textofElement1);

        //since on mobile app, attribute name is not presnet because its not web. so it returns text value.
        String nameOfelement = driver.findElement(AppiumBy.xpath(("//android.widget.TextView[@content-desc=\"Activity\"]"))).getAttribute("name");
        System.out.println(nameOfelement);

        String boundsOfelement = driver.findElement(AppiumBy.xpath(("//android.widget.TextView[@content-desc=\"Activity\"]"))).getAttribute("bounds");
        System.out.println(boundsOfelement);

        String contentdescOfelement = driver.findElement(AppiumBy.xpath(("//android.widget.TextView[@content-desc=\"Activity\"]"))).getAttribute("content-desc");
        System.out.println(contentdescOfelement);


        //Multiple ways of xpath matching/creation
        //Way1->by using xpath given by appium inspector-->driver.findElement(AppiumBy.xpath(("//android.widget.TextView[@content-desc=\"Activity\"]"))).click();
        //Way2->by using index-->driver.findElement(AppiumBy.xpath(("//android.widget.TextView[@index=\"1\"]"))).click();
        //way3->driver.findElement(AppiumBy.xpath(("//*[contains(@text,'Activity')]"))).click();
        //way4->driver.findElement(AppiumBy.xpath(("//android.widget.TextView[@text=\"Activity\"]"))).click();
        //way5->driver.findElement(AppiumBy.xpath(("//android.widget.TextView[@text='Activity']"))).click();
        //way6->driver.findElement(AppiumBy.xpath(("//*[@resource-id='android:id/text1' and @text='Activity']"))).click();
        //way7->driver.findElement(AppiumBy.xpath(("//*[@resource-id='android:id/text1' or @text='Activity']"))).click();
        //This does not work->driver.findElement(AppiumBy.id("Activity")).click();
        //way8->driver.findElement(AppiumBy.accessibilityId("Activity")).click();
        //way9->driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Activity\")")).click();
        //way10->driver.findElement(AppiumBy.xpath(("//*[@package='io.appium.android.apis' and @text='Activity']"))).click()
        //way11->driver.findElement(AppiumBy.xpath(("//*[@class='android.widget.TextView' and @text='Activity']"))).click();
        //this does not work ->or condition-driver.findElement(AppiumBy.xpath(("//*[@class='android.widget.TextView' or @text='Activity']"))).click();
        driver.navigate().back();
    }

    @Test(enabled = false)
    public void readAsset() {
        driver.findElement(AppiumBy.xpath(("//android.widget.TextView[@content-desc=\"Content\"]"))).click();
        driver.findElement(AppiumBy.xpath(("//android.widget.TextView[@content-desc=\"Assets\"]"))).click();
        driver.findElement(AppiumBy.xpath(("//android.widget.TextView[@content-desc=\"Read Asset\"]"))).click();
        String ReadAssetText = driver.findElement(AppiumBy.androidUIAutomator(("new UiSelector().resourceId(\"io.appium.android.apis:id/text\")"))).getText();
        Assert.assertEquals(ReadAssetText, "This text is stored in a raw Asset.\n" + "\n" + "It was read and placed into the TextView here.\n", "Read asset text heading is not enabled");
    }

    @Test(enabled = true)
    public void longpressMethodTakeScreenshotValidateToastMessage() throws InterruptedException, IOException {
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Views\")")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Expandable Lists\")")).click();
        ;
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"1. Custom Adapter\")")).click();

        WebElement dog = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Dog Names\"]"));

        //Long press to the particular element
        longpressToelement(dog);

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Sample action\"]")).click();
         //or driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sample action\")")).click();

        // Capture Screenshot
        System.out.println("Taking screesnhot");
        File srcFile = driver.getScreenshotAs(OutputType.FILE);
        File destFile = new File("screenshots/screenshot.png");
        FileUtils.copyFile(srcFile, destFile);
        System.out.println("Taking line no 152");
        System.out.println("Screenshot saved at: " + destFile.getAbsolutePath());

        // Use an explicit wait with a polling mechanism to detect the toast message
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5), Duration.ofMillis(500));
        WebElement toastMessage = wait.until(driver -> {
            try {
                // Locate the toast message element
                return driver.findElement(AppiumBy.xpath("//android.widget.Toast[@text=\"Dog Names: Group 1 clicked\"]"));
            } catch (Exception e) {
                return null; // Return null to keep polling until timeout
            }
        });

        // Validate the toast message if found
        if (toastMessage != null) {
            String messageText = toastMessage.getText();
            System.out.println("Toast Message: " + messageText);
            if (messageText.equals("Expected Toast Message")) {
                System.out.println("Toast validation passed!");
            } else {
                System.out.println("Toast validation failed! Found: " + messageText);
                Assert.assertEquals(messageText,"Dog Names: Group 1 clicked", "THE TOAST MESSAGE IS NOT CORRECTED");
            }
        } else {
            System.out.println("Toast message not found within the timeout period.");
        }






    }


    public static void longpressToelement(WebElement element){
        //Long press to the element
        Point location = element.getLocation();
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence seq = new Sequence(input, 0);
        seq.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), location.x, location.y));
        seq.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        seq.addAction(input.createPointerMove(Duration.ofSeconds(5), PointerInput.Origin.viewport(), location.x, location.y));
        seq.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(ImmutableList.of(seq));
    }

    @AfterClass
    public void afterclass() {
        System.out.println("This is AfterClass");
    }

    @AfterTest
    public void teardown() {
        System.out.println("This is AfterTest");
        if (driver != null) {
            driver.quit();
            
        }

    }

}


