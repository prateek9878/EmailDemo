package com.demo.testCases;

import com.demo.pageobjects.InboxPageObjects;
import com.demo.pageobjects.LoginPageObjects;

public class AbstractTest extends TestBase {

	public LoginPageObjects loginPage;
	public InboxPageObjects inboxPage;

	public void loginToEmail(String username) {
		loginPage.enterUsername(username);
		loginPage.clickLogin();
	}

}
