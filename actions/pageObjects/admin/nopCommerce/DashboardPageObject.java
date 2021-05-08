package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.nopCommerce.LoginPageUI;

public class DashboardPageObject extends BasePage {
	private WebDriver driver;
	
	public DashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
