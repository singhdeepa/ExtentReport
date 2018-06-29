package com.tyss.eventreport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		WebDriverWait wait=new WebDriverWait(driver, 30);
Alert alert=wait.until(ExpectedConditions.alertIsPresent());
alert.accept();
alert.dismiss();
alert.getText();
alert.sendKeys("");
		/*ArrayList<String> alist=new ArrayList<String>();
		
		for(int i=0)
	
		 List<WebElement> list = driver.findElements(By.xpath("//input"));
		 
		 for(WebElement wb:list)
		 {
			 alist.add(wb.getText()) ;
			 
		 }
		HashMap<String,List<String>> hm=new HashMap<String,List<String>>();
		hm.put("A", alist);*/
	}

}
