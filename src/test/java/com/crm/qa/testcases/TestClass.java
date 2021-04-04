//package com.crm.qa.testcases;
//
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
