package pageObjects.user.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.nopCommerce.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isHomePageSliderDisplayed() {	
		waitForElementVisible(driver, HomePageUI.HOMEPAGE_SLIDER);
		if (driver.toString().contains("chrome") || driver.toString().contains("edge")) {
			sleepInSecond(1);
		}
		return isElementDisplayed(driver, HomePageUI.HOMEPAGE_SLIDER);
	}

	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGenerator.getRegisterPage(driver);
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		if (driver.toString().contains("chrome") || driver.toString().contains("edge")) {
			sleepInSecond(1);
		}
		return PageGenerator.getLoginPage(driver);
	}

}
