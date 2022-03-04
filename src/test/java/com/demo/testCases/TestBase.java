package com.demo.testCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.demo.driver.DriverFactory;
import com.demo.util.BasePage;
import com.demo.util.ConfigData;
import com.demo.util.ExcelData;

public class TestBase extends BasePage {

	ConfigData config = new ConfigData();
	ExcelData xl = new ExcelData();

	@BeforeTest(alwaysRun = true)
	public void setupTest() {
		try {
			DriverFactory.setDriver(config.prop.getProperty("url"));
		} catch (Exception e) {
			throw new AssertionError(e.getMessage());
		}
	}

	@AfterTest(alwaysRun = true)
	public void tearDown() {
		DriverFactory.getDriver().quit();
	}

	void navigateBack() {
		DriverFactory.getDriver().navigate().back();
	}
}
