package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.admin.nopCommerce.ProductDetailsPageUI;

public class ProductDetailsPageObject extends BasePage {
	private WebDriver driver;

	public ProductDetailsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isProductDetailsHeaderDisplayed() {
		waitForElementVisible(driver, ProductDetailsPageUI.HEADER);
		return isElementDisplayed(driver, ProductDetailsPageUI.HEADER);
	}

	public void clickToExpandPanelByName(String panelName) {
		waitForElementVisible(driver, ProductDetailsPageUI.TOOGLE_ICON_BY_CARD_NAME, panelName);
		String toggleIconStatus = getElementAttributeValue(driver, ProductDetailsPageUI.TOOGLE_ICON_BY_CARD_NAME, "class", panelName);
		if (toggleIconStatus.contains("fa-plus")) {
			waitForElementClickable(driver, ProductDetailsPageUI.TOOGLE_ICON_BY_CARD_NAME, panelName);
			clickToElement(driver, ProductDetailsPageUI.TOOGLE_ICON_BY_CARD_NAME, panelName);
		}
	}

	public boolean isPictureUploadedSuccessfullyByFileName(String fileName) {
		fileName = fileName.split("\\.")[0];
		waitForElementVisible(driver, ProductDetailsPageUI.PRODUCT_IMAGE_ADD_NEW_BY_FILE_NAME, fileName);
		return isElementDisplayed(driver, ProductDetailsPageUI.PRODUCT_IMAGE_ADD_NEW_BY_FILE_NAME, fileName);
	}

	public void enterToAltTextbox(String altValue) {
		waitForElementVisible(driver, ProductDetailsPageUI.ALT_TEXTBOX_ADD_NEW_PRODUCT_IMAGE);
		sendkeyToElement(driver, ProductDetailsPageUI.ALT_TEXTBOX_ADD_NEW_PRODUCT_IMAGE, altValue);
	}

	public void enterToTitleTextbox(String titleValue) {
		waitForElementVisible(driver, ProductDetailsPageUI.TITLE_TEXTBOX_ADD_NEW_PRODUCT_IMAGE);
		sendkeyToElement(driver, ProductDetailsPageUI.TITLE_TEXTBOX_ADD_NEW_PRODUCT_IMAGE, titleValue);
	}

	public void clickToUpDownDisplayedOrderTextbox(String selectValue) {
		waitForElementClickable(driver, ProductDetailsPageUI.DISPLAY_ORDER_UP_DOWN, selectValue);
		clickToElement(driver, ProductDetailsPageUI.DISPLAY_ORDER_UP_DOWN, selectValue);
	}

	public void clickToAddProductPictureButton() {
		waitForElementClickable(driver, ProductDetailsPageUI.ADD_PRODUCT_IMAGE_BUTTON);
		clickToElement(driver, ProductDetailsPageUI.ADD_PRODUCT_IMAGE_BUTTON);
	}

	public boolean isPictureImageDisplayed(String imageName, String displayOrder, String imageAlt, String imageTitle) {
		imageName = imageName.replace(" ", "-").toLowerCase();
		waitForElementVisible(driver, ProductDetailsPageUI.PICTURE_TABLE_BY_NAME_ORDER_ALT_TITLE, imageName, displayOrder, imageAlt, imageTitle);
		return isElementDisplayed(driver, ProductDetailsPageUI.PICTURE_TABLE_BY_NAME_ORDER_ALT_TITLE, imageName, displayOrder, imageAlt, imageTitle);
	}

	public ProductListPageObject clickToSaveButton() {
		waitForElementClickable(driver, ProductDetailsPageUI.SAVE_BUTTON);
		clickToElement(driver, ProductDetailsPageUI.SAVE_BUTTON);
		return PageGeneratorManager.getProductListPage(driver);
	}

	public void clickToDeleteButtonAtPictureName(String imageTitle) {
		waitForElementClickable(driver, ProductDetailsPageUI.DELETE_BUTTON_BY_IMAGE_TITLE, imageTitle);
		clickToElement(driver, ProductDetailsPageUI.DELETE_BUTTON_BY_IMAGE_TITLE, imageTitle);
		acceptAlert(driver);
	}

}
