/*//For running code we need to open cmd or powershell and need to run appium but
what will happen when you have to run on jenkins there you need to define the appioum runing code in
 code itself.*/

/*here in setInstance method this is code for luanching the appium server.
        set instance will be called by getinstance
        get instance will be called by launchingAppiumserver*/


package com.example.AppiumLaunchViacode;

import ApiInfo.A0_UIAutomator2OptionsGourav;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.testng.annotations.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class AppiumLaunchViaCode4 {
    static AndroidDriver driver;
    static AppiumDriverLocalService server;

    static void setInstance() throws MalformedURLException {
        String jspath = "C:\\Users\\gourav.b.jain\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
        String nodeexepath = "C:\\Program Files\\nodejs\\node.exe";
        String logfilepath = "C:\\Users\\gourav.b.jain\\Documents\\APpium\\appiumPractice\\logfile.txt";
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder
                .withAppiumJS(new File(jspath))
                .usingDriverExecutable(new File(nodeexepath))
                .usingPort((4723))
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withLogFile(new File(logfilepath))
                .withIPAddress("127.0.0.1");
        server = AppiumDriverLocalService.buildService(builder);
    }

    static AppiumDriverLocalService getInstance() {
        if (server == null) {
            try {
                setInstance();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        return server;
    }

    @BeforeClass
    public void beforeclass() {
        System.out.println("this is before class");
    }

    @BeforeTest
    public static void launchingAppiumserver() throws MalformedURLException {
        //Please note this is not java thread. its starting the appium server.
        getInstance().start();

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
            System.out.println("Appium server is closing");
            getInstance().stop();

        }

    }

    @AfterClass
    public void afterclass() {
        System.out.println("This is AfterClass");
    }
}

