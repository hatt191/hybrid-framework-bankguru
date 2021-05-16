package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.admin.nopCommerce.ProductListPageUI;

public class ProductListPageObject extends BasePage {
	private WebDriver driver;

	public ProductListPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isProductListHeaderDisplayed() {
		waitForElementVisible(driver, ProductListPageUI.HEADER);
		return isElementDisplayed(driver, ProductListPageUI.HEADER);
	}

	public void enterToProductNameTextbox(String productName) {
		waitForElementVisible(driver, ProductListPageUI.PRODUCT_NAME_TEXTBOX);
		sendkeyToElement(driver, ProductListPageUI.PRODUCT_NAME_TEXTBOX, productName);
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, ProductListPageUI.SEARCH_BUTTON);
		clickToElement(driver, ProductListPageUI.SEARCH_BUTTON);
	}

	public ProductDetailsPageObject clickToEditButtonByProductName(String productName) {
		waitForElementClickable(driver, ProductListPageUI.EDIT_BUTTON_BY_PRODUCT_NAME, productName);
		clickToElement(driver, ProductListPageUI.EDIT_BUTTON_BY_PRODUCT_NAME, productName);
		return PageGeneratorManager.getProductDetailsPage(driver);
	}

	public boolean isSuccessMessageDisplayed(String messageContent) {
		waitForElementVisible(driver, ProductListPageUI.SUCCESS_MESSAGE_BY_NAME, messageContent);
		return isElementDisplayed(driver, ProductListPageUI.SUCCESS_MESSAGE_BY_NAME, messageContent);
	}

	public boolean isPictureImageUpdated(String imageName, String productName) {
		imageName = imageName.replace(" ", "-").toLowerCase();
		waitForElementVisible(driver, ProductListPageUI.PRODUCT_IMAGE_BY_PRODUCT_NAME_IMAGE, productName, imageName);
		return isElementDisplayed(driver, ProductListPageUI.PRODUCT_IMAGE_BY_PRODUCT_NAME_IMAGE, productName, imageName);
	}

	public void expandSearchPanel() {
		waitForElementVisible(driver, ProductListPageUI.EXPAND_SEARCH_PANEL);
		if (getElementAttributeValue(driver, ProductListPageUI.EXPAND_SEARCH_PANEL + "/div[contains(@class,'search-body')]", "class").contains("closed")) {
			waitForElementClickable(driver, ProductListPageUI.EXPAND_SEARCH_PANEL);
			clickToElement(driver, ProductListPageUI.EXPAND_SEARCH_PANEL);
		}
	}

}
