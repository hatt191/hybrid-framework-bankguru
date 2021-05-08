package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.nopCommerce.LoginPageUI;

public class ProductDetailsPageObject extends BasePage {
	private WebDriver driver;
	
	public ProductDetailsPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
