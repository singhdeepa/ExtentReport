package com.tyss.eventreport;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
 
public class GetScreenShot {
     
    public static String capture(WebDriver driver,String screenShotName) throws IOException, AWTException
    {/*
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") +"\\ErrorScreenshots\\"+screenShotName+".png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);        
                     
        return dest;*/
    	
    	Robot r=new Robot();
    	Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rect=new Rectangle(d);
		BufferedImage img = r.createScreenCapture(rect);
		String dest =System.getProperty("user.dir") +"\\ErrorScreenshots\\"+screenShotName+".png";
		ImageIO.write(img, "png", new File(dest));
		return dest;
		
    }
}
