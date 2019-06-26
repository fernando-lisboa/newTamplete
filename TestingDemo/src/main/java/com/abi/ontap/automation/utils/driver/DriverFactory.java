package com.abi.ontap.automation.utils.driver;

import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
import com.microsoft.appcenter.appium.Factory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    private static EnhancedAndroidDriver<MobileElement> driverInstance;

    public static EnhancedAndroidDriver<MobileElement> getAndroidDriver () throws MalformedURLException, InterruptedException {
        if (driverInstance == null) {
            boolean localTest = Boolean.parseBoolean(System.getProperty("local.tests"));
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("autoGrantPermissions", "true");
            capabilities.setCapability(MobileCapabilityType.NO_RESET, false);

            //Adjust these capabilities for local environment
            if (localTest) {
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
                capabilities.setCapability("appPackage", "com.google.android.calculator");
                capabilities.setCapability("appActivity", "com.android.calculator2.CalculatorGoogle");
                URL url = new URL("http://127.0.0.1:4723/wd/hub");
                driverInstance = Factory.createAndroidDriver(url, capabilities);
            } else {
                capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
                driverInstance = Factory.createAndroidDriver(capabilities);
            }
        }

        synchronized (driverInstance) {
            driverInstance.wait(1000);
        }

        return driverInstance;
    }

    public static void quitDriver() {
        driverInstance.quit();
        driverInstance = null;
    }

}
