package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.admin.nopCommerce.ProductListPageUI;
import pageUIs.user.nopCommerce.LoginPageUI;

public class ProductListPageObject extends BasePage {
	private WebDriver driver;
	
	public ProductListPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isProductListHeaderDisplayed() {
		waitForElementVisible(driver, ProductListPageUI.HEADER);
		return isElementDisplayed(driver, ProductListPageUI.HEADER);
	}

	public void enterToProductNameTextbox(String string) {
		// TODO Auto-generated method stub
		
	}

	public void clickToSearchButton() {
		// TODO Auto-generated method stub
		
	}

	public ProductDetailsPageObject clickToEditButtonByProductName(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isSuccessMessageDisplayed(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isPictureImageUpdated(String string, String string2) {
		// TODO Auto-generated method stub
		return false;
	}

}
