package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.admin.nopCommerce.DashboardPageObject;
import pageObjects.admin.nopCommerce.LoginPageObject;
import pageObjects.admin.nopCommerce.PageGeneratorManager;
import pageObjects.admin.nopCommerce.ProductDetailsPageObject;
import pageObjects.admin.nopCommerce.ProductListPageObject;

public class Level_10_Admin_Upload extends BaseTest {
	WebDriver driver;
	String productName = "Adobe Photoshop CS4" ;
	String productImage = "product-name.png";
	String productAlt = "Avatar Alt";
	String productTitle = "Avatar Title";
	String productOrderDisplay = "0";

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {

		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);

		loginPage.enterToEmailTextbox("admin@yourstore.com");
		loginPage.enterToPasswordTextbox("admin");
		dashboardPage = loginPage.clickToLoginButton();
		Assert.assertTrue(dashboardPage.isDashboardHeaderDisplayed());

		dashboardPage.openSubMenuPageByName(driver, "Catalog", "Products");
		productListPage = PageGeneratorManager.getProductListPage(driver);
		Assert.assertTrue(productListPage.isProductListHeaderDisplayed());
		
		productListPage.expandSearchPanel();
		productListPage.enterToProductNameTextbox(productName);
		productListPage.clickToSearchButton();

		productDetailsPage = productListPage.clickToEditButtonByProductName(productName);
		Assert.assertTrue(productDetailsPage.isProductDetailsHeaderDisplayed());

	}

	@Test
	public void Admin_01_Upload_File() {
		productDetailsPage.clickToExpandPanelByName("Pictures");
		productDetailsPage.uploadFileAtCardName(driver, "pictures", productImage);
		Assert.assertTrue(productDetailsPage.isPictureUploadedSuccessfullyByFileName(productImage));

		productDetailsPage.enterToAltTextbox(productAlt);
		productDetailsPage.enterToTitleTextbox(productTitle);
		//productDetailsPage.enterToDisplayedOrderTextbox(productOrderDisplay);

		productDetailsPage.clickToAddProductPictureButton();

		Assert.assertTrue(productDetailsPage.isPictureImageDisplayed(productName, productOrderDisplay, productAlt, productTitle));
		productListPage = productDetailsPage.clickToSaveButton();
		Assert.assertTrue(productListPage.isSuccessMessageDisplayed("The product has been updated successfully."));
		productListPage.expandSearchPanel();
		productListPage.enterToProductNameTextbox(productName);
		productListPage.clickToSearchButton();

		Assert.assertTrue(productListPage.isPictureImageUpdated(productName, productName));

		productDetailsPage = productListPage.clickToEditButtonByProductName(productName);
		Assert.assertTrue(productDetailsPage.isProductDetailsHeaderDisplayed());
		productDetailsPage.clickToExpandPanelByName("Pictures");

		productDetailsPage.clickToDeleteButtonAtPictureName(productTitle);
		Assert.assertTrue(productDetailsPage.isMessageDisplayedInEmptyTable(driver, "productpictures"));
		productListPage = productDetailsPage.clickToSaveButton();
		Assert.assertTrue(productListPage.isSuccessMessageDisplayed("The product has been updated successfully"));
		productListPage.expandSearchPanel();
		productListPage.enterToProductNameTextbox(productName);
		productListPage.clickToSearchButton();

		Assert.assertTrue(productListPage.isPictureImageUpdated("default-image", productName));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	ProductListPageObject productListPage;
	ProductDetailsPageObject productDetailsPage;
}
