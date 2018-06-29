package com.tyss.eventreport;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tyss.pom.Login;
import com.tyss.utility.ExcelLib;

public class JavascriptPopup  {
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
           
           //extent.loadConfig(new File("./extent-config.xml"));
   }

   @Test(dataProvider="getdata")
   public void test(String username,String pwd) throws IOException, Exception {
           
           test=extent.startTest("JavascriptPopup");

           System.setProperty("webdriver.chrome.driver", "C:\\Users\\TYSS\\eclipse-workspace\\ExtentReportSample\\src\\test\\resources\\chromedriver.exe");
            driver=new ChromeDriver();
           driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
           driver.get("https://www.google.com/gmail/about/");
           driver.findElement(By.xpath("//a[.='Sign In']")).click(); 
           PageFactory.initElements(driver, lgn);
           lgn.loginApp(username, pwd);
         //  String username=ExcelLib.getExcelData("Sheet1",3,0);
         //  String pwd=ExcelLib.getExcelData("Sheet1",3,1);
          //.loginApp(ExcelLib.getExcelData("Sheet1",2,0), ExcelLib.getExcelData("Sheet1",2,1));
          /* String value=ExcelLib.getExcelData("Sheet1",3,0);
           driver.findElement(By.id("identifierId")).sendKeys(value);
           
           test.log(LogStatus.PASS, "username is entered");
           driver.findElement(By.xpath("//span[.='Next']")).click();
           test.log(LogStatus.PASS, "Next button is Clicked");
           Thread.sleep(3000);
           driver.findElement(By.name("password")).sendKeys(ExcelLib.getExcelData("Sheet1",row,column));
           test.log(LogStatus.PASS, "Password is entered");*/
       //    Thread.sleep(3000);
           /*driver.findElement(By.xpath("//span[.='Next']")).click();
           test.log(LogStatus.PASS, "Next button is Clicked");
           driver.findElement(By.xpath("//div[.='COMPOSE']")).click();*/
          // test.log(LogStatus.PASS, "Compose button is Clicked");
          // driver.findElement(By.xpath("//div[@class='a1 aaA aMZ']")).click();
          /* StringSelection s=new StringSelection("D:\\FlipkarSC_vasanth.ods");
           Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
           Robot r = new Robot();
           r.keyPress(KeyEvent.VK_CONTROL);
           r.keyPress(KeyEvent.VK_V);
           r.keyRelease(KeyEvent.VK_CONTROL);
           r.keyRelease(KeyEvent.VK_V);
           Thread.sleep(2000);
           r.keyPress(KeyEvent.VK_ENTER);
           r.keyRelease(KeyEvent.VK_ENTER);
           Thread.sleep(2000);
           r.keyPress(KeyEvent.VK_ESCAPE);
           r.keyRelease(KeyEvent.VK_ESCAPE);*/
          // driver.close();
   }
   @DataProvider
   public Object[][] getdata() throws Exception
   {
	   Object ob[][]=new Object[4][2];
	   for(int i=1;i<4;i++)
	   {
		   for(int j=1;j<2;j++)
		   {
			   ob[i][j]=ExcelLib.getExcelData("Sheet1", i, j);
		   }
	   }
	   return ob;
   }
   @AfterTest
   public void endReport()
   {
           extent.flush();
           //extent.close();
   }
}
