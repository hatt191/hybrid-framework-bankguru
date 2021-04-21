package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;
	
	// Ham khoi tao - Contructor
	// Khi new class len thi no se nhay vao ham khoi tao dau tien
	// Cung ten voi Class
	// Khong co kieu tra ve
	// 1 Class co the co nhieu ham khoi tao, nhung phai khac nhau ve so tham so
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isHomePageSliderDisplayed() {	
		waitForElementVisible(driver, HomePageUI.HOMEPAGE_SLIDER);
		sleepInSecond(1);
		return isElementDisplayed(driver, HomePageUI.HOMEPAGE_SLIDER);
	}

	public void clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
	}

	public void clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
	}

}
