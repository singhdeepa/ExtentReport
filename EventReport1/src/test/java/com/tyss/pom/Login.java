package com.tyss.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
@FindBy(id="identifierId")
private WebElement username;
@FindBy(name="password")
private WebElement password;
@FindBy(xpath=("//span[.='Next']"))
private WebElement next;
public void loginApp(String userName,String passWord)
{
	username.sendKeys(userName);
	next.click();
	password.sendKeys(passWord);
}
}
