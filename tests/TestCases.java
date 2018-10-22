package tests;

import common.WebSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import common.WrapperClass;

import java.util.List;

public class TestCases extends WebSetup {
    WrapperClass wrappers;
    @BeforeSuite
    public void initObjects(){
        wrappers = new WrapperClass(driver);
    }

    @Test(priority = 0)
    public void test(){
        Assert.assertEquals(driver.getTitle(),"Testing Select Class","Title does not match");
    }

    @Test()
    public void test2(){
        wrappers.explicit_wait(driver.findElement(By.id("")));
//        Assert.assertEquals(element.getText(),"ABOUT","Element text mismatch");

        driver.findElement(By.linkText("Google")).click();
        driver.navigate().back();

    }

    @Test(priority = 1)
    public void test3()throws Exception{
        WebElement dropDownBtn1=driver.findElement(By.id("SelectID_One"));
        System.out.println("Class :"+driver.getClass());
        System.out.println("--------------"+driver.getPageSource()+"--------------------------------------");
        Select select = new Select(dropDownBtn1);

        select.selectByIndex(1);
        Thread.sleep(5);

        select.selectByVisibleText("Grey");

        List<WebElement> options = select.getOptions();

        for(WebElement element : options){
            System.out.println("Option: "+element.getText());
        }
    }

}
