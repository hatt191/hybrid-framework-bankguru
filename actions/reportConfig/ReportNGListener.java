package reportConfig;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import commons.BaseTest;
import commons.GlobalConstants;

public class ReportNGListener implements ITestListener {
	String projectScreenshot = GlobalConstants.PROJECT_PATH + File.separator + "ReportNGScreenShots" + File.separator;

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");

		Object testClass = result.getInstance();
		WebDriver driver = ((BaseTest) testClass).getWebDriver();

		String screenshotPath = captureScreenshot(driver, result.getName());
		Reporter.getCurrentTestResult();
		
		/*
		 *	var newTab = window.open();
			newTab.document.body.innerHTML = '<img src="data:image/png;base64," width="100px" height="100px">';
		 */
		Reporter.log("<br><a target=\"_blank\" href=\"data:image/png;base64," + screenshotPath + "\">" + "<img src=\"data:image/png;base64," + screenshotPath + "\" " + "height='100' width='150'/> " + "</a></br>");
		Reporter.setCurrentTestResult(null);
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public String captureScreenshot(WebDriver driver, String screenshotName) {
			//Calendar calendar = Calendar.getInstance();
			//SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			//File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
			//String screenPath = projectScreenshot + screenshotName + "_" + formater.format(calendar.getTime()) + ".png";
			//FileUtils.copyFile(source, new File(screenPath));
			return screenshotBase64;
	}

}
