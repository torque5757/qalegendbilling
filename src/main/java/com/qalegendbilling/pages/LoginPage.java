package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class LoginPage extends TestHelperUtility {
	public WebDriver driver;

  public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	WebElement userNameField;
	
	@FindBy(id = "password")
	WebElement passwordField;
	
	@FindBy(xpath = "//input[@name='remember']")
	private WebElement rememberMe;
	
	@FindBy(xpath = "//a[@class='btn btn-link']")
	private WebElement forgotPassword;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//span[@class='help-block']//strong")
	private WebElement loginErrorMsg;
	
	//@FindBy(xpath = "//meta[@name='csrf-token']//following::title")
	//private WebElement title;
	@FindBy(xpath = "//h1[@class='text-center page-header']")
	private WebElement title;
	
	
	
	public void enterUserCredentials(String username,String pword)
	{
		page.enterText(userNameField, username);
		page.enterText(passwordField, pword);
	}
	public HomePage clickOnLoginBtn()
	{
		loginBtn.click();
		return new HomePage(driver);
		
	}
	public String getLoginErrorMessage()
	{
		String errorMessage= page.getElementText(loginErrorMsg);
		return errorMessage;
	}
	
	public ResetPage clickForgotPassword()
	{
		forgotPassword.click();
		return new ResetPage(driver);
	}
	public String getLoginTitle()
	{
		String titleLogin = page.getElementText(title);
		return titleLogin;
	}
	
}
