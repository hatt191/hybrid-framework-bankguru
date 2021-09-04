package com.nopcommerce.login;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Login;

import commons.BaseTest;
import pageObjects.user.nopCommerce.HomePageObject;
import pageObjects.user.nopCommerce.LoginPageObject;
import pageObjects.user.nopCommerce.MyAccountPageObject;
import pageObjects.user.nopCommerce.OrderPageObject;
import pageObjects.user.nopCommerce.PageGeneratorManager;
import pageObjects.user.nopCommerce.RegisterPageObject;
import pageObjects.user.nopCommerce.SearchPageObject;

public class Level_14_Register_Login_Share_State extends BaseTest {
	WebDriver driver;
	String email, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition: Open browser '" + browserName + "' and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("Pre-Condition - Step 01: Click to Login link");
		loginPage = homePage.clickToLoginLink();
		verifyTrue(loginPage.isLoginPageHeadingDisplayed());
		
		log.info("Pre-Condition - Step 02: Set login page cookie");
		loginPage.setAllCookies(driver, Common_01_Login.loginPageCookie);
		loginPage.sleepInSecond(3);
		loginPage.refreshCurrentPage(driver);
		
		log.info("Pre-Condition - Step 03: Click to HomePage image");
		homePage = loginPage.openHomePage();
		
		log.info("Pre-Condition - Step 04: Verify Home Page is displayed");
		verifyTrue(homePage.isHomePageSliderDisplayed());
	}

	@Test
	public void User_01_Create_New_Account() {
		System.out.println("test 01");
	}
	
	@Test
	public void User_02_Edit_Account() {
		System.out.println("test 02");
	}
	
	@Test
	public void User_03_Delete_Account() {
		System.out.println("test 03");
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
