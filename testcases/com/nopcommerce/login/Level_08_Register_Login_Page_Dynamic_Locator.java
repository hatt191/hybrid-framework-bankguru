package com.nopcommerce.login;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.MyAccountPageObject;
import pageObjects.nopCommerce.OrderPageObject;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.RegisterPageObject;
import pageObjects.nopCommerce.SearchPageObject;

public class Level_08_Register_Login_Page_Dynamic_Locator extends BaseTest {
	WebDriver driver;
	String email, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {

		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGenerator.getHomePage(driver);

		email = getRandomEmail();
		password = "123456";
	}

	@Test
	public void Login_01_Register_To_System() {
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
		registerPage = homePage.clickToRegisterLink();

		Assert.assertTrue(registerPage.isRegisterPageHeadingDisplayed());
		registerPage.clickToGenderMaleRadioButton();
		registerPage.enterToFirstnameTextbox("John");
		registerPage.enterToLastnameTextbox("Terry");
		registerPage.enterToEmailTextbox(email);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());

		homePage = registerPage.clickToLogoutLink();

		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}

	@Test
	public void Login_02_Login_To_System() {
		loginPage = homePage.clickToLoginLink();

		Assert.assertTrue(loginPage.isLoginPageHeadingDisplayed());
		loginPage.enterToEmailTextbox(email);
		loginPage.enterToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}

	@Test
	public void Login_03_Open_Page_At_Footer() {
		// Home Page -> Search Page
		searchPage = (SearchPageObject) homePage.getFooterPageByName(driver, "Search");

		// Search Page -> My Account Page
		myAccountPage = (MyAccountPageObject) searchPage.getFooterPageByName(driver, "My account");

		// My Account Page --> Order Page
		orderPage = (OrderPageObject) myAccountPage.getFooterPageByName(driver, "Orders");

		// Order Page -> My Account Page
		myAccountPage = (MyAccountPageObject) orderPage.getFooterPageByName(driver, "My account");

		// My Account Page -> Search Page
		searchPage = (SearchPageObject) myAccountPage.getFooterPageByName(driver, "Search");

	}

	@Test
	public void Login_04_Open_Page_At_Footer() {
		// Search Page -> My Account Page
		searchPage.openFooterPageByName(driver, "My account");
		myAccountPage = PageGenerator.getMyAccountPage(driver);

		// My Account Page --> Order Page
		myAccountPage.openFooterPageByName(driver, "Orders");
		orderPage = PageGenerator.getOrderPage(driver);

		// My Account Page -> Search Page
		orderPage.openFooterPageByName(driver, "Search");
		searchPage = PageGenerator.getSearchPage(driver);
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
