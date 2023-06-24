package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class AddUserPage extends TestHelperUtility{
	public WebDriver driver;
	public AddUserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id = "surname")
	private WebElement prefix;

	@FindBy(id = "first_name")
	private WebElement firstName;

	@FindBy(id = "last_name")
	private WebElement lastName;

	@FindBy(id = "email")
	private WebElement emailField;

	@FindBy(id = "username")
	private WebElement userNameField;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(id = "confirm_password")
	private WebElement confirmPasswordField;

	@FindBy(id = "cmmsn_percent")
	private WebElement commissionPercentage;
	
	@FindBy(id = "submit_user_button")
	private WebElement saveBtn;
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement searchField;
	
	public void enterUserDetails(String fName,String lName,String email,String userName,String userPassword,String conPassword,String commisionPercent)
	{
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		emailField.sendKeys(email);
		passwordField.sendKeys(userPassword);
		confirmPasswordField.sendKeys(conPassword);
		userNameField.sendKeys(userName);
		commissionPercentage.sendKeys(commisionPercent);
	}
public void clickSaveBtn()
{
	saveBtn.click();
}

public void enterSearchField(String search)
{
	searchField.sendKeys(search);
	
}

}
