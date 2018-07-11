package com.tyss.eventreport;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RightClick {
	
	public static void main(String[] args) throws InterruptedException{
		//WebDriver driver = new FirefoxDriver();
		HtmlUnitDriver hdriver = new HtmlUnitDriver(true);
		 
		hdriver.setJavascriptEnabled(false);
		//Launching Sample site
		//driver.get("http://toolsqa.wpengine.com/iframe-practice-page/");
		hdriver.get("http://artoftesting.com/sampleSiteForSelenium.html");
		//Right click in the TextBox
		Actions action = new Actions(hdriver);
		WebElement searchBox = hdriver.findElement(By.cssSelector("#fname"));
		action.moveToElement(searchBox).contextClick().perform();
		//action.contextClick(searchBox).build().perform();
		
		//Thread.sleep just for user to notice the event
		Thread.sleep(3000);
		/* List framesList = driver.findElements(By.xpath("//iframe"));

		 int numOfFrames = framesList.size();
		 System.out.println(numOfFrames);*/
		//Closing the driver instance
		//driver.quit();
		
	}
	
	
}