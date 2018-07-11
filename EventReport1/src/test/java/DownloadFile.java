import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

public class DownloadFile {
	@Test()
	   public void test() throws IOException, Exception {
	// System.setProperty("webdriver.chrome.driver", "C:\\Users\\TYSS\\eclipse-workspace\\ExtentReportSample\\src\\test\\resources\\chromedriver.exe");
	 FirefoxProfile p=new FirefoxProfile();
	 p.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/zip");
WebDriver  driver=new FirefoxDriver();

 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 driver.get("https://docs.seleniumhq.org/download/");
 driver.findElement(By.xpath("//a[@href='https://goo.gl/4g538W']")).click();
 
	}
}
