package com.tyss.eventreport;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BrokenLink {
@Test
public void test()
{
WebDriver driver=new FirefoxDriver();
driver.get("C:\\Users\\TYSS\\Desktop\\a.html");
List<WebElement> allList = driver.findElements(By.tagName("a"));
for (WebElement ent : allList) {
	if(ent.getAttribute("href")==null)
	{
		System.out.println("broken link"+ent.getText());
	}else
	{
		System.out.println("not broken");
	}
	//System.out.println(ent);
	
	
	
	
	
}
}

}
