package com.tyss.eventreport;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssSelectorExample {
	@Test
	 public void test() throws IOException, Exception {
         
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\TYSS\\eclipse-workspace\\ExtentReportSample\\src\\test\\resources\\chromedriver.exe");
    WebDriver  driver=new ChromeDriver();
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     driver.get("https://www.google.com/gmail/about/");
     driver.findElement(By.xpath("//a[.='Sign In']")).click(); 
     driver.findElement(By.cssSelector("#identifierId")).sendKeys("singhdeepa9555@gmail.com");
     driver.findElement(By.xpath("//span[.='Next']")).click();
     driver.findElement(By.cssSelector("input[name='password']")).sendKeys("nilam");
     driver.findElement(By.xpath("//span[.='Next']")).click();
     driver.close();
     
	}
}
