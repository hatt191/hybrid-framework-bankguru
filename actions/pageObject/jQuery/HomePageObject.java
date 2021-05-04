package pageObject.jQuery;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.jQuery.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPageByNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGING_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGING_BY_NUMBER, pageNumber);
	}

	public boolean isPageActiveByNumber(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGING_BY_NUMBER_ACTIVE, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGING_BY_NUMBER_ACTIVE, pageNumber);
	}

	public void inputToHeaderTextboxByName(String headerName, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, headerName);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, value, headerName);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, Keys.ENTER, headerName);
		sleepInSecond(2);
	}

	public void clickToIconByCountryName(String countryName, String iconAction) {
		waitForElementClickable(driver, HomePageUI.ICON_BY_COUNTRY_NAME, countryName, iconAction);
		clickToElement(driver, HomePageUI.ICON_BY_COUNTRY_NAME, countryName, iconAction);
		sleepInSecond(2);
	}

	public boolean isRowValueDisplayed(String females, String country, String males, String total) {
		waitForElementVisible(driver, HomePageUI.ROW_VALUE_BY_FEMALES_COUNTRY_MALES_TOTAL, females, country, males, total);
		return isElementDisplayed(driver, HomePageUI.ROW_VALUE_BY_FEMALES_COUNTRY_MALES_TOTAL, females, country, males, total);
	}

}
