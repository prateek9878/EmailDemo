package com.demo.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.demo.pageobjects.InboxPageObjects;
import com.demo.pageobjects.LoginPageObjects;

public class TestCase_01 extends AbstractTest {

	SoftAssert softAssert;

	@BeforeMethod
	void startTest() {
		softAssert = new SoftAssert();
		loginPage = new LoginPageObjects();
		inboxPage = new InboxPageObjects();
	}

	@Test(dataProvider = "DataProvider")
	void TC01(String emailID, String subjectText, String bodyText) {
		loginToEmail(emailID);
		inboxPage.switchEmailListFrame();
		inboxPage.clickFirstEmail();
		inboxPage.switchToDefault();
		inboxPage.switchEmailBodyFrame();
		softAssert.assertEquals(inboxPage.getEmailSubjectText(), subjectText);
		softAssert.assertEquals(inboxPage.getEmailBodyText(), bodyText);
		navigateBack();
		softAssert.assertAll();
	}

	@AfterMethod()
	void endTest() {

	}

	@DataProvider(name = "DataProvider")
	public Object[][] getData() {
		return xl.getTestData("TestData.xlsx", "Sheet1");
	}
}
