package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.bankGuru.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isRegisterPageHeadingDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.HEADING);
		return isElementDisplayed(driver, RegisterPageUI.HEADING);
	}

	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}

	public void clickToSubmitButton() {
		waitForElementClickable(driver, RegisterPageUI.SUBMIT_BUTTON);
		clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);
	}

	public String getGeneratedUsername() {
		waitForElementVisible(driver, RegisterPageUI.GENERATED_EMAIL);
		return getElementText(driver, RegisterPageUI.GENERATED_EMAIL);
	}

	public String getGeneratedPassword() {
		waitForElementVisible(driver, RegisterPageUI.GENERATED_PASSWORD);
		return getElementText(driver, RegisterPageUI.GENERATED_PASSWORD);
	}

	public void goToLoginPage(String loginPageUrl) {
		openPageUrl(driver, loginPageUrl);
	}
}
