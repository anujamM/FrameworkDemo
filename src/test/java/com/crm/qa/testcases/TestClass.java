package com.crm.qa.testcases;
//

import java.util.concurrent.TimeUnit;

//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//public class TestClass {
//	
//	static WebDriver driver;
//	static List<WebElement> arrlist  = new ArrayList<WebElement>();
//	
//	public void swap(int a, int b) {
//		a = a*b;
//		b = a/b;
//		a = a/b;
//		
//		System.out.println("Now the value of a is: " + a);
//		System.out.println("Now the value of b is: " + b);
//	}
//	
//	public static void main (String args[]) {
//		TestClass tc = new TestClass();
//		System.out.println("The value of a is: 20");
//		System.out.println("The value of a is: 25");
//		tc.swap(20, 25);
//	}
//	
//	public static void takesScreenshot() {
//		File scrnshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		arrlist = driver.findElements(By.name("ABC"));
//	}
//	
//	
//	
//}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

public class TestClass {
	public static WebDriver driver;

	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\Eclipse_Oxy\\Drivers\\geckodriver\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.setCapability("marionette", true);
		driver = new FirefoxDriver();

		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		Actions acts = new Actions(driver);
		acts.moveToElement(driver.findElement(By.xpath("//a[text() = 'Add-Ons']"))).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath(("//a[text() = 'Hot Meals ']"))).click();
		// acts.moveToElement(driver.findElement(By.xpath("//a[text() = 'Hot Meals
		// ']"))).click().build().perform();

	}
}
