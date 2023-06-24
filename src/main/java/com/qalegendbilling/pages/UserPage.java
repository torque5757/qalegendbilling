package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class UserPage extends TestHelperUtility
{
	public WebDriver driver;
public UserPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
@FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
private WebElement addUserBtn;

public AddUserPage clickAddUser() {
	addUserBtn.click();
	return new AddUserPage(driver);
}
}
