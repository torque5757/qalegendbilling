package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class UserPage extends TestHelperUtility {
	public WebDriver driver;

	public UserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
	private WebElement addUserBtn;
	
	@FindBy(xpath="//input[@class='form-control input-sm']")
	private WebElement emailSearchField;

	@FindBy(xpath = "//td[@class='sorting_1']//following::td[3]")
	
	private WebElement emailTableField;

	public AddUserPage clickAddUser() {
		addUserBtn.click();
		return new AddUserPage(driver);
	}
	public void enterSearchField(String email)
	{
		page.enterText(emailSearchField,email);
	}

	public String getEmailId() {
		wait.waitForElementToBeVisible(driver, emailTableField);
		String emailsearch = emailTableField.getText();
		return emailsearch;

	}
}
