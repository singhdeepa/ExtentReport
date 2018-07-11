package com.tyss.eventreport;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tyss.pom.Login;

public class Extent {
	 WebDriver driver;
	 public static ExtentReports extent;
    public static ExtentTest test;
    //ExcelLib lib;
    Login lgn=new Login();
   @BeforeTest
   public void report(){
           Date date=new Date();
           extent = new ExtentReports(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "reports.html");
           extent.addSystemInfo("Host Name", "Deepa")
           .addSystemInfo("Environment", "QA")
           .addSystemInfo("User Name", "DeepaSingh");
   }
           //extent.loadConfig(new File("./extent-config.xml"));
           @Test()
           public void test(String username,String pwd) throws IOException, Exception {
                   
                   test=extent.startTest("JavascriptPopup");

                   System.setProperty("webdriver.chrome.driver", "C:\\Users\\TYSS\\eclipse-workspace\\ExtentReportSample\\src\\test\\resources\\chromedriver.exe");
                    driver=new ChromeDriver();
                   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                   driver.get("https://www.google.com/gmail/about/");
                   driver.findElement(By.xpath("//a[.='Sign In']")).click(); 
                   driver.findElement(By.id("identifierId")).sendKeys("singhdeepa");
                   
                   test.log(LogStatus.PASS, "username is entered");
   }
}
