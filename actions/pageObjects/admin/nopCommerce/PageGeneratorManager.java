package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	private static LoginPageObject loginPage;
	private static DashboardPageObject dashboardPage;
	private static ProductListPageObject productListPage;
	private static ProductDetailsPageObject productDetailsPage;
	
	private PageGeneratorManager() {
		
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		if (loginPage == null) {
			loginPage = new LoginPageObject(driver);
		}
		return loginPage;
	}
	
	public static DashboardPageObject getDashboardPage(WebDriver driver) {
		if (dashboardPage == null) {
			dashboardPage = new DashboardPageObject(driver);
		}
		return dashboardPage;
	}
	
	public static ProductListPageObject getProductListPage(WebDriver driver) {
		if (productListPage == null) {
			productListPage = new ProductListPageObject(driver);
		}
		return productListPage;
	}
	
	public static ProductDetailsPageObject getProductDetailsPage(WebDriver driver) {
		if (productDetailsPage == null) {
			productDetailsPage = new ProductDetailsPageObject(driver);
		}
		return productDetailsPage;
	}
}
