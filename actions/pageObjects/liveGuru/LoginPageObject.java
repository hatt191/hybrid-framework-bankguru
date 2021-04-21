package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}
	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}
	
	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}
	
	public void loginToSystem(String email, String password) {
		enterToEmailTextbox(email);
		enterToPasswordTextbox(password);
		clickToLoginButton();
	}
	public String getEmptyEmailErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.EMPTY_EMAIL_ERROR_MSG);
		return getElementText(driver, LoginPageUI.EMPTY_EMAIL_ERROR_MSG);
	}
	
	public String getEmptyPasswordErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.EMPTY_PASSWORD_ERROR_MSG);
		return getElementText(driver, LoginPageUI.EMPTY_PASSWORD_ERROR_MSG);
	}
	
	public String getInvalidEmailErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.INVALID_EMAIL_ERROR_MSG);
		return getElementText(driver, LoginPageUI.INVALID_EMAIL_ERROR_MSG);
	}
	
	public String getInvalidPasswordErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.INVALID_PASSWORD_ERROR_MSG);
		return getElementText(driver, LoginPageUI.INVALID_PASSWORD_ERROR_MSG);
	}
	
	public String getInvalidEmailOrPasswordErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.INVALID_CREDENTIALS_MSG);
		return getElementText(driver, LoginPageUI.INVALID_CREDENTIALS_MSG);
	}

}
