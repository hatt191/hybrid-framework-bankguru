package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.nopCommerce.LoginPageUI;

public class ProductListPageObject extends BasePage {
	private WebDriver driver;
	
	public ProductListPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
