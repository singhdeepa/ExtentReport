package com.tyss.eventreport;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AutoIt {
	 
	private static WebDriver driver ;
 
	@Test
	public void test() throws InterruptedException
 {
 
		 System.setProperty("webdriver.gecko.driver", "D:\\Practise\\EventReport1\\src\\test\\resources\\geckodriver.exe");
         driver=new FirefoxDriver();
         Thread.sleep(5000);
 driver.get(/*"https://www.seleniumhq.org/download/"*/"https://www.gmail.com");
 Thread.sleep(5000);
 /*driver.findElement(By.xpath("//a[@href=\"https://goo.gl/4g538W\"]")).click();
 Thread.sleep(5000);
	    Runtime.getRuntime().exec("C:\\Program Files (x86)\\AutoIt3\\SciTE\\..\\aut2exe\\aut2exe.exe");
 */
 System.out.println("demo1");
	}
}