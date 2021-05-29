package pageUIs.user.nopCommerce;

public class UserBasePageUI {

	public static final String SEARCH_PAGE_FOOTER = "//div[@class='footer']//a[text()='Search']";
	public static final String ORDER_PAGE_FOOTER = "//div[@class='footer']//a[text()='Orders']";
	public static final String MY_ACCOUNT_PAGE_FOOTER = "//div[@class='footer']//a[text()='My account']";

	// 1 locator (dynamic)
	public static final String DYNAMIC_PAGE_FOOTER = "//div[@class='footer']//a[text()='%s']";
}