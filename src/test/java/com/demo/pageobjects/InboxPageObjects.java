package com.demo.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.demo.pageconstants.InboxPageContants.*;

import com.demo.util.BasePage;

public class InboxPageObjects extends BasePage {

	public InboxPageObjects() {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = EMAILLIST_IFRAME)
	WebElement iframe_InboxList;

	@FindBy(xpath = FIRSTEMAIL_ELEMENT)
	WebElement ele_firstEmail;

	@FindBy(id = EMAIL_IFRAME)
	WebElement iframe_Email;

	@FindBy(xpath = EMAILSUBJECT_ELEMENT)
	WebElement ele_EmailSubject;

	@FindBy(xpath = EMAILBODY_ELEMENT)
	WebElement ele_EmailBody;

	public void switchEmailListFrame() {
		switchToFrame(iframe_InboxList);
	}

	public void clickFirstEmail() {
		clickElement(ele_firstEmail);
	}

	public String getEmailSubjectText() {
		return getText(ele_EmailSubject);
	}

	public String getEmailBodyText() {
		return getText(ele_EmailBody);
	}

	public void switchToDefault() {
		driver.switchTo().defaultContent();
	}

	public void switchEmailBodyFrame() {
		switchToFrame(iframe_Email);
	}
}
