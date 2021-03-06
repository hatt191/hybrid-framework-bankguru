package pageObjects.user.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.user.nopCommerce.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Verify Login Page displayed")
	public boolean isLoginPageHeadingDisplayed() {	
		waitForElementVisible(driver, LoginPageUI.HEADING);
		if (driver.toString().contains("chrome") || driver.toString().contains("edge")) {
			sleepInSecond(1);
		}
		return isElementDisplayed(driver, LoginPageUI.HEADING);
	}
	
	@Step("Enter to Email textbox with value {0}")
	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}

	@Step("Enter to Password textbox with value {0}")
	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	@Step("Click to Login Button")
	public HomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

	public HomePageObject openHomePage() {
		waitForElementClickable(driver, LoginPageUI.HOMEPAGE_IMAGE);
		clickToElement(driver, LoginPageUI.HOMEPAGE_IMAGE);
		return PageGeneratorManager.getHomePage(driver);
	}

}
