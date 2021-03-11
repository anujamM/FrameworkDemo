package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 50;
	public static long IMPLICIT_WAIT = 30;

	private static String TEST_DATASHEET_PATH = "C:\\Eclipse_Oxy\\myWorkspace\\FrameworkDemo\\src\\main\\java\\com\\crm\\qa\\testdata\\CogementoTestData.xlsx";
	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;

	@FindBy(xpath = "//iframe[@title='Twitter settings iframe']")
	WebElement settingsFrame;

	@FindBy(xpath = "//iframe[@title='Twitter analytics iframe']")
	WebElement analyticsFrame;

	public TestUtil() {
		PageFactory.initElements(driver, this);
	}

	@SuppressWarnings("unused")
	public static void killProcess() throws IOException {

		Runtime rt = Runtime.getRuntime();
		Process proc = rt.exec("taskkill /im firefox.exe /f /t");

	}

	public static int windCount(WebDriver driver) {
		Set<String> windHandles = driver.getWindowHandles();
		int numberOfWindows = windHandles.size();
		System.out.println(numberOfWindows);
		return numberOfWindows;

	}

	public void switchToSettingsFrame() {
		driver.switchTo().frame(settingsFrame);
	}

	public void switchToAnalyticsFrame() {
		driver.switchTo().frame(analyticsFrame);
	}

	public static Object[][] getTestData(String dataSheetName) {
		FileInputStream file = null;

		try {
			file = new FileInputStream(TEST_DATASHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet = book.getSheet(dataSheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}

	public static String takeScreenshotAtEndOfTest() throws IOException {
		// String failedClass = PageFactory.class.getSimpleName();
		String timestamp = new SimpleDateFormat("yyyy-MMM-dd-HH_mm_ss").format(new Date());
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/Screenshots/" + "Ss_" + timestamp + ".png";
		File finaldestination = new File(destination);
		FileUtils.copyFile(srcFile, finaldestination);
		return destination;

	}
}
