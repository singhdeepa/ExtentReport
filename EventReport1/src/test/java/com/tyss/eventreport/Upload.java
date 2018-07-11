package com.tyss.eventreport;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Upload {
	@Test()
	   public void test() throws IOException, Exception {
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\TYSS\\eclipse-workspace\\ExtentReportSample\\src\\test\\resources\\chromedriver.exe");
   WebDriver  driver=new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get("https://www.2shared.com/");
    driver.findElement(By.xpath("//a[text()='Upload']")).sendKeys("C:\\Users\\TYSS\\Desktop\\Demo.java");
	}
}
