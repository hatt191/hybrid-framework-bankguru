package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.nopCommerce.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isEmailTextboxDisplayed() {
		waitForElementVisible(driver, pageUIs.facebook.RegisterPageUI.EMAIL_TEXTBOX);
		return isElementDisplayed(driver, pageUIs.facebook.RegisterPageUI.EMAIL_TEXTBOX);
	}

	public boolean isConfirmEmailTextboxDisplayed() {
		return isElementDisplayed(driver, pageUIs.facebook.RegisterPageUI.CONFIRM_EMAIL_TEXTBOX);
	}

	public void enterToEmailTextbox(String email) {
		sendkeyToElement(driver, pageUIs.facebook.RegisterPageUI.EMAIL_TEXTBOX, email);
	}

	public boolean isLoginButtonDisplayed() {
		return isElementDisplayed(driver, pageUIs.facebook.RegisterPageUI.LOGIN_BUTTON);
	}

	public boolean isLoginButtonUndisplayed() {
		return isElementUndisplayed(driver, pageUIs.facebook.RegisterPageUI.LOGIN_BUTTON);
	}

	public boolean isConfirmEmailTextboxUndisplayed() {
		return isElementUndisplayed(driver, pageUIs.facebook.RegisterPageUI.CONFIRM_EMAIL_TEXTBOX);
	}

}
