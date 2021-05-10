package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.admin.nopCommerce.BasePageUI;
import pageUI.admin.nopCommerce.DashboardPageUI;
import pageUIs.user.nopCommerce.LoginPageUI;

public class DashboardPageObject extends BasePage {
	private WebDriver driver;
	
	public DashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDashboardHeaderDisplayed() {
		waitForElementVisible(driver, DashboardPageUI.HEADER);
		return isElementDisplayed(driver, DashboardPageUI.HEADER);
	}

	public ProductListPageObject openSubMenuPageByName(String menu, String subMenu) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_MENU_BY_NAME, menu);
		clickToElement(driver, BasePageUI.DYNAMIC_MENU_BY_NAME, menu);
		waitForElementClickable(driver, BasePageUI.DYNAMIC_SUB_MENU_BY_NAME, subMenu);
		clickToElement(driver, BasePageUI.DYNAMIC_SUB_MENU_BY_NAME, subMenu);
		
		return PageGeneratorManager.getProductListPage(driver);
	}

}
