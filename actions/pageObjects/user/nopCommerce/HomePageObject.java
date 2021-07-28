package pageObjects.user.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.user.nopCommerce.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Verify Home Page is displayed")
	public boolean isHomePageSliderDisplayed() {	
		waitForElementVisible(driver, HomePageUI.HOMEPAGE_SLIDER);
		if (driver.toString().contains("chrome") || driver.toString().contains("edge")) {
			sleepInSecond(1);
		}
		return isElementDisplayed(driver, HomePageUI.HOMEPAGE_SLIDER);
	}

	@Step("Click to Register Link")
	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGenerator.getRegisterPage(driver);
	}

	@Step("Click to Login link")
	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		if (driver.toString().contains("chrome") || driver.toString().contains("edge")) {
			sleepInSecond(1);
		}
		return PageGenerator.getLoginPage(driver);
	}

}
