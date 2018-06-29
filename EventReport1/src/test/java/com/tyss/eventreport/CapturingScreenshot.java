package com.tyss.eventreport;

import java.awt.AWTException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tyss.utility.ExcelLib;

 
public class CapturingScreenshot
{
    ExtentReports extent;
    ExtentTest test;
   public WebDriver driver;
     ExcelLib lib;
    @BeforeTest
    public void init()
    {
    	Date myDate = new Date();
    	DateFormat  sdf = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
    	String myDateString = sdf.format(myDate);
    	System.out.println(myDateString);
    	System.out.println(System.getProperty("user.dir"));
        extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/Report/"+myDateString+".html", true);
        extent.addSystemInfo("HostName", "QA");
        extent.addSystemInfo("UserName", "Deepa");
    }
     
    @Test
    public void captureScreenshot() throws IOException, Exception
    {
        test = extent.startTest("captureScreenshot");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\TYSS\\Desktop\\Desktop file\\selenium drivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.automationtesting.in");
        driver.manage().window().maximize();
        String title = driver.getTitle();
      //  lib.getExcelData();
       // Assert.fail();
       Assert.assertEquals("Home-Selenium Webdriver Appium Complete Tutorial", title);
      test.log(LogStatus.PASS, "Title is same");
       
      /*  Thread.sleep(5000);
        Actions action = new Actions(driver);
        WebElement element=    driver.findElement(By.xpath("(//a[text()='Selenium'])[1]"));
        action.moveToElement(element).build().perform();
        driver.findElement(By.xpath("//a[text()='Selenium Java Tutorial']")).click();
        Assert.assertEquals("Selenium Java Tutorial is clicked", true);
        test.log(LogStatus.PASS, "Selenium Java Tutorial  Link is clicked");*/
      
    }
     
    @AfterMethod
    public void getResult(ITestResult result) throws IOException, Exception
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            String screenShotPath = GetScreenShot.capture(driver, "screenShotName");
            test.log(LogStatus.FAIL, result.getThrowable());
            test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenShotPath));
        }else if(result.getStatus() == ITestResult.SUCCESS)
        {
        	 String screenShotPath = GetScreenShot.capture(driver, "screenShotName");
            // test.log(LogStatus.PASS, result.getThrowable());
             test.log(LogStatus.PASS, "Snapshot below: " + test.addScreenCapture(screenShotPath));
        }
        extent.endTest(test);
    }
     
         
    @AfterTest
    public void endreport()
    {
        driver.close();
        extent.flush();
        extent.close();
    }
}
