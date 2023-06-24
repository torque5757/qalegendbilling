package com.qalegendbilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.listeners.TestListeners;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.utilities.ExcelUtility;

public class HomeTest extends Base
{
	LoginPage login;
	HomePage home;
	ThreadLocal<ExtentTest> extentTest = TestListeners.getTestInstance();
	
	@Test(priority=2,enabled=true,description="verify Signout Page",groups= {"Smoke"})
	public void tc_004_verifySignoutPage()
	{
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("Title");
		String expMessage = data.get(1).get(2);
		String username = data.get(1).get(0);
		String userpassword = data.get(1).get(1);	
		login = new LoginPage(driver);
		login.enterUserCredentials(username, userpassword);
		home =login.clickOnLoginBtn();
		home.endTourButton();
		home.clickProfilePage();
		home.clickSignoutBtn();
		String actMessage = login.getLoginTitle();
		Assert.assertEquals(actMessage, expMessage,ErrorMessages.INVALID_ERROR_MESSAGE);
	}
	
	@Test
	public void tc_005_verifyUserManagementSubTabsAreDisplayed()
	{
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("UserManagement");
		String username = data.get(1).get(0);
		String userpassword = data.get(1).get(1);	
     	login = new LoginPage(driver);	
		login.enterUserCredentials(username, userpassword);
		home =login.clickOnLoginBtn();
		home.endTourButton();
		home.clickUserSideBtn();
		boolean userMenuStatus=home.userMenuIsDisplayed();
	    Assert.assertTrue(userMenuStatus,ErrorMessages.INVALID_ERROR_MESSAGE);
	    boolean roleMenuStatus=home.roleMenuIsDisplayed();
	    Assert.assertTrue(roleMenuStatus,ErrorMessages.INVALID_ERROR_MESSAGE);
	    boolean salesCommissionMenuStatus=home.salescommissionagentsMenuIsDisplayed();
	    Assert.assertTrue(salesCommissionMenuStatus,ErrorMessages.INVALID_ERROR_MESSAGE);
	    
		
	}
	
}
