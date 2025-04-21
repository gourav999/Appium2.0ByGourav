//Ye code selendroid app launch kar raha hai and its cliccking on element.
//Ye sablse pahla program tho jo maine appium ke site se thoda dekh kar kiya tha, aur gemini ai se.


package com.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class SampleAppiumTest1 {

    private AndroidDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        //Please note down, if you are using appium 1.o you can use desiredcapabilites.
        // but if you are using appium 2.0 you can use options.please see the apidemoappautomation class.Also in appium 1.o the driver initiation was with the bracket now its removed. Its not mendatory like you cant use desiredcapabiltiles with appium 2.0 but better use options.
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "ST5GDM23LB005246"); // Or your device name
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13"); // Or your device OS version
        //if you have to install application everytime, you can use this but if application is already installed and you want to launch you can use below lines of apppakcage and appactivy. Moreover you have to find the apppackage and app activity of your application.
        caps.setCapability(MobileCapabilityType.APP, "C:/Users/gourav.b.jain/Documents/APpium/apk application/selendroid-test-app.apk");
        //caps.setCapability("appPackage", "io.appium.android.apis");
        //caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
        caps.setCapability("startActivityTimeout", 20000); // Increase timeout in milliseconds


        //earlier in appium 1.0 it was "http://127.0.0.1:4723/wd/hub was used but now "http://127.0.0.1:4723/
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps);
        //AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://localhost:47/wd/hub"), caps);
        //AppiumDriver<MobileElement> driver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }

    @Test
    public void sampleTest() throws InterruptedException {
        System.out.println("This is Gourav");
        Thread.sleep(5000);


        driver.findElement(By.id("io.selendroid.testapp:id/showPopupWindowButton")).click();

    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
