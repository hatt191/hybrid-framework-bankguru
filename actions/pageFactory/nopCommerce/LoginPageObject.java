package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class LoginPageObject extends BasePageFactory {
	WebDriver driver;

	// UI
	@FindBy(xpath = "//h1[text()='Welcome, Please Sign In!']")
	WebElement loginPageHeader;

	@FindBy(id = "Email")
	WebElement emailTextbox;

	@FindBy(id = "Password")
	WebElement passwordTextbox;

	@FindBy(xpath = "//button[text()='Log in']")
	WebElement loginButton;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isLoginPageHeadingDisplayed() {
		waitForElementVisible(driver, loginPageHeader);
		sleepInSecond(1);
		return isElementDisplayed(driver, loginPageHeader);
	}

	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, email);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
	}

}
