/*//For running code we need to open cmd or powershell and need to run appium but
what will happen when you have to run on jenkins there you need to define the appioum runing code in
 code itself.*/

/*here in setInstance method this is code for luanching the appium server.
        set instance will be called by getinstance
        get instance will be called by launchingAppiumserver*/


package com.example.AppiumLaunchViacode;

import ApiInfo.A0_UIAutomator2OptionsGourav;
import com.google.common.collect.ImmutableList;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;


public class SwipeFunctionality5 {
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
        //Please note down: same like other classes, here the app is already installed and we are not isintallinga app again because this app is little problamatic, when we try to install this we get pop up like this app has some problem do you want to continue.
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options.gewebDriverApplicationAPKOptions());

    }

    @Test(enabled = false)
    public void swipe() throws InterruptedException {

        System.out.println("-------------Clicking on swipe and swipting right to left-----------------");
        WebElement ele = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Swipe\")"));
        boolean activityTabeEnabled = ele.isDisplayed();
        Assert.assertTrue(activityTabeEnabled, "Swipe should be enabled and displayed");
        if (activityTabeEnabled != false) {
            ele.click();
        }

        scroll("RIGHT",0.5);
        Thread.sleep(5000);
        scroll("RIGHT",0.8);
        Thread.sleep(5000);
        scroll("LEFT",0.5);
        Thread.sleep(5000);
        scroll("DOWN",0.8);
        Thread.sleep(5000);
        scroll("UP",0.8);
        Thread.sleep(5000);
    }

    public static void scroll(String pagedirection, double scrollRatio) {

        Duration SCROLL_DUR = Duration.ofMillis(300);
        if (scrollRatio < 0 || scrollRatio > 1) {
            throw new Error("sroll distance must be between 0 and 1");
        }

        Dimension size = driver.manage().window().getSize();
        System.out.println("this is screen size==>" + size);
        
        Point midPoint= new Point ((int)(size.width * 0.5),(int) (size.height*0.5));
         int a=(int)(midPoint.x * scrollRatio);
        int b=(int)(midPoint.y * scrollRatio);

        int bottom=midPoint.y+(int)(midPoint.y* scrollRatio); //B- screenshot main dekhna
        int top=midPoint.y-(int)(midPoint.y* scrollRatio);  //A
        int left=midPoint.x-(int)(midPoint.x* scrollRatio); //M
        int right=midPoint.x+(int)(midPoint.x* scrollRatio); //N

        System.out.println("midpint"+midPoint);
        System.out.println("midpint"+midPoint.x);
        System.out.println(a);
        System.out.println("midpint"+midPoint.y);
        System.out.println(b);
        System.out.println(bottom);
        System.out.println(top);
        System.out.println(left);
        System.out.println(right);
        if(pagedirection=="UP")
        {
            //swipe top to bottom, page to will go up.
            swipe(new Point(midPoint.x, top),new Point(midPoint.x,bottom),SCROLL_DUR);

        } else if (pagedirection=="DOWN") {
            swipe(new Point(midPoint.x, bottom),new Point(midPoint.x,top),SCROLL_DUR);
        }else if (pagedirection=="LEFT") {
            swipe(new Point(left, midPoint.y),new Point(right,midPoint.y),SCROLL_DUR);
        }else {
            swipe(new Point(right,midPoint.y),new Point(left,midPoint.y),SCROLL_DUR);
        }


    }
     protected  static void swipe(Point start,Point end,Duration duration){
         PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger");
         Sequence swipe = new Sequence(input, 0);
         swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
         swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
         swipe.addAction(input.createPointerMove(Duration.ofSeconds(5), PointerInput.Origin.viewport(), end.x, end.y));
         swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
         driver.perform(ImmutableList.of(swipe));
     }

    //This is not working below. error on build.perform dont know why.
///*//public static void swipecode(){
////    int screenWidth = driver.manage().window().getSize().width;
////    int screenHeight = driver.manage().window().getSize().height;
////    // Calculate start and end points for the swipe
////    int startX = (int) (screenWidth * 0.1);
////    int endX = (int) (screenWidth * 0.9);
////    int startY = screenHeight / 2;
////
////    // Perform the swipe action
////    new Actions(driver)
////            .moveToElement(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"WebdriverIO is fully open source and can be found on GitHub\"]")), startX, startY)
////            .clickAndHold()
////            .moveByOffset(endX - startX, 0)
////            .release().build()
////            .perform();
////}*/
    ////////////////////////////////////////////////





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

