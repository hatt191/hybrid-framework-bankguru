package basic;

public class Dynamic_Locator {

	public static void main(String[] args) {
		String SEARCH_PAGE_FOOTER = "//div[@class='footer']//a[text()='Search']";
		String ORDER_PAGE_FOOTER = "//div[@class='footer']//a[text()='Orders']";
		String MY_ACCOUNT_PAGE_FOOTER = "//div[@class='footer']//a[text()='My account']";
		String DYNAMIC_PAGE_FOOTER = "//div[@class='footer']//a[text()='%s']";
		String DYNAMIC_SIDEBAR_TEXT = "//div[@class='footer']//a[text()='%s']//a[@id='%s']";
	
		//Page Object
		clickToElement(ORDER_PAGE_FOOTER);
		clickToElement(MY_ACCOUNT_PAGE_FOOTER);
		clickToElement(SEARCH_PAGE_FOOTER);
		
		clickToElement(DYNAMIC_PAGE_FOOTER, "Orders");
		clickToElement(DYNAMIC_PAGE_FOOTER, "My account");
		clickToElement(DYNAMIC_PAGE_FOOTER, "Search");
		clickToElement(DYNAMIC_SIDEBAR_TEXT, "Account", "Test");
	}

//	public static void clickToElement(String locator) {
//		System.out.println(locator);
//	}
//	
//	public static void clickToElement(String locator, String pageName) {
//		System.out.println(String.format(locator, pageName));
//	}
	
	public static void clickToElement(String locator, String... params) {
		System.out.println(String.format(locator, (Object[]) params));
	}
}
