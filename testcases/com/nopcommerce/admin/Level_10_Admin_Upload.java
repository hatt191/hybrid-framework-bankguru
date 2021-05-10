package com.nopcommerce.admin;

import java.util.Random;

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

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {

		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);

		loginPage.enterToEmailTextbox("admin@yourstore.com");
		loginPage.enterToPasswordTextbox("admin");
		dashboardPage = loginPage.clickToLoginButton();
		Assert.assertTrue(dashboardPage.isDashboardHeaderDisplayed());

		productListPage = dashboardPage.openSubMenuPageByName("Catalog", "Products");
		Assert.assertTrue(productListPage.isProductListHeaderDisplayed());
		productListPage.enterToProductNameTextbox("Adobe Photoshop CS4");
		productListPage.clickToSearchButton();

		productDetailsPage = productListPage.clickToEditButtonByProductName("Adobe Photoshop CS4");
		Assert.assertTrue(productDetailsPage.isProductDetailsHeaderDisplayed());

	}

	@Test
	public void Admin_01_Upload_File() {
		productDetailsPage.clickToExpandPanelByName("Pictures");
		productDetailsPage.uploadPictureByFileName("");
		Assert.assertTrue(productDetailsPage.isPictureUploadedSuccessfullyByFileName(""));

		productDetailsPage.enterToAltTextbox("");
		productDetailsPage.enterToTitleTextbox("");
		productDetailsPage.enterToDisplayedOrderTextbox("");

		productDetailsPage.clickToAddProductPictureButton();

		Assert.assertTrue(productDetailsPage.isPictureImageDisplayed("", "", "", ""));
		productListPage = productDetailsPage.clickToSaveButton();
		Assert.assertTrue(productListPage.isSuccessMessageDisplayed("The product has been updated successfully"));
		productListPage.enterToProductNameTextbox("Adobe Photoshop CS4");
		productListPage.clickToSearchButton();

		Assert.assertTrue(productListPage.isPictureImageUpdated("adobe-photoshop-cs4", "Adobe Photoshop CS4"));

		productDetailsPage = productListPage.clickToEditButtonByProductName("Adobe Photoshop CS4");
		Assert.assertTrue(productDetailsPage.isProductDetailsHeaderDisplayed());
		productDetailsPage.clickToExpandPanelByName("Pictures");

		productDetailsPage.clickToDeleteButtonAtPictureName("");
		Assert.assertTrue(productDetailsPage.isMessageDisplayedInTable("No data available in table"));
		productListPage = productDetailsPage.clickToSaveButton();
		Assert.assertTrue(productListPage.isSuccessMessageDisplayed("The product has been updated successfully"));
		productListPage.enterToProductNameTextbox("Adobe Photoshop CS4");
		productListPage.clickToSearchButton();

		Assert.assertTrue(productListPage.isPictureImageUpdated("default-image", "Adobe Photoshop CS4"));
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
