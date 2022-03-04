package com.demo.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.demo.pageconstants.LoginPageConstants.*;
import com.demo.util.BasePage;

public class LoginPageObjects extends BasePage {

	public LoginPageObjects() {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = LOGIN_TEXTBOX)
	WebElement textbox_Login;

	@FindBy(xpath = LOGIN_BUTTON)
	WebElement btn_Login;

	public void enterUsername(String username) {
		enterText(textbox_Login, username);
	}

	public void clickLogin() {
		clickElement(btn_Login);
	}
}
