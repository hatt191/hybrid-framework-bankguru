package reportConfig;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestListener implements ITestListener {
	private static ExtentReports extent = ExtentManager.createInstance();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@Override
	public synchronized void onStart(ITestContext context) {
		
	}

	@Override
	public synchronized void onFinish(ITestContext context) {
		extent.flush();
	}

	@Override
	public synchronized void onTestStart(ITestResult result) {
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
		test.set(extentTest);
	}

	@Override
	public synchronized void onTestSuccess(ITestResult result) {
		test.get().pass("Test passed");
	}

	@Override
	public synchronized void onTestFailure(ITestResult result) {
		test.get().fail(result.getThrowable());
	}

	@Override
	public synchronized void onTestSkipped(ITestResult result) {
		test.get().skip(result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
	}
}
