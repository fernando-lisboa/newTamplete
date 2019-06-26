//package com.abi.ontap.automation.ui;
//
//import com.abi.ontap.automation.utils.DriverFactory;
//import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
//import com.microsoft.appcenter.appium.Factory;
//import io.appium.java_client.MobileElement;
//import org.junit.*;
//import org.junit.rules.TestWatcher;
//
//import java.net.MalformedURLException;
//
//public class DemoAutomationTests {
//
//    @Rule
//    public TestWatcher watcher = Factory.createWatcher();
//
//    private static EnhancedAndroidDriver<MobileElement> driver;
//
//    @Before
//    public void init() throws MalformedURLException, InterruptedException {
//        driver = DriverFactory.getAndroidDriver();
//    }
//
//    @After
//    public void TearDown(){
//        driver.label("Stopping App");
//        DriverFactory.quitDriver();
//    }
//
//    @Test
//    public void calculatorTest() throws InterruptedException {
//        synchronized (driver) {
//            driver.wait(1000);
//            MobileElement el1 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_2");
//            el1.click();
//            MobileElement el2 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_5");
//            el2.click();
//            MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("plus");
//            el3.click();
//            MobileElement el4 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_3");
//            el4.click();
//            MobileElement el5 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_9");
//            el5.click();
//            MobileElement el6 = (MobileElement) driver.findElementByAccessibilityId("equals");
//            el6.click();
//            Assert.assertEquals(driver.findElementById("com.google.android.calculator:id/result").getText(), "64");
//        }
//    }
//}
