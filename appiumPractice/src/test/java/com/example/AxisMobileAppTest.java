//package com.example;
//
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.remote.MobileCapabilityType;
//import org.openqa.selenium.By;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//
//public class AxisMobileAppTest {
//
//    private AndroidDriver driver;
//
//    @BeforeClass
//    public void setup() throws MalformedURLException {
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "ST5GDM23LB005246"); // Or your device name
//        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13"); // Or your device OS version
//        //caps.setCapability(appPackage, "C:/Users/gourav.b.jain/Documents/APpium/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
//        caps.setCapability("appPackage", "com.axis.mobile");
//        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
//
////        caps.setCapability("appPackage", "com.swaglabsmobileapp");
////        caps.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity"); // Update if needed
////        caps.setCapability("appActivity", "com.swaglabsmobileapp.LoginActivity");
////        caps.setCapability("appWaitActivity", "com.swaglabsmobileapp.MainActivity"); // Adjust timeout if needed
//        caps.setCapability("startActivityTimeout", 20000); // Increase timeout in milliseconds
//
//
//
//        //driver = new AndroidDriver(new URL("http://192.168.1.4:4723/"), caps);
//        //driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
//         driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps);
//        // driver=new AppiumDriver(new URL("http://127.0.0.1:4723/"), caps);
//        //AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://localhost:47/wd/hub"), caps);
//        //AppiumDriver<MobileElement> driver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
//    }
//
//    @Test
//    public void sampleTest() throws InterruptedException {
//        System.out.println("This is Gourav");
//        Thread.sleep(5000);
//        driver.findElement(By.xpath("")).click();
//
//
////
////        driver.findElement(By.xpath("[@content-desc=\"test-Username\"]")).click();
////
////        driver.findElement(By.xpath("[@content-desc=\"test-Username\"]")).sendKeys("standard_user");
////        driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]")).sendKeys("secret_sauce");
//
//        //this is for selenidrodi app- driver.findElement(By.id("io.selendroid.testapp:id/showPopupWindowButton")).click();
//        //This will show all the packages name of device: adb shell pm list packages
//        //Any aplication will have that allow/not allow pop up on launching the application, so what we will get the package and we will put in adb for allow.
//
//        // Add your test logic here, interacting with app elements using driver methods
//        // Example: click a button by its ID
//        //driver.findElementById("com.example.app:id/button1").click();
//    }
//
//    @AfterClass
//    public void teardown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}
