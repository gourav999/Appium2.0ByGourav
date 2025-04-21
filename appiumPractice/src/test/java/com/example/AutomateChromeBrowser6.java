//many application has webview. so now lets automate the chrome
//First get the chroem browser version.
//download chrome driver version.

package com.example;

import ApiInfo.A0_UIAutomator2OptionsGourav;
import com.google.common.collect.ImmutableList;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

//UiAutomator2Options is the new options from Appium 2.0
public class AutomateChromeBrowser6 extends A0_UIAutomator2OptionsGourav {
    static AndroidDriver driver;

    @BeforeClass
    public void beforeclass() {
        System.out.println("this is before class");
    }

    @BeforeTest
    public void setup() throws MalformedURLException {
        System.out.println("this is before test");
        A0_UIAutomator2OptionsGourav options = new A0_UIAutomator2OptionsGourav();
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options.getChromeBrowserOptions());

    }

    @Test(enabled = true)
    public void openURL() throws InterruptedException {
    driver.get("www.google.com");


    }

    @AfterTest
    public void teardown() {
        System.out.println("This is AfterTest");
        if (driver != null) {

            driver.quit();
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
}


