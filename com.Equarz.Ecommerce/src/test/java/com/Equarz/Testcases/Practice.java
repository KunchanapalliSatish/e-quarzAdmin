//package com.Equarz.Testcases;
//
//import java.awt.Desktop;
//import java.io.File;
//import java.io.IOException;
//
//import org.testng.IReporter;
//import org.testng.annotations.Test;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.base.Testbase;
//
//public class Practice extends Testbase  implements IReporter {
//	
//	@Test
//	public static void main() throws IOException {
//		ExtentReports extentreports = new ExtentReports();
//		File file= new File("report.html");
//		ExtentSparkReporter spark= new ExtentSparkReporter(file);
//	    extentreports.attachReporter(spark);
//	     ExtentTest test1= extentreports.createTest("Test 1");
//	     test1.pass("This is passed");
//	     
//	     ExtentTest test2= extentreports.createTest("Test 2");
//	     test2.log(Status.FAIL, "This is failed");
//	     
//	     extentreports.createTest("Test 3").skip("This is skipped");
//	     
//	    
//	    extentreports.flush();
//	    Desktop.getDesktop().browse(new File("report.html").toURI());
//		
//	}
//
//}
