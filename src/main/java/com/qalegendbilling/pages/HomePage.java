package com.qalegendbilling.pages;

import org.checkerframework.checker.signature.qual.FieldDescriptor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qalegendbilling.utilities.TestHelperUtility;

public class HomePage extends TestHelperUtility {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[text()='Rakesh Mohan']")
	private WebElement nameDisplayed;

	@FindBy(xpath = "//div[@class='popover-navigation']//button[@data-role='end']")
	private WebElement endTourBtn;

	@FindBy(xpath = "//a[@class='dropdown-toggle']//span")
	private WebElement profilePage;

	@FindBy(xpath = "//div[@class='pull-right']//a[@class='btn btn-default btn-flat']")
	private WebElement signOutBtn;

	@FindBy(xpath = "//a[@class='sidebar-toggle']")
	private WebElement sideBar;

	@FindBy(xpath = "//i[@class='fa fa-users']//following-sibling::span[1]")
	private WebElement sideBarUserManagement;

	@FindBy(xpath = "//i[@class='fa fa-user']//following-sibling::span")
	private WebElement users;
	@FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
	private WebElement userCreate;

	@FindBy(id = "surname")
	private WebElement prefix;

	@FindBy(id = "first_name")
	private WebElement firstName;

	@FindBy(id = "last_name")
	private WebElement lastName;

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "username")
	private WebElement userNameField;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(id = "confirm_password")
	private WebElement confirmPasswordField;

	@FindBy(id = "cmmsn_percent")
	private WebElement commissionPercentage;

	@FindBy(xpath = "//i[@class='fa fa-briefcase']//following-sibling::span")
	private WebElement roles;

	@FindBy(xpath = "//i[@class='fa fa-handshake-o']//following-sibling::span")
	private WebElement salescommissionagents;

	@FindBy(id = "submit_user_button")
	private WebElement saveBtn;

	public void enterUserField() {
		page.enterText(prefix, "Mr");
		page.enterText(firstName, random.getfName());
		page.enterText(lastName, random.getlName());
		String emailId = random.getRandomEmail();
		page.enterText(email, emailId);
		page.enterText(userNameField, "rak123");
		page.enterText(passwordField, "qwerty123");
		page.enterText(confirmPasswordField, "qwerty123");
		page.enterText(commissionPercentage, "25");
		saveBtn.click();

	}

	public String getLoginName() {
		String displayedName = page.getElementText(nameDisplayed);
		return displayedName;
	}

	public void endTourButton() {
		endTourBtn.click();
	}

	public void clickProfilePage() {
		profilePage.click();
	}

	public void clickSignoutBtn() {
		signOutBtn.click();
	}

	public void clickUserSideBtn() {

		sideBarUserManagement.click();
		wait.waitForElementToBeVisible(driver, salescommissionagents);

	}

	public UserPage clickUsers() {
		users.click();
		return new UserPage(driver);
	}

	

	public void clickRoles() {
		roles.click();
	}

	public void clickSalesCommissionAgents() {
		salescommissionagents.click();
	}

	public boolean userMenuIsDisplayed() {
		boolean status = users.isDisplayed();
		return status;
	}

	public boolean roleMenuIsDisplayed() {
		boolean status = roles.isDisplayed();
		return status;
	}

	public boolean salescommissionagentsMenuIsDisplayed() {
		boolean status = salescommissionagents.isDisplayed();
		return status;
	}

}
