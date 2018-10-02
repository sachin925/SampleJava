package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class WebSetup {
    String baseURL;
    WebDriver driver;
    String dirPath="C:\\myProjects\\SampleJava\\executables\\chromedriver.exe";
    @BeforeClass
    public void setUp(){
//        System.out.println(System.getProperty(""));
        System.setProperty("webdriver.chrome.driver",dirPath);

        Map<String, Object> prefs = new HashMap<String, Object>();

        // Set the notification setting it will override the default setting
        prefs.put("profile.default_content_setting_values.notifications", 2);

        // Create object of ChromeOption class
        ChromeOptions options = new ChromeOptions();

        // add parameter which will disable the extension
        options.addArguments("--disable-extensions");

        // Set the experimental option
        options.setExperimentalOption("prefs", prefs);


        driver = new ChromeDriver(options);
        driver.get("https://www.google.com");
    }

    @Test
    public void test(){
        System.out.println("Welcome");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
