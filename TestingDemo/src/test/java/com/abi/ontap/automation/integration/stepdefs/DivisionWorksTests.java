//package com.abi.ontap.automation.integration.stepdefs;
//
//import com.abi.ontap.automation.utils.DriverFactory;
//import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
//import com.microsoft.appcenter.appium.Factory;
//import cucumber.api.Scenario;
//import cucumber.api.java.After;
//import cucumber.api.java.Before;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import io.appium.java_client.MobileElement;
//import org.junit.Assert;
//import org.junit.ClassRule;
//import org.junit.Rule;
//import org.junit.rules.TestWatcher;
//
//import java.net.MalformedURLException;
//
//public class DivisionWorksTests {
//
//    private EnhancedAndroidDriver<MobileElement> driver;
//
//    @Before
//    public void init() throws MalformedURLException, InterruptedException {
//        driver = DriverFactory.getAndroidDriver();
//    }
//
//    @After
//    public void TearDown(){
//        DriverFactory.quitDriver();
//    }
//
//    @Given("first input for division is {int}")
//    public void first_input_for_division_is(Integer input) {
//        MobileElement el1 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_" + input);
//        el1.click();
//    }
//
//    @Given("second input for division is {string}")
//    public void second_input_for_division_is(String input) {
//        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId(input);
//        el2.click();
//    }
//
//    @Given("third input for division is {int}")
//    public void third_input_for_division_is(Integer input) {
//        MobileElement el3 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_" + input);
//        el3.click();
//    }
//
//    @When("press {string}")
//    public void press(String input) {
//        MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId(input);
//        el4.click();
//    }
//
//    @Then("I should be receive {string}")
//    public void i_should_be_receive(String output) {
//        Assert.assertEquals(driver.findElementById("com.google.android.calculator:id/result").getText(), output);
//    }
//
//}
