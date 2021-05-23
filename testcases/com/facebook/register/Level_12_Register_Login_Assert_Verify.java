package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.PageGeneratorManager;
import pageObjects.facebook.RegisterPageObject;

public class Level_12_Register_Login_Assert_Verify extends BaseTest {
	WebDriver driver;
	RegisterPageObject registerPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {

		driver = getBrowserDriver(browserName, appUrl);

		registerPage = PageGeneratorManager.getRegisterPage(driver);

	}

	//@Test
	public void Login_01_Assert() {
		Assert.assertTrue(registerPage.isEmailTextboxDisplayed());
		registerPage.enterToEmailTextbox("hatt@hatt.com");
		registerPage.sleepInSecond(2);
		Assert.assertTrue(registerPage.isConfirmEmailTextboxDisplayed());
		registerPage.enterToEmailTextbox("");
		registerPage.sleepInSecond(2);
		Assert.assertFalse(registerPage.isConfirmEmailTextboxDisplayed());
		Assert.assertTrue(registerPage.isConfirmEmailTextboxUndisplayed());
		Assert.assertTrue(registerPage.isLoginButtonUndisplayed());
	}

	@Test
	public void Login_02_Verify() {
		// failed - 1
		verifyFalse(registerPage.isEmailTextboxDisplayed());
		registerPage.enterToEmailTextbox("hatt@hatt.com");
		registerPage.sleepInSecond(2);
		// failed - 2
		verifyFalse(registerPage.isConfirmEmailTextboxDisplayed());
		registerPage.enterToEmailTextbox("");
		registerPage.sleepInSecond(2);
		verifyFalse(registerPage.isConfirmEmailTextboxDisplayed());
		verifyTrue(registerPage.isConfirmEmailTextboxUndisplayed());
		// failed - 3
		verifyFalse(registerPage.isLoginButtonUndisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
