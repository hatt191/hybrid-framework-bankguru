package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.admin.nopCommerce.AdminBasePageUI;
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

}
