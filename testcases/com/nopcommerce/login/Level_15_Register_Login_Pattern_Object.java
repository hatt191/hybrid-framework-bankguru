package com.nopcommerce.login;

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
import pageObjects.user.nopCommerce.PageGeneratorManager;
import pageObjects.user.nopCommerce.RegisterPageObject;
import pageObjects.user.nopCommerce.SearchPageObject;

public class Level_15_Register_Login_Pattern_Object extends BaseTest {
	WebDriver driver;
	String email, password, day, month, year;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition: Open browser '" + browserName + "' and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		

		email = getRandomEmail();
		password = "123456";
		day = "15";
		month = "March";
		year = "1995";
				
	}

	@Test
	public void Login_01_Register_To_System() {
		log.info("User_01_Register - Step 01: Verify Home Page is displayed");
		homePage = PageGeneratorManager.getHomePage(driver);
		verifyTrue(homePage.isHomePageSliderDisplayed());
		
		log.info("User_01_Register - Step 02: Click to Register link");
		homePage.openHeaderPageByName(driver, "Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		verifyTrue(registerPage.isRegisterPageHeadingDisplayed());
		
		log.info("User_01_Register - Step 03: Click to Male radio button");
		registerPage.clickToRadioBtnByID(driver, "gender-male");
		
		log.info("User_01_Register - Step 04: Enter to Firstname textbox");
		registerPage.enterToTextboxByID(driver, "FirstName","John");
		
		log.info("User_01_Register - Step 05: Enter to Lastname textbox");
		registerPage.enterToTextboxByID(driver, "LastName","Terry");
		
		log.info("User_01_Register - Step 06: Enter to Email textbox with value: " + email);
		registerPage.enterToTextboxByID(driver, "Email", email);
		
		log.info("User_01_Register - Step 07: Enter to Password textbox with value:" + password);
		registerPage.enterToTextboxByID(driver, "Password", password);
		
		log.info("User_01_Register - Step 08: Enter to Confirm Password textbox with value:\" + password");
		registerPage.enterToTextboxByID(driver, "ConfirmPassword", password);
		
		log.info("User_01_Register - Step 09: Select item in date dropdownlist");
		registerPage.selectDDLByName(driver, "DateOfBirthDay", day);
		
		log.info("User_01_Register - Step 10: Select item in month dropdownlist");
		registerPage.selectDDLByName(driver, "DateOfBirthMonth", month);
		
		log.info("User_01_Register - Step 11: Select item in year dropdownlist");
		registerPage.selectDDLByName(driver, "DateOfBirthYear", year);
		
		log.info("User_01_Register - Step 12: Click to Register button");
		registerPage.clickToButtonByText(driver, "Register");
		
		log.info("User_01_Register - Step 13: Verify success message is displayed");
		verifyTrue(registerPage.isSuccessMessageDisplayed());

		log.info("User_01_Register - Step 14: Click to Logout link");
		registerPage.openHeaderPageByName(driver, "Log out");
		homePage = PageGeneratorManager.getHomePage(driver); 
		
		log.info("User_01_Register - Step 15: Verify Home Page is displayed");
		verifyTrue(homePage.isHomePageSliderDisplayed());
	}

	@Test
	public void Login_02_Login_To_System() {
		log.info("User_02_Login - Step 01: Click to Login link");
		homePage.openHeaderPageByName(driver, "Log in");
		loginPage = PageGeneratorManager.getLoginPage(driver);
		verifyTrue(loginPage.isLoginPageHeadingDisplayed());
		
		log.info("User_02_Login - Step 02: Enter to Email textbox with value: " + email);
		loginPage.enterToTextboxByID(driver, "Email", email);
		
		log.info("User_02_Login - Step 03: Enter to Password textbox with value:" + password);
		loginPage.enterToTextboxByID(driver, "Password", password);
		
		log.info("User_02_Login - Step 04: Click to Login button");
		loginPage.clickToButtonByText(driver, "Log in");
		homePage = PageGeneratorManager.getHomePage(driver);

		log.info("User_02_Login - Step 05: Verify Home Page is displayed");
		verifyTrue(homePage.isHomePageSliderDisplayed());
	}

	@Parameters({"browser"})
	@AfterClass(alwaysRun = true)
	public void afterClass(String browserName) {
		log.info("Post-Condition: Close browser '" + browserName + "'");
		cleanBrowserAndDriver();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	SearchPageObject searchPage;
	MyAccountPageObject myAccountPage;
	OrderPageObject orderPage;
}
