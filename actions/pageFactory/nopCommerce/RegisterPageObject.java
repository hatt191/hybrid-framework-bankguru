package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageUIs.user.nopCommerce.RegisterPageUI;

public class RegisterPageObject extends BasePageFactory {
	WebDriver driver;

	// UI
	@FindBy(xpath = "//h1[text()='Register']")
	WebElement registerPageHeader;

	@FindBy(id = "gender-male")
	WebElement genderMaleRadio;

	@FindBy(id = "FirstName")
	WebElement firstNameTextbox;

	@FindBy(id = "LastName")
	WebElement lastNameTextbox;

	@FindBy(id = "Email")
	WebElement emailTextbox;

	@FindBy(id = "Password")
	WebElement passwordTextbox;

	@FindBy(id = "ConfirmPassword")
	WebElement confirmTextbox;

	@FindBy(id = "register-button")
	WebElement registerButton;

	@FindBy(xpath = "//div[@class='result' and text()='Your registration completed']")
	WebElement successMessage;

	@FindBy(className = "ico-logout")
	WebElement logoutLink;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isRegisterPageHeadingDisplayed() {
		waitForElementVisible(driver, registerPageHeader);
		sleepInSecond(1);
		return isElementDisplayed(driver, registerPageHeader);
	}

	public void clickToGenderMaleRadioButton() {
		waitForElementClickable(driver, genderMaleRadio);
		clickToElement(driver, genderMaleRadio);
	}

	public void enterToFirstnameTextbox(String firstName) {
		waitForElementVisible(driver, firstNameTextbox);
		sendkeyToElement(driver, firstNameTextbox, firstName);
	}

	public void enterToLastnameTextbox(String lastName) {
		waitForElementVisible(driver, lastNameTextbox);
		sendkeyToElement(driver, lastNameTextbox, lastName);
	}

	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, email);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
	}

	public void enterToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmTextbox);
		sendkeyToElement(driver, confirmTextbox, confirmPassword);
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public boolean isSuccessMessageDisplayed() {
		waitForElementVisible(driver, successMessage);
		return isElementDisplayed(driver, successMessage);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, logoutLink);
		sleepInSecond(1);
		clickToElement(driver, logoutLink);
	}

}
