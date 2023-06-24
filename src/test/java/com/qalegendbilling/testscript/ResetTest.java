package com.qalegendbilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.listeners.TestListeners;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.ResetPage;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegendbilling.utilities.RandomUtility;

public class ResetTest extends Base{
	ThreadLocal<ExtentTest> extentTest = TestListeners.getTestInstance();
	LoginPage login;
	ResetPage reset;
	@Test
	public void tc_003_verifyForgotPassword()
	{
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("ResetPage");
		String expInvalidMsg = data.get(1).get(0) ;
		login = new LoginPage(driver);
		reset = login.clickForgotPassword();
		String invalidEmail = RandomUtility.getRandomEmail();
		reset.enterInvalidEmailID(invalidEmail);
		reset.resetBtnClick();
		String actInvalidMsg = reset.getInvalidMsg();
		Assert.assertEquals(expInvalidMsg, actInvalidMsg,ErrorMessages.INVALID_ERROR_MESSAGE);
	}
	
}
