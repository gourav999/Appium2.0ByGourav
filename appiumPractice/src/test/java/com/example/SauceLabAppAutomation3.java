package com.example;

import ApiInfo.A0_UIAutomator2OptionsGourav;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class SauceLabAppAutomation3 {
    static AndroidDriver driver;

    @BeforeClass
    public void beforeclass() {
        System.out.println("this is before class");
    }

    @BeforeTest
    public void setup() throws MalformedURLException {
        System.out.println("this is before test");
        A0_UIAutomator2OptionsGourav options = new A0_UIAutomator2OptionsGourav();
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options.getSauceLabsAPKOptions());

    }

    @Test(enabled = true)
    public void login_ClickOnMenu_ClickOnAllitems() throws InterruptedException {

        System.out.println("-------------Performing login to the application-----------------");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Username\")")).sendKeys("standard_user");
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Password\")")).sendKeys("secret_sauce");
        driver.findElement(AppiumBy.accessibilityId("test-LOGIN")).click();

        //clicking on main menu
        driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView")).click();
        //all-itmes is not easily visible. you need to go via hirerchy.
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"test-ALL ITEMS\")")).click();


    }


    @AfterTest
    public void teardown() {
        System.out.println("This is AfterTest");
        if (driver != null) {

            driver.quit();
        }

    }

    @AfterClass
    public void afterclass() {
        System.out.println("This is AfterClass");
    }
}
