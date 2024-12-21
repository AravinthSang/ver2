package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReportUtility implements ITestListener{
	public ExtentSparkReporter sparkReporter;
	public ExtentReports report;
	public ExtentTest test;
	String reportName;

	public void onStart(ITestContext context) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date date = new Date();
		String timestamp = df.format(date);

		reportName = "TestReport-" + timestamp + ".html";
		sparkReporter = new ExtentSparkReporter("./reports/" + reportName);
		sparkReporter.config().setDocumentTitle("openmrs");
		sparkReporter.config().setReportName("openmrs_test_execution_report");
		sparkReporter.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(sparkReporter);
		report.setSystemInfo("Application", "openmrs.com");
		report.setSystemInfo("User", System.getProperty("user.name"));
		report.setSystemInfo("Environment", "QA");
		report.setSystemInfo("os", "windows10");
		
	}
	public void onTestSuccess(ITestResult result) {
		test = report.createTest(result.getTestClass().getName());
		test.log(Status.PASS, result.getName() + " successfully exexuted");
	}

	public void onTestFailure(ITestResult result) {
		test = report.createTest(result.getTestClass().getName());
		test.log(Status.FAIL, result.getName() + " failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}

	public void onTestSkipped(ITestResult result) {
		test = report.createTest(result.getTestClass().getName());
		test.log(Status.SKIP, result.getName() + " skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}

	public void onFinish(ITestContext context) {

		report.flush();
	}

}
