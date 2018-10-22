package common;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AppiumSetup {
    AndroidDriver driver;
    DesiredCapabilities capabilities;
    private String getAdb() {
        List<String> deviceList = new ArrayList<String>();
        String line;
        Process p2;
        try {
            //start appium via command prompt
            p2 = Runtime.getRuntime().exec("cmd.exe /c  adb devices");
            BufferedReader input = new BufferedReader(new InputStreamReader(
                    p2.getInputStream()));
            while ((line = input.readLine()) != null) {
                if (line.endsWith("device")) {
                    deviceList.add(line.split("\\t")[0]);
                }
            }
        } catch (IOException e) {
            System.out.println("ADB not responding");
        }
        // return the adb id
        return deviceList.get(0).toString();
    }

    @BeforeSuite
    public void setUP() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("newCommandTimeout", "50");
//        capabilities.setCapability("appPackage", "com.android.calender");
//        capabilities.setCapability("appActivity","com.android.calender.LaunchActivity");
        capabilities.setCapability("app", "C:\\myProjects\\SampleJava\\executables\\demo.apk");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName","uiautomator2");
        capabilities.setCapability("deviceName", "Moto G5+");
        capabilities.setCapability("VERSION", "7.0");
        capabilities.setCapability("udid", getAdb());

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),
                capabilities);
    }

    @Test
    public void test() throws InterruptedException {
        System.out.println("test-1");
        WebElement textField = driver.findElementByAccessibilityId("my_text_fieldCD");

        textField.clear();

        textField.sendKeys("Sample text to search");
        Thread.sleep(1000);
        WebElement btn = driver.findElementById("buttonTest");
        btn.click();
        Thread.sleep(1000);
        WebElement pup_btn = driver.findElementById("button1");
        pup_btn.click();

    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }

}

