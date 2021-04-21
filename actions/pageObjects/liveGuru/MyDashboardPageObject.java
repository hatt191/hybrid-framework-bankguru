package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.MyDashboardPageUI;

public class MyDashboardPageObject extends BasePage {
	private WebDriver driver;
	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isMyDashboardHeaderDisplayed() {
		waitForElementVisible(driver, MyDashboardPageUI.HEADER_TEXT);
		return isElementDisplayed(driver, MyDashboardPageUI.HEADER_TEXT);
	}

}
