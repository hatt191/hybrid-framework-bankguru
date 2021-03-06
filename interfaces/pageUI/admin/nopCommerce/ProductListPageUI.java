package pageUI.admin.nopCommerce;

public class ProductListPageUI {
	
	public static final String HEADER = "//h1[contains(text(),'Products')]";
	public static final String PRODUCT_NAME_TEXTBOX = "//input[@id='SearchProductName']";
	public static final String SEARCH_BUTTON = "//button[@id='search-products']";
	public static final String EDIT_BUTTON_BY_PRODUCT_NAME = "//td[text()='%s']/following-sibling::td/a[contains(string(),'Edit')]";
	public static final String SUCCESS_MESSAGE_BY_NAME = "//div[contains(@class,'alert-success') and contains(string(),'%s')]";
	public static final String PRODUCT_IMAGE_BY_PRODUCT_NAME_IMAGE = "//td[text()='%s']/preceding-sibling::td/img[contains(@src,'%s')]";
	public static final String EXPAND_SEARCH_PANEL = "//div[contains(@class,'card-search')]//div[@class='card-body']";
	
}
