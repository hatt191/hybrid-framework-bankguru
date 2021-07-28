package com.nopcommerce.login;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import commons.BaseTest;
import pageObjects.user.nopCommerce.HomePageObject;
import pageObjects.user.nopCommerce.LoginPageObject;
import pageObjects.user.nopCommerce.MyAccountPageObject;
import pageObjects.user.nopCommerce.OrderPageObject;
import pageObjects.user.nopCommerce.PageGenerator;
import pageObjects.user.nopCommerce.RegisterPageObject;
import pageObjects.user.nopCommerce.SearchPageObject;

public class Level_13_Register_Login_Extent_Report_V3 extends BaseTest {
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
	public void User_01_Register_To_System() {
		log.info("User_01_Register - Step 01: Verify Home Page is displayed");
		homePage = PageGenerator.getHomePage(driver);
		verifyTrue(homePage.isHomePageSliderDisplayed());
		
		log.info("User_01_Register - Step 02: Click to Register link");
		registerPage = homePage.clickToRegisterLink();
		verifyTrue(registerPage.isRegisterPageHeadingDisplayed());
		
		log.info("User_01_Register - Step 03: Click to Male radio button");
		registerPage.clickToGenderMaleRadioButton();
		
		log.info("User_01_Register - Step 04: Enter to Firstname textbox");
		registerPage.enterToFirstnameTextbox("John");
		
		log.info("User_01_Register - Step 05: Enter to Lastname textbox");
		registerPage.enterToLastnameTextbox("Terry");
		
		log.info("User_01_Register - Step 06: Enter to Email textbox with value: " + email);
		registerPage.enterToEmailTextbox(email);
		
		log.info("User_01_Register - Step 07: Enter to Password textbox with value:" + password);
		registerPage.enterToPasswordTextbox(password);
		
		log.info("User_01_Register - Step 08: Enter to Confirm Password textbox with value:\" + password");
		registerPage.enterToConfirmPasswordTextbox(password);
		
		log.info("User_01_Register - Step 09: Click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("User_01_Register - Step 10: Verify success message is displayed");
		verifyFalse(registerPage.isSuccessMessageDisplayed());

		log.info("User_01_Register - Step 11: Click to Logout link");
		homePage = registerPage.clickToLogoutLink();

		log.info("User_01_Register - Step 12: Verify Home Page is displayed");
		verifyTrue(homePage.isHomePageSliderDisplayed());
	}

	@Test
	public void User_02_Login_To_System() {
		log.info("User_02_Login - Step 01: Click to Login link");
		loginPage = homePage.clickToLoginLink();

		verifyTrue(loginPage.isLoginPageHeadingDisplayed());
		log.info("User_02_Login - Step 02: Enter to Email textbox with value: " + email);
		loginPage.enterToEmailTextbox(email);
		
		log.info("User_02_Login - Step 03: Enter to Password textbox with value:" + password);
		loginPage.enterToPasswordTextbox(password);
		
		log.info("User_02_Login - Step 04: Click to Login button");
		homePage = loginPage.clickToLoginButton();

		log.info("User_02_Login - Step 05: Verify Home Page is displayed");
		verifyTrue(homePage.isHomePageSliderDisplayed());
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
	SearchPageObject searchPage;
	MyAccountPageObject myAccountPage;
	OrderPageObject orderPage;
}