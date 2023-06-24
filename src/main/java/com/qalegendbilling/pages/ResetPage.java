package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class ResetPage extends TestHelperUtility {
	public WebDriver driver;

	public ResetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	private WebElement emailField;
	private final String _msgDisplayed="//input[@id='email']//following::span";
	@FindBy(xpath=_msgDisplayed)
	private WebElement msgDisplayed;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement resetBtn;

	public void enterInvalidEmailID(String email) {
		page.enterText(emailField, email);

	}
	public String getInvalidMsg()
	{
	
		String invalidMsg =page.getElementText(msgDisplayed);
		return invalidMsg;
	}
	public void resetBtnClick()
	{
		resetBtn.click();
	}

}
