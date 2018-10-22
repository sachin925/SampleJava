package common;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WrapperClass {
    public WebDriverWait wait;
    public WebElement element;
    public WebDriver driver;
    public XSSFWorkbook workBook;
    public XSSFSheet sheet;
    public FileInputStream fis;
    public int totalRow;

    public WrapperClass(WebDriver driver){
        this.driver = driver;
    }

    public Alert getAlert() {
        return alert;
    }

    public Alert alert;
    public boolean isAlert(WebDriver driver){
        try {
            alert = driver.switchTo().alert();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void acceptAlert(WebDriver driver){
        if(isAlert(driver)){
            alert.accept();
        }
    }
    public void dismissAlert(WebDriver driver){
        if(isAlert(driver)){
            alert.dismiss();
        }
    }

    public void maximizeWindow(WebDriver driver){
        this.driver = driver;
        this.driver.manage().window().maximize();
    }

    public void selectFrame(WebDriver driver){
        driver.switchTo().frame(0);
    }
    // select the frame by specifying element of that frame
    public void selectFrame(WebDriver driver, WebElement element){
        driver.switchTo().frame(element);
    }
    // to get parent window handles
    public String getParentWindowHandle(WebDriver driver){
        return driver.getWindowHandle();
    }
    // to get all open window handles
    public Set<String> getAllWindowHandle(WebDriver driver){
        return driver.getWindowHandles();
    }
    // to switch parent window
    public void switchToParentWindow(WebDriver driver){
        driver.switchTo().window(getParentWindowHandle(driver));
    }
    public void setImplicitWait(WebDriver driver, int time){
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public void explicit_wait(WebElement ele){
        try {
            wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(ele));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}