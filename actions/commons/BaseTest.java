package commons;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	private String projectLocation = System.getProperty("user.dir");
	protected final Log log;
	
	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}
	
	private enum BROWSER {
		CHROME, FIREFOX, IE, SAFARI, EGDE_LEGACY, EDGE_CHROMIUM, H_CHROME, H_FIREFOX;
	}
	
	private enum OS {
		WINDOWS, MAC_OSX, LINUX;
	}
	
	private enum PLATFORM {
		ANDROID, IOS;
	}
	
	protected WebDriver getBrowserDriver(String browserName) {
		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
		
		switch (browser) {
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		default:
			break;
		}
		
		driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
		if (browser == BROWSER.CHROME) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser == BROWSER.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			throw new RuntimeException("Incorrect browser name!");
		}
		
		driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appUrl);
		return driver;
	}
	
	public static String getDirectorySlash(String folderName) {
		String separator = File.separator;
		return separator + folderName + separator;
	}
	
	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}
	
	private long longTimeout = GlobalConstants.LONG_TIMEOUT;
	
}
