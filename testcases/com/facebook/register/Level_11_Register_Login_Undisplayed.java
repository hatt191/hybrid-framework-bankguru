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

public class Level_11_Register_Login_Undisplayed extends BaseTest {
	WebDriver driver;
	RegisterPageObject registerPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {

		driver = getBrowserDriver(browserName, appUrl);

		registerPage = PageGeneratorManager.getRegisterPage(driver);

	}

	@Test
	public void Login_01_Element_Displayed() {
		// Displayed: Visible on UI + Exist in DOM
		// waitVisible
		// isDisplayed
		Assert.assertTrue(registerPage.isEmailTextboxDisplayed());

		// Business: Input to Email textbox
		// Confirm email textbox displayed
		registerPage.enterToEmailTextbox("hatt@hatt.com");
		registerPage.sleepInSecond(2);
		Assert.assertTrue(registerPage.isConfirmEmailTextboxDisplayed());
	}

	@Test
	public void Login_02_Element_Undisplayed_In_DOM() {
		// Undisplayed: Invisible on UI + Exist in DOM
		// isDisplayed

		// Business: Clear Email textbox
		registerPage.enterToEmailTextbox("");
		registerPage.sleepInSecond(2);
		// Confirm email textbox undisplayed
		Assert.assertFalse(registerPage.isConfirmEmailTextboxDisplayed());

	}

	@Test
	public void Login_03_Element_Undisplayed_Not_In_DOM() {
		// Undisplayed: Invisible on UI + Not Exist in DOM
		// isDisplayed -> using try/catch --> wait maximum implicit timeout
		Assert.assertFalse(registerPage.isLoginButtonDisplayed());
	}
	
	@Test
	public void Login_04_Element_Undisplayed_Not_In_DOM() {
		// Undisplayed: Invisible on UI + Not Exist in DOM
		// findElements
		// overide implicit timeout
		Assert.assertTrue(registerPage.isLoginButtonUndisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
