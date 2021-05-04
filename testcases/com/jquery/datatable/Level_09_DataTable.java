package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.HomePageObject;

public class Level_09_DataTable extends BaseTest {
	WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {

		driver = getBrowserDriver(browserName, appUrl);
		homePage = new HomePageObject(driver);
	}

	// @Test
	public void Table_01_Paging() {
		//homePage.openPageUrl(driver, "https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");

		homePage.openPageByNumber("15");
		Assert.assertTrue(homePage.isPageActiveByNumber("15"));
		homePage.openPageByNumber("5");
		Assert.assertTrue(homePage.isPageActiveByNumber("5"));
	}

	//@Test
	public void Table_02_Input_To_Header() {
		// Input to textbox
		homePage.inputToHeaderTextboxByName("Females", "777");
		homePage.refreshCurrentPage(driver);
		homePage.inputToHeaderTextboxByName("Males", "803");
		homePage.refreshCurrentPage(driver);
		homePage.inputToHeaderTextboxByName("Country", "Antigua and Barbuda");
		homePage.refreshCurrentPage(driver);
	}

	//@Test
	public void Table_03_Actions() {
		// Click to icon: need to be based on a unique data
		homePage.clickToIconByCountryName("Angola", "qgrd-remove-row-btn");
		homePage.clickToIconByCountryName("Albania", "qgrd-edit-row-btn");
	}

	//@Test
	public void Table_04_Verify_Row_Value() {
		homePage.inputToHeaderTextboxByName("Country", "Angola");
		Assert.assertTrue(homePage.isRowValueDisplayed("276880", "Angola", "276472", "553353"));
		homePage.refreshCurrentPage(driver);
		
		homePage.inputToHeaderTextboxByName("Country", "Algeria");
		Assert.assertTrue(homePage.isRowValueDisplayed("283821", "Algeria", "295140", "578961"));
	}
	
	@Test
	public void Table_05_Input_To_Row_Textbox() {
		homePage.openPageUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		homePage = new HomePageObject(driver);
		
		homePage.inputToHeaderTextboxByName("Country", "Angola");
		Assert.assertTrue(homePage.isRowValueDisplayed("276880", "Angola", "276472", "553353"));
		homePage.refreshCurrentPage(driver);
		
		homePage.inputToHeaderTextboxByName("Country", "Algeria");
		Assert.assertTrue(homePage.isRowValueDisplayed("283821", "Algeria", "295140", "578961"));
	}

	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	HomePageObject homePage;

}
