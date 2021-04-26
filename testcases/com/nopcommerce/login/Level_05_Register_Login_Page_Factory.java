package com.nopcommerce.login;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageFactory.nopCommerce.HomePageObject;
import pageFactory.nopCommerce.LoginPageObject;
import pageFactory.nopCommerce.RegisterPageObject;

public class Level_05_Register_Login_Page_Factory extends BaseTest {
	WebDriver driver;
	String email, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {

		driver = getBrowserDriver(browserName, appUrl);
		email = getRandomEmail();
		password = "123456";
	}

	@Test
	public void Login_01_Register_To_System() {
		homePage = new HomePageObject(driver);

		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);

		Assert.assertTrue(registerPage.isRegisterPageHeadingDisplayed());
		registerPage.clickToGenderMaleRadioButton();
		registerPage.enterToFirstnameTextbox("John");
		registerPage.enterToLastnameTextbox("Terry");
		registerPage.enterToEmailTextbox(email);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());

		registerPage.clickToLogoutLink();
		homePage = new HomePageObject(driver);

		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}

	@Test
	public void Login_02_Login_To_System() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		Assert.assertTrue(loginPage.isLoginPageHeadingDisplayed());
		loginPage.enterToEmailTextbox(email);
		loginPage.enterToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		homePage = new HomePageObject(driver);

		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public String getRandomEmail() {
		Random rand = new Random();
		return "johnterry" + rand.nextInt(99999) + "@live.com";
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
}
