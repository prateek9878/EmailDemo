package com.demo.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.driver.DriverFactory;

public class BasePage {

	protected WebDriver driver;

	protected BasePage() {
		driver = DriverFactory.getDriver();
	}

	@SuppressWarnings("deprecation")
	public void clickElement(WebElement webElement) {
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(webElement)).click();
		} catch (Exception e) {
			throw new AssertionError(e.getMessage());
		}
	}

	@SuppressWarnings("deprecation")
	public void enterText(WebElement webElement, String value) {
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(webElement)).clear();
			webElement.sendKeys(value);
		} catch (Exception e) {
			throw new AssertionError(e.getMessage());
		}
	}

	@SuppressWarnings("deprecation")
	public String getText(WebElement webElement) {
		try {
			return new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(webElement)).getText();
		} catch (Exception e) {
			throw new AssertionError(e.getMessage());
		}
	}

	public void scrollelement(WebElement webElement) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", webElement);
		} catch (Exception e) {
			throw new AssertionError(e.getMessage());
		}
	}

	@SuppressWarnings("deprecation")
	public void switchToFrame(WebElement webElement) {
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(webElement));
			driver.switchTo().frame(webElement);
		} catch (Exception e) {
			throw new AssertionError(e.getMessage());
		}
	}
}
