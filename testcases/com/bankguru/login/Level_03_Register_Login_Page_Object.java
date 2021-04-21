package com.bankguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.RegisterPageObject;

public class Level_03_Register_Login_Page_Object {
	WebDriver driver;
	String username, password, loginPageUrl;
	String projectLocation = System.getProperty("user.dir");

	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.chrome.driver", projectLocation + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void Login_01_Register_To_System() {
		driver.get("http://demo.guru99.com/v4/index.php");
		loginPage = new LoginPageObject(driver);

		loginPageUrl = loginPage.getLoginPageUrl();
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
	public void cleanBrowser() {
		driver.quit();
	}

	public String getRandomEmail() {
		Random rand = new Random();
		return "hatt11" + rand.nextInt(99999) + "@live.com";
	}

	LoginPageObject loginPage;
	RegisterPageObject registerPage;
}