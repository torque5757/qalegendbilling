package com.qalegendbilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.dataprovider.DataProviders;
import com.qalegendbilling.listeners.TestListeners;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.utilities.ExcelUtility;

public class LoginTest extends Base
{
	LoginPage login;
	HomePage home;
	ThreadLocal<ExtentTest> extentTest = TestListeners.getTestInstance();
	
	@Test(priority=1,enabled=true,description="tc_001_verify validLogin",groups= {"Regression"})
	public void tc_001_verifyvalidLogin()
	{
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String username = data.get(1).get(0);
     	String userpassword = data.get(1).get(1);
		String expNameDisplayed= data.get(1).get(2);
		login = new LoginPage(driver);	
		login.enterUserCredentials(username, userpassword);
		home =login.clickOnLoginBtn();
		home.endTourButton();
		String actNameDisplayed = home.getLoginName();
		Assert.assertEquals(actNameDisplayed, expNameDisplayed,ErrorMessages.INVALID_ERROR_MESSAGE);
		
	}
	@Test(dataProvider="InvalidUserCredentials",dataProviderClass=DataProviders.class)
	public void tc_002_verifyInvalidLoginErrorMessage(String username,String userpassword)
	{
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("InvalidLogin");
		String expErrMessage = data.get(1).get(2);
		login = new LoginPage(driver);	
		login.enterUserCredentials(username, userpassword);
		home =login.clickOnLoginBtn();
		String actErrorMessage = login.getLoginErrorMessage();
		Assert.assertEquals(actErrorMessage, expErrMessage,ErrorMessages.INVALID_ERROR_MESSAGE);
		
	}
	
	
}
