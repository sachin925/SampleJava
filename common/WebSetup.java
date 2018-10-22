package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebSetup {
    public String baseURL;
    public WebDriver driver;
    public WrapperClass wrappers;
    public String dirPath="C:\\myProjects\\SampleJava\\executables\\chromedriver.exe";

    @BeforeClass
    public void setUp(){
        baseURL = "C:\\myProjects\\SampleJava\\app\\app.html";
        System.setProperty("webdriver.chrome.driver",dirPath);

        Map<String, Object> prefs = new HashMap<String, Object>();
        wrappers = new WrapperClass();
        // Set the notification setting it will override the default setting
        prefs.put("profile.default_content_setting_values.notifications", 2);

        // Create object of ChromeOption class
        ChromeOptions options = new ChromeOptions();

        // add parameter which will disable the extension
        options.addArguments("--disable-extensions");

        // Set the experimental option
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.get(baseURL);

        // Maximizing browser window
        wrappers.maximizeWindow(driver);

        // Adding implicit wait
        wrappers.setImplicitWait(driver,30);
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
