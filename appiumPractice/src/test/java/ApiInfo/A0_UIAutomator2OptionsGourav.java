package ApiInfo;

//UiAutomator2Options is the new options from Appium 2.0

import io.appium.java_client.android.options.UiAutomator2Options;


import io.appium.java_client.android.options.EspressoOptions;

import java.io.File;

public class A0_UIAutomator2OptionsGourav {
    public UiAutomator2Options getApiDemosAPKOptions() {
        System.out.println("------------Staring api demos apk---------------");
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("builds/ApiDemos-debug.apk").getFile());
        String apKAppPath = file.getAbsolutePath();

        UiAutomator2Options options = new UiAutomator2Options();
        options
                .setPlatformName("android")
                .setPlatformVersion("13")
                .setAutomationName("UiAutomator2")
                .setDeviceName("ST5GDM23LB005246")  //here you can put emulator as well if you open android studio and emulator is there
                .setAppPackage("io.appium.android.apis")
                .setAppActivity("io.appium.android.apis.ApiDemos")
                .setApp(apKAppPath) //optional: drag and drop can also be used
                .setNoReset(false);//true: will not install app if already


        return options;
    }


    public UiAutomator2Options getSauceLabsAPKOptions() {
        System.out.println("------------Staring Sauce lab application---------------");
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("builds/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk").getFile());
        String apKAppPath = file.getAbsolutePath();

        UiAutomator2Options options = new UiAutomator2Options();
        options
                .setPlatformName("android")
                .setPlatformVersion("13")
                .setAutomationName("UiAutomator2")
                .setDeviceName("ST5GDM23LB005246")  //here you can put emulator as well if you open android studio and emulator is there
                .setAppPackage("com.swaglabsmobileapp")
                .setAppActivity("com.swaglabsmobileapp.MainActivity")
                .setApp(apKAppPath) //optional: drag and drop can also be used
                .setNoReset(false);//true: will not install app if already


        return options;
    }
    public UiAutomator2Options gewebDriverApplicationAPKOptions() {
        System.out.println("------------Staring Sauce lab application---------------");
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("builds/android.wdio.native.app.v1.0.8.apk").getFile());
        String apKAppPath = file.getAbsolutePath();

        UiAutomator2Options options = new UiAutomator2Options();
        options
                .setPlatformName("android")
                .setPlatformVersion("13")
                .setAutomationName("UiAutomator2")
                .setDeviceName("ST5GDM23LB005246")  //here you can put emulator as well if you open android studio and emulator is there
                .setAppPackage("com.wdiodemoapp")
                .setAppActivity("com.wdiodemoapp.MainActivity")
                .setApp(apKAppPath) //optional: drag and drop can also be used
                .setNoReset(true);//true: will not install app if already


        return options;
    }

    public UiAutomator2Options getChromeBrowserOptions() {
        System.out.println("------------Staring Chrome Browser---------------");
//        ClassLoader classLoader = getClass().getClassLoader();
//        File file = new File(classLoader.getResource("builds/ApiDemos-debug.apk").getFile());
//        String apKAppPath = file.getAbsolutePath();

        UiAutomator2Options options = new UiAutomator2Options();
        options
                .setPlatformName("android")
                .setPlatformVersion("13")
                .setAutomationName("UiAutomator2")
                .setDeviceName("ST5GDM23LB005246")  //here you can put emulator as well if you open android studio and emulator is there
                .noReset()
                .withBrowserName("Chrome");


        return options;
    }

}
