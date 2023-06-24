package com.qalegendbilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.listeners.TestListeners;
import com.qalegendbilling.pages.AddUserPage;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.UserPage;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegendbilling.utilities.RandomUtility;

public class AddUserTest extends Base {
	ThreadLocal<ExtentTest> extentTest = TestListeners.getTestInstance();
	LoginPage login;
	HomePage home;
	UserPage user;
	AddUserPage adduser;

	@Test
	public void tc_006_verifyUsersPage() {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("UserManagement");
		String username = data.get(1).get(0);
		String userpassword = data.get(1).get(1);
		String commisionPercent = data.get(1).get(2);
		String fName =RandomUtility.getfName();
		String lName =RandomUtility.getlName();
		String email =RandomUtility.getRandomEmail();
		String userName = fName+"@234";
		String userPassword = lName+"@123";
		String conPassword = userPassword;
		login = new LoginPage(driver);
		login.enterUserCredentials(username, userpassword);
		home = login.clickOnLoginBtn();
		home.endTourButton();
		home.clickUserSideBtn();
		user = home.clickUsers();
		adduser = user.clickAddUser();
		adduser.enterUserDetails(fName,lName,email,userName,userPassword,conPassword,commisionPercent);
		adduser.clickSaveBtn();
		user.enterSearchField(email);
	String actEmail=user.getEmailId();
	Assert.assertEquals(actEmail,email,ErrorMessages.INVALID_ERROR_MESSAGE);
		

	}
}
