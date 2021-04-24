package com.bankguru.login;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.RegisterPageObject;

public class Level_04_Register_Login_Multi_Browsers extends BaseTest {
	WebDriver driver;
	String username, password, loginPageUrl;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {

		driver = getBrowserDriver(browserName, appUrl);
	}

	@Test
	public void Login_01_Register_To_System() {
		loginPage = new LoginPageObject(driver);

		loginPageUrl = loginPage.getPageUrl(driver);
		loginPage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		Assert.assertTrue(registerPage.isRegisterPageHeadingDisplayed());
		registerPage.enterToEmailTextbox(getRandomEmail());
		registerPage.clickToSubmitButton();

		username = registerPage.getGeneratedUsername();
		password = registerPage.getGeneratedPassword();
	}

	@Test
	public void Login_02_Login_To_System() {
		registerPage.goToLoginPage(loginPageUrl);
		loginPage = new LoginPageObject(driver);

		loginPage.enterToUsernameTextbox(username);
		loginPage.enterToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getWelcomeMessage(), "Welcome To Manager's Page of Guru99 Bank");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public String getRandomEmail() {
		Random rand = new Random();
		return "hatt11" + rand.nextInt(99999) + "@live.com";
	}

	LoginPageObject loginPage;
	RegisterPageObject registerPage;
}