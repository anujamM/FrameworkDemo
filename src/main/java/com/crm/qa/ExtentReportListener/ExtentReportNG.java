package com.crm.qa.ExtentReportListener;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.crm.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportNG extends TestUtil implements IReporter {

	private ExtentReports extent;

	String currentDir = System.getProperty("user.dir");
	String timestamp = new SimpleDateFormat("yyyy-MMM-dd-HH_mm_ss").format(new Date());

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		// extent = new ExtentReports(outputDirectory + File.separator + "Extent.html",
		// true);
		extent = new ExtentReports(currentDir + "/ExtentReports/" + "Extent_" + timestamp + ".html", true);

		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();

			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();

				try {
					buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			extent.flush();
			extent.close();
		}
	}

	private void buildTestNodes(IResultMap tests, LogStatus status) throws IOException {
		ExtentTest test;

		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				test = extent.startTest(result.getMethod().getMethodName());

				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getEndMillis()));

				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);

				if (result.getStatus() == ITestResult.FAILURE) { 
					test.log(status.FAIL, result.getThrowable());
					String screenshotPath = ExtentReportNG.takeScreenshotAtEndOfTest();
					test.log(status.FAIL, test.addScreenCapture(screenshotPath));
				}
				else if(result.getStatus() == ITestResult.SKIP) {
					test.log(status.SKIP, "Test Case Skipped is "+result.getName());
				}
				else {
					test.log(status.PASS, "Test " + status.toString().toLowerCase() + "ed");
				}

				extent.endTest(test);
			}
		}
	}


	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
}